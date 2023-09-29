package com.esop.Esop_management.controller;

import com.esop.Esop_management.entity.BuyRequest;
import com.esop.Esop_management.payload.BuyRequestDto;
import com.esop.Esop_management.response.ResponseHandler;
import com.esop.Esop_management.services.BuyRequestService;
import com.google.j2objc.annotations.AutoreleasePool;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.pool.TypePool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buyrequest")
public class BuyRequestController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BuyRequestService buyRequestService;

    @CrossOrigin(origins = "*")
    @PostMapping("/emp/{eId}/sellRequest/{sellReqId}/send")
    public ResponseEntity<Object> createBuyRequest(@RequestBody BuyRequestDto buyRequestDto ,@PathVariable("eId") Integer eId,@PathVariable("sellReqId") Integer sellReqId){
        BuyRequestDto buyRequest = this.buyRequestService.createBuyRequest(buyRequestDto,eId,sellReqId);

        return ResponseHandler.responseBuilder("Buy request successfully", HttpStatus.OK,buyRequest);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/{reqId}/update")
    public ResponseEntity<Object> updateBuyRequest(@RequestBody BuyRequestDto buyRequestDto,@PathVariable("reqId") Integer reqId){
        BuyRequestDto buyRequest = this.buyRequestService.updateBuyRequest(buyRequestDto,reqId);
        return ResponseHandler.responseBuilder("updated successfully", HttpStatus.OK,buyRequest);
    }

    @CrossOrigin(origins="*")
    @GetMapping("/allRequest")
    public ResponseEntity<List<BuyRequestDto>>getAllBuyRequest(){

        return ResponseEntity.ok(this.buyRequestService.getAllBuyRequest());
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{buyReqId}/delete")
    public ResponseEntity<Object> deleteBuyRequest(@PathVariable("buyReqId") Integer buyReqId){
        BuyRequestDto deletedRequest = this.buyRequestService.deleteBuyRequest(buyReqId);
        return ResponseHandler.responseBuilder("deleted successfully",HttpStatus.OK,deletedRequest);
    }
}
