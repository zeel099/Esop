package com.esop.Esop_management.controller;


import com.esop.Esop_management.entity.BuyRequest;
import com.esop.Esop_management.entity.SellRequest;
import com.esop.Esop_management.payload.SellRequestDto;
import com.esop.Esop_management.response.ResponseHandler;
import com.esop.Esop_management.services.SellRequestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/request")
public class SellRequestController {

    @Autowired
    private SellRequestService sellRequestService;

    @Autowired
    private ModelMapper modelMapper;

    @CrossOrigin(origins = "*")
    @PostMapping("/company/{cId}/emp/{eId}/send")
    public ResponseEntity<Object> cretateRequest(@RequestBody SellRequestDto sellRequestDto, @PathVariable("cId") Integer cId, @PathVariable("eId") Integer eId) {
        SellRequestDto sellRequest = this.sellRequestService.cretateRequest(sellRequestDto, cId, eId);

        return ResponseHandler.responseBuilder("request sent successfully", HttpStatus.OK, sellRequest);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/send")
    public ResponseEntity<List<SellRequestDto>> getAllRequest(){
    		return ResponseEntity.ok(this.sellRequestService.getAllRequest());
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/{reqId}/update")
    public ResponseEntity<Object>updateRequest(@RequestBody SellRequestDto sellRequestDto,@PathVariable("reqId") Integer reqId){
        SellRequestDto updateRequest = this.sellRequestService.updateRequest(sellRequestDto,reqId);

        return ResponseHandler.responseBuilder("request updated successfully",HttpStatus.OK,updateRequest);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{sellReqId}/delete")
    public ResponseEntity<Object>deleteSellRequest(@PathVariable("sellReqId") Integer sellReqId){
        SellRequestDto deletedRequest = this.sellRequestService.deleteSellRequest(sellReqId);
        return ResponseHandler.responseBuilder("deleted sucessfully",HttpStatus.OK,deletedRequest);
    }


}
