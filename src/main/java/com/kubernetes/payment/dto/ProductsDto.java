package com.kubernetes.payment.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ProductsDto {

    private List<Product> products;

    @Getter
    @Setter
    public static class Product {

        private String productId;
        private BigDecimal price;
    }
}
