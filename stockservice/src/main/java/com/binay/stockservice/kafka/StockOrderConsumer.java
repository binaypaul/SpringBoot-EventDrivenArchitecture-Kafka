package com.binay.stockservice.kafka;

import com.binay.basedomains.dto.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.kafka.annotation.*;
import org.springframework.stereotype.*;

@Slf4j
@RequiredArgsConstructor
@Service
public class StockOrderConsumer {

    @KafkaListener(
            topics = "${spring.kafka.consumer.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public String consumeOrder(OrderEvent orderEvent) {
        log.info(String.format("Order received in stock service => %s", orderEvent.toString()));

        // update order stock in database.

        return String.format("Stock updated successfully! Order ID => %s", orderEvent.getOrder().getOrderId());
    }
}
