package com.kubernetes.payment.rest.conntector;

import com.kubernetes.payment.dto.ProductsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class ProductRestConnector {

    @Value("#{environment.PRODUCTS_SERVICE_HOST}")
    private final RestTemplate restTemplate;

    public ProductsDto getProducts() {
        ProductsDto productsDto = new ProductsDto();
        productsDto.setProducts(Collections.emptyList());
        return productsDto;
    }
}
