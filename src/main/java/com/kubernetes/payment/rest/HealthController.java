package com.kubernetes.payment.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HealthController {

    @GetMapping("/health")
    public ResponseEntity health() {
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
