package com.kubernetes.payment.rest.conntector;

import com.kubernetes.payment.dto.BasketState;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Component
public class BasketRestConnector {

    @Value("#{environment.BASKET_SERVICE_HOST}")
    private String host;

    @Autowired
    private RestTemplate restTemplate;

    public BasketState retrieveCurrentBasketState(String uid) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("X-Auth", uid);
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        return restTemplate.exchange(host + "/v1/" + uid, HttpMethod.POST, entity, BasketState.class).getBody();
    }

    public void clearBasket(String uid) {
        restTemplate.delete(host+"/v1/"+uid);
    }
}
