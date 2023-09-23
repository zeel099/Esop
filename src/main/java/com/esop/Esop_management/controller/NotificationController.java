package com.esop.Esop_management.controller;

import com.esop.Esop_management.payload.NotificationDto;
import com.esop.Esop_management.response.ResponseHandler;
import com.esop.Esop_management.services.NotificationService;
import org.aspectj.weaver.ast.Not;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @Autowired
    public ModelMapper modelMapper;


    @PostMapping("/compnay/{cid}/send")
    public ResponseEntity<Object> createNotification(@RequestBody NotificationDto notificationDto, @PathVariable("cid") Integer cid){
        NotificationDto createNotification = this.notificationService.createNotification(notificationDto,cid);

        return ResponseHandler.responseBuilder("notification send successfully", HttpStatus.OK,createNotification);

    }


}
