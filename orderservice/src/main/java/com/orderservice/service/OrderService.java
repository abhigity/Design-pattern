package com.orderservice.service;

import com.orderservice.client.PaymentClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private PaymentClient paymentClient;

    @CircuitBreaker(name = "paymentService", fallbackMethod = "fallbackMethod")
    public String placeOrder(String orderId) {
        return paymentClient.processPayment(orderId);
    }

    public String fallbackMethod(String orderId, Throwable ex) {
        System.out.println("Error: " + ex.getMessage());
        return "Fallback triggered: Payment service is down";
    }
}
