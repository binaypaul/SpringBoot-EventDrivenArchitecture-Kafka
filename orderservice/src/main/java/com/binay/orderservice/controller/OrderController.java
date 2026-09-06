package com.binay.orderservice.controller;

import com.binay.basedomains.dto.*;
import com.binay.orderservice.kafka.*;
import java.util.*;
import lombok.*;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class OrderController {
    private final OrderProducer orderProducer;

    @PostMapping("/createorder")
    public String createOrder(@RequestBody Order order) {
        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderEvent = new OrderEvent("Created order!", OrderStatus.CREATED, order);
        orderProducer.sendMessage(orderEvent);

        return String.format("Order placed successfully! Order ID => %s", order.getOrderId());
    }
}