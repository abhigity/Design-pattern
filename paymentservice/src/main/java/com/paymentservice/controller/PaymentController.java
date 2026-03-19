package com.paymentservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @GetMapping("/{orderId}")
    public String processPayment(@PathVariable String orderId) {

        if (Math.random() < 0.6) {//simulate 50% failure rate
            throw new RuntimeException("Payment Service Down");
        }

        return "Payment successful for Order: " + orderId;
    }
}