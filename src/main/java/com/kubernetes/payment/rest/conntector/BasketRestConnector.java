package com.kubernetes.payment.rest.conntector;

import com.kubernetes.payment.dto.BasketState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class BasketRestConnector {

    private RestTemplate restTemplate;

    public BasketState retrieveCurrentBasketState(String uid) {
        //todo add static ip address instead of mock data
        BasketState basketState = new BasketState();
        basketState.setOrderEntries(Collections.emptyList());
        return basketState;
    }

    public void clearBasket(String uid) {
    }
}
