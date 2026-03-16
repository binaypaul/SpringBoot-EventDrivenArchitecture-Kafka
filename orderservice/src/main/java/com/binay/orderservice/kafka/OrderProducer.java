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

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderProducer {
    private final NewTopic topic;
    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public void sendMessage(OrderEvent orderEvent) {
        log.info(String.format("sendMessage - Order Event => %s", orderEvent.toString()));

        //create message
        Message<OrderEvent> orderMessage = MessageBuilder
                .withPayload(orderEvent)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();

        kafkaTemplate.send(orderMessage);
        log.info(String.format("sendMessage - Order Event sent => %s", orderEvent.toString()));
    }
}
