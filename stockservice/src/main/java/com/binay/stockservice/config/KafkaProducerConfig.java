package com.binay.stockservice.config;

import com.binay.basedomains.dto.*;
import java.util.*;
import javax.swing.*;
import org.apache.kafka.clients.producer.*;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.*;
import org.springframework.kafka.core.*;
import org.springframework.kafka.transaction.*;
import org.springframework.transaction.annotation.*;
//# Spring Kafka, "Exactly-Once" semantics (EOS)
@Configuration
public class KafkaProducerConfig {

    @Bean
    public ProducerFactory<String, OrderEvent> processedEventProducerFactory(KafkaProperties kafkaProperties) {
        Map<String, Object> props = kafkaProperties.buildProducerProperties();
        return new DefaultKafkaProducerFactory<>(props);
    }

    @Bean
    public KafkaTransactionManager<String, OrderEvent> kafkaTransactionManager(
            ProducerFactory<String, OrderEvent> processedEventProducerFactory) {
        return new KafkaTransactionManager<>(processedEventProducerFactory);
    }

    @Bean
    public KafkaTemplate<String, OrderEvent> orderProcessedKafkaTemplate(ProducerFactory<String, OrderEvent> processedEventProducerFactory) {
        return new KafkaTemplate<>(processedEventProducerFactory);
    }
}
