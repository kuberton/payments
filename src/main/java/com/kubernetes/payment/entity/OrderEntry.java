package com.kubernetes.payment.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderEntry {

    private String productId;
    private BigDecimal price;
    private int quantity;
}
