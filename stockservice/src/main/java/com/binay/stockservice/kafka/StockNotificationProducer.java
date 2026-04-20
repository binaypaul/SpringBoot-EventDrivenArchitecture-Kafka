package com.binay.stockservice.kafka;

import com.binay.basedomains.dto.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.apache.kafka.clients.admin.*;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.*;
import org.springframework.messaging.*;
import org.springframework.messaging.support.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Slf4j
@Service
public class StockNotificationProducer {

    private final NewTopic topic;

    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public void produceStockNotification(OrderEvent orderEvent) {
        log.info("produceStockNotification - Order Event => {}", orderEvent.toString());

        orderEvent.setMessage("Order placed!");
        orderEvent.setStatus(OrderStatus.PLACED);

        //create sms notification message
        Message<OrderEvent> notificationMessage = MessageBuilder
                .withPayload(orderEvent)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();

        kafkaTemplate.send(notificationMessage);

        log.info("produceStockNotification - Order Event sent => {}", orderEvent.toString());
    }
}
