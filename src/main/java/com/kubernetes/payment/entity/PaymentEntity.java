package com.kubernetes.payment.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class
PaymentEntity {

    private String uid;
    private List<OrderEntry> orderEntries;
    private BigDecimal totalAmount;

    public void calculateTotal() {
        totalAmount = orderEntries.stream()
                .map(orderEntry -> orderEntry.getPrice().multiply(BigDecimal.valueOf(orderEntry.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
