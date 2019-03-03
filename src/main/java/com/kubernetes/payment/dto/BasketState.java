package com.kubernetes.payment.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BasketState {

    private List<BasketEntry> orderEntries;

    @Getter
    public class BasketEntry {

        private String productId;
        private int quantity;
    }

    public int getQuantityForProduct(String productId) {
        BasketEntry basketEntry = orderEntries.stream().filter(orderEntry -> productId.equals(orderEntry.getProductId())).findFirst().orElse(null);
        if(basketEntry != null) {
            return basketEntry.getQuantity();
        }
        return 0;
    }
}