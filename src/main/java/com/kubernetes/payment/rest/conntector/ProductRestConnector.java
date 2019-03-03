package com.kubernetes.payment.rest.conntector;

import com.kubernetes.payment.dto.ProductsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class ProductRestConnector {

    private final RestTemplate restTemplate;

    public ProductsDto getProducts() {
        //todo add static ip address instead of mock data
        ProductsDto productsDto = new ProductsDto();
        productsDto.setProducts(Collections.emptyList());
        return productsDto;
    }
}
