package com.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//, fallback = PaymentFallback.class
@FeignClient(name = "payment-service")
public interface PaymentClient {

    @GetMapping("/payment/{orderId}")
    String processPayment(@PathVariable String orderId);
}