package com.esop.Esop_management.services;

import com.esop.Esop_management.entity.Notification;
import com.esop.Esop_management.payload.EmpDto;
import com.esop.Esop_management.payload.NotificationDto;

import java.util.List;

public interface NotificationService {
    NotificationDto createNotification(NotificationDto notificationDto,Integer cid);

    NotificationDto updateNotification(NotificationDto notificationDto,Integer nid);



    //NotificationDto deleteNotificationByEmp(Integer eid);
    List<NotificationDto> getNotificationByCompany(Integer cid);
}
