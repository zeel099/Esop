package com.esop.Esop_management.controller;

import com.esop.Esop_management.entity.Notification;
import com.esop.Esop_management.payload.EmpDto;
import com.esop.Esop_management.payload.NotificationDto;
import com.esop.Esop_management.response.ResponseHandler;
import com.esop.Esop_management.services.NotificationService;
import org.aspectj.weaver.ast.Not;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @Autowired
    public ModelMapper modelMapper;

    @CrossOrigin(origins = "*")
    @PostMapping("/company/{cid}/send")
    public ResponseEntity<Object> createNotification(@RequestBody NotificationDto notificationDto, @PathVariable("cid") Integer cid){
        NotificationDto createNotification = this.notificationService.createNotification(notificationDto,cid);

        return ResponseHandler.responseBuilder("notification sent successfully", HttpStatus.OK,createNotification);

    }

    @CrossOrigin(origins = "*")
    @PutMapping("/update/{nid}")
    public ResponseEntity<Object> updateNotification(@RequestBody NotificationDto notificationDto,@PathVariable("nid") Integer nid){
        NotificationDto updatedNotification = this.notificationService.updateNotification(notificationDto,nid);
        return ResponseHandler.responseBuilder("notification updated successfully",HttpStatus.OK,updatedNotification);

    }

//    @CrossOrigin(origins = "*")
//    @DeleteMapping("delete/{eid}")
//    public ResponseEntity<Object> deleteNotificationByEmp(@PathVariable("eid") Integer eid){
//        NotificationDto deletedNotification = this.notificationService.deleteNotificationByEmp(eid);
//        return ResponseHandler.responseBuilder("notification deleted successfully",HttpStatus.OK,deletedNotification);
//    }

    @CrossOrigin(origins = "*")
    @GetMapping("company/{cId}")
    public ResponseEntity<List<NotificationDto>> getNotificationByCompany(@PathVariable Integer cId){

        List<NotificationDto>notification = this.notificationService.getNotificationByCompany(cId);
        ResponseEntity<List<NotificationDto>> listResponseEntity = new ResponseEntity<>(notification, HttpStatus.OK);
        //return listResponseEntity;
        return new ResponseEntity<>(notification, HttpStatus.OK);
        //return new ResponseEntity<List<VestingPlanDto>>(plans,HttpStatus.OK);
    }


}
