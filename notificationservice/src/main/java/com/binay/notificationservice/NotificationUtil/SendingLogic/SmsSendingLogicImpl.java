package com.binay.notificationservice.NotificationUtil.SendingLogic;

import com.binay.basedomains.dto.*;
import lombok.*;
import lombok.extern.slf4j.*;

@Slf4j
public class SmsSendingLogicImpl implements SendingLogic {
    private final Order order;

    public SmsSendingLogicImpl(Order order) {
        this.order = order;
    }

    @Override
    public void sendNotification() {
        log.info("Sent SMS Notification for orderId => {}", this.order.getOrderId());
    }
}
