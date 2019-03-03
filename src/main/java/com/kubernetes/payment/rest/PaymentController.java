package com.kubernetes.payment.rest;

import com.kubernetes.payment.dto.PaymentData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.kubernetes.payment.service.PaymentService;

@RequiredArgsConstructor
@RestController
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/v1/pay")
    public ResponseEntity pay(@RequestBody PaymentData paymentData, @RequestHeader("X-Auth") String uid) {
        if (uid == null) {
            ResponseEntity.status(HttpStatus.FORBIDDEN).body("Request uid header is missing");
        }

        paymentService.processPayment(uid);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
