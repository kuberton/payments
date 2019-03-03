package com.kubernetes.payment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentData {

    private String cardNumber;
    private String cvvCode;
    private String expirationDate;
}
