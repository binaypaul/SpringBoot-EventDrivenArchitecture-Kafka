package com.binay.notificationservice.kafka.consumer;

import com.binay.basedomains.dto.*;
import com.binay.notificationservice.NotificationUtil.NotificationTypeSelector.*;
import com.binay.notificationservice.NotificationUtil.SendingLogic.*;
import java.util.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.kafka.annotation.*;
import org.springframework.stereotype.*;

@Slf4j
@Service
public class NotificationConsumer {

    Set<String> set = new HashSet<>();
    @KafkaListener(
            topics = "${spring.kafka.consumer.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(OrderEvent orderEvent) {
        if(set.contains(orderEvent.getOrder().getOrderId())) {
            log.info("Duplicate order => {}", orderEvent.getOrder());
        } else {
            set.add(orderEvent.getOrder().getOrderId());
            SmsSendNotification sms = new SmsSendNotification(new SmsSendingLogicImpl(orderEvent.getOrder()));
            sms.sendNotification();
            EmailSendNotification email = new EmailSendNotification(new EmailSendingLogicImpl(orderEvent.getOrder()));
            email.sendNotification();
            log.info("Notification sent fot order => {}", orderEvent.getOrder());
        }
    }
}
