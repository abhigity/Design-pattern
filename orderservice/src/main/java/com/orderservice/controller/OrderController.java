package com.orderservice.controller;

import com.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //for real time monitoring of circuit breaker and health status of the application, we can use actuator endpoints
    //http://localhost:8081/actuator/circuitbreakers
    //http://localhost:8081/actuator/health

    //http://localhost:8081/order/101
    @GetMapping("/{orderId}")
    public String placeOrder(@PathVariable String orderId) {
        return orderService.placeOrder(orderId);
    }
}
