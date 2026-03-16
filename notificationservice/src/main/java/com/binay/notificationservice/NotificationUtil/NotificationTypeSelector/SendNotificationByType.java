package com.binay.notificationservice.NotificationUtil.NotificationTypeSelector;

import com.binay.basedomains.dto.*;
import com.binay.notificationservice.NotificationUtil.SendingLogic.*;
import lombok.*;
import org.springframework.stereotype.*;

public class SendNotificationByType {
    private final SendingLogic sendingLogic;

    public SendNotificationByType(SendingLogic sendingLogic) {
        this.sendingLogic = sendingLogic;
    }

    public void sendNotification() {
        sendingLogic.sendNotification();
    }
}
