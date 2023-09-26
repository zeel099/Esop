package com.esop.Esop_management.services.impl;

import com.esop.Esop_management.entity.Company;
import com.esop.Esop_management.entity.Emp;
import com.esop.Esop_management.entity.Notification;
import com.esop.Esop_management.exceptions.ResourceNotFoundException;
import com.esop.Esop_management.payload.EmpDto;
import com.esop.Esop_management.payload.NotificationDto;
import com.esop.Esop_management.repositories.CompanyRepo;
import com.esop.Esop_management.repositories.EmpRepo;
import com.esop.Esop_management.repositories.NotificationRepo;
import com.esop.Esop_management.services.NotificationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal.Symbols.from;
import static org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal.Symbols.select;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    public CompanyRepo companyRepo;

    @Autowired
    public EmpRepo empRepo;

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
    public NotificationDto updateNotification(NotificationDto notificationDto, Integer nid) {

        Notification notification = this.notificationRepo.findById(nid).orElseThrow(
                ()->new ResourceNotFoundException("Notification","notification id",nid));
        notification.setNotification(notificationDto.getNotification());
        notification.setTime(notificationDto.getTime());
        Notification updateNotification = this.notificationRepo.save(notification);

        return this.modelMapper.map(updateNotification,NotificationDto.class);

    }

//    @Override
//    public NotificationDto deleteNotification(Integer nid) {
//        Notification notification = this.notificationRepo.findById(nid).orElseThrow(
//                ()->new ResourceNotFoundException("Notification","nid",nid));
//        this.notificationRepo.delete(notification);
//
//        return this.modelMapper.map(notification,NotificationDto.class);
//    }

//    @Override
//    public NotificationDto deleteNotificationByEmp(Integer eid) {
//
//        //@Query(value = "select * from Notification where emp_eid==eid")
//         Notification notification = this.notificationRepo.findByEmpId(eid);
////        Emp emp = this.empRepo.findById(eid).orElseThrow(
////                ()->new ResourceNotFoundException(("Emp","eid",eid));
//
////        Notification notification = this.notificationRepo.findById(nid).orElseThrow(
////                ()->new ResourceNotFoundException("Notification","nid",nid));
//        this.notificationRepo.delete(notification);
//
//        return this.modelMapper.map(notification,NotificationDto.class);
//    }

    @Override
    public List<NotificationDto> getNotificationByCompany(Integer cid) {
        Company company = this.companyRepo.findById(cid).orElseThrow(
                ()-> new ResourceNotFoundException("company","company id",cid));

        List<Notification>notification = this.notificationRepo.findByCompany(company);
        List<NotificationDto>notificationDtos = notification.stream()
                .map((notify)->this.modelMapper.map(notify,NotificationDto.class)).collect(Collectors.toList());
        return notificationDtos;
    }
}
