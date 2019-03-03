package com.kubernetes.payment.service;

import com.kubernetes.payment.dto.BasketState;
import com.kubernetes.payment.dto.ProductsDto;
import com.kubernetes.payment.entity.OrderEntry;
import com.kubernetes.payment.entity.PaymentEntity;
import com.kubernetes.payment.rest.conntector.BasketRestConnector;
import com.kubernetes.payment.rest.conntector.ProductRestConnector;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final BasketRestConnector basketRestConnector;
    private final EmailService emailService;
    private final ProductRestConnector productRestConnector;

    public void processPayment(String uid) {
        BasketState basketState = basketRestConnector.retrieveCurrentBasketState(uid);
        basketRestConnector.clearBasket(uid);
        //todo add saving
        emailService.sendEmail(uid);
    }

    private void savePaymentInfo(List<BasketState.BasketEntry> basketEntries) {
        List<String> productIds = basketEntries.stream()
                .map(BasketState.BasketEntry::getProductId)
                .collect(Collectors.toList());

        ProductsDto products = productRestConnector.getProducts();
        List<OrderEntry> orderEntries = products.getProducts().stream()
                .filter(product -> productIds.contains(product.getProductId()))
                .map(this::convertToPaymentEntity)
                .collect(Collectors.toList());

        //todo calculate total price
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setOrderEntries(orderEntries);
        paymentEntity.calculateTotal();
    }

    private OrderEntry convertToPaymentEntity(ProductsDto.Product product) {
        OrderEntry orderEntry = new OrderEntry();
        orderEntry.setPrice(product.getPrice());
        orderEntry.setProductId(product.getProductId());
        return orderEntry;
    }

}
