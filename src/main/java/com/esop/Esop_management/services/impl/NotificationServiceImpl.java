package com.esop.Esop_management.services.impl;

import com.esop.Esop_management.entity.Company;
import com.esop.Esop_management.entity.Notification;
import com.esop.Esop_management.exceptions.ResourceNotFoundException;
import com.esop.Esop_management.payload.NotificationDto;
import com.esop.Esop_management.repositories.CompanyRepo;
import com.esop.Esop_management.repositories.NotificationRepo;
import com.esop.Esop_management.services.NotificationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    public CompanyRepo companyRepo;


    @Autowired
    public NotificationRepo notificationRepo;

    @Autowired
    public ModelMapper modelMapper;

    @Override
    public NotificationDto createNotification(NotificationDto notificationDto,Integer cid) {
        Company company = this.companyRepo.findById(cid).orElseThrow(
                ()->new ResourceNotFoundException("Company","companyid",cid));

        Notification notification = this.modelMapper.map(notificationDto,Notification.class);
        notification.setCompany(company);
        Notification newNotification = this.notificationRepo.save(notification);

        return this.modelMapper.map(notification,NotificationDto.class);
    }

    @Override
    public NotificationDto uodtaeNotification(NotificationDto notificationDto, Integer nid) {
        return null;
    }
}
