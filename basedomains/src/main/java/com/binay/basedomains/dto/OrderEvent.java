package com.binay.basedomains.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEvent {
    private String message;
    private OrderStatus status;
    private Order order;
}
