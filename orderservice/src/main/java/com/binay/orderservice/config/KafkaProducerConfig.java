package com.binay.orderservice.config;

import com.binay.basedomains.dto.*;
import java.util.*;
import org.springframework.boot.autoconfigure.kafka.*;
import org.springframework.context.annotation.*;
import org.springframework.kafka.core.*;
import org.springframework.kafka.transaction.*;

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
