package com.esop.Esop_management.services;

import com.esop.Esop_management.entity.Notification;
import com.esop.Esop_management.payload.NotificationDto;

public interface NotificationService {
    NotificationDto createNotification(NotificationDto notificationDto,Integer cid);

    NotificationDto uodtaeNotification(NotificationDto notificationDto,Integer nid);
}
