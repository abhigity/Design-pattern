package com.orderservice.client;


public class PaymentFallback implements PaymentClient{

    //other approach

    @Override
    public String processPayment(String orderId) {
        return "Payment Service is DOWN (Fallback Response)";
    }
}
