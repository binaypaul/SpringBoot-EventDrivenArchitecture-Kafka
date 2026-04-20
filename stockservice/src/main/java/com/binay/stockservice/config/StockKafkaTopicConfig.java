package com.binay.stockservice.config;

import lombok.*;
import org.apache.kafka.clients.admin.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.kafka.config.*;

@RequiredArgsConstructor
@Configuration
public class StockKafkaTopicConfig {
    @Value("${spring.kafka.producer.topic.name}")
    private String producerTopicName;

    @Bean
    public NewTopic newTopic() {
        return TopicBuilder
                .name(producerTopicName)
                .partitions(2)
                .build();
    }
}