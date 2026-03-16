package com.binay.notificationservice.NotificationUtil.NotificationTypeSelector;

import com.binay.notificationservice.NotificationUtil.SendingLogic.*;

public class SmsSendNotification extends SendNotificationByType {
    public SmsSendNotification(SendingLogic sendingLogic) {
        super(sendingLogic);
    }
}
