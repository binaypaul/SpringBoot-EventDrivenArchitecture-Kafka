package com.binay.notificationservice.NotificationUtil.SendingLogic;

import com.binay.basedomains.dto.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.stereotype.*;

@Slf4j
public class EmailSendingLogicImpl implements SendingLogic {
    private final Order order;

    public EmailSendingLogicImpl(Order order) {
        this.order = order;
    }

    @Override
    public void sendNotification() {
        log.info("Sent Email Notification for orderId => {}", this.order.getOrderId());
    }
}
