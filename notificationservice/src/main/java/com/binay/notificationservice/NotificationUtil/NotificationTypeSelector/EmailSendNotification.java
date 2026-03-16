package com.binay.notificationservice.NotificationUtil.NotificationTypeSelector;

import com.binay.notificationservice.NotificationUtil.SendingLogic.*;

public class EmailSendNotification extends SendNotificationByType {
    public EmailSendNotification(SendingLogic sendingLogic) {
        super(sendingLogic);
    }
}