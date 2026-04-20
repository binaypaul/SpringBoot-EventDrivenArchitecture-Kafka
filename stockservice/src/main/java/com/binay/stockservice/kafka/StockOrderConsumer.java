package com.binay.stockservice.kafka;

import com.binay.basedomains.dto.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.kafka.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class StockOrderConsumer {
    private final StockNotificationProducer snProducer;

    @KafkaListener(
            topics = "${spring.kafka.consumer.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public String consumeOrder(OrderEvent orderEvent) {
        log.info("Order received in stock service => {}", orderEvent.toString());

        // TODO: update order stock in database. will need @Transactional to implement database transaction.

        // produce stock notification
        snProducer.produceStockNotification(orderEvent);

        return String.format("Stock updated successfully! Order ID => %s", orderEvent.getOrder().getOrderId());
    }
}
