package com.binay.orderservice.kafka;

import com.binay.basedomains.dto.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.apache.kafka.clients.admin.*;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.*;
import org.springframework.messaging.*;
import org.springframework.messaging.support.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderProducer {
    private final NewTopic topic;
    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

//    @Transactional is also required when we are consuming a message -> CRUD to our database. Basically for database transaction, not for kafka.
    public void sendMessage(OrderEvent orderEvent) {
        log.info("sendMessage - Order Event => {}", orderEvent.toString());

        //create message
        Message<OrderEvent> orderMessage = MessageBuilder
                .withPayload(orderEvent)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();

        kafkaTemplate.send(orderMessage);
        log.info("sendMessage - Order Event sent => {}", orderEvent.toString());
    }
}
