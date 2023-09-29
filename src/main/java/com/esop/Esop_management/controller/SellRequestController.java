package com.esop.Esop_management.controller;


import com.esop.Esop_management.entity.SellRequest;
import com.esop.Esop_management.payload.SellRequestDto;
import com.esop.Esop_management.response.ResponseHandler;
import com.esop.Esop_management.services.SellRequestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/request")
public class SellRequestController {

    @Autowired
    private SellRequestService sellRequestService;

    @Autowired
    private ModelMapper modelMapper;

    @CrossOrigin(origins = "*")
    @PutMapping("/company/{cId}/emp/{eId}/send")
    public ResponseEntity<Object>cretateRequest(@RequestBody SellRequestDto sellRequestDto,@PathVariable("cId") Integer cId,@PathVariable("eId") Integer eId){
        SellRequestDto sellRequest = this.sellRequestService.cretateRequest(sellRequestDto,cId,eId);

        return ResponseHandler.responseBuilder("request sent successfully", HttpStatus.OK,sellRequest);
    }



}
