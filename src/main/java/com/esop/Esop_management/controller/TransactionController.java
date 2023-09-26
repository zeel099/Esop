package com.esop.Esop_management.controller;

import com.esop.Esop_management.payload.TransactionDto;
import com.esop.Esop_management.response.ResponseHandler;
import com.esop.Esop_management.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tansaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @CrossOrigin(origins = "*")
    @PostMapping("/company/{cId}/emp/{eId}/buy")
    public ResponseEntity<Object> buyEsop(@RequestBody TransactionDto transactionDto, @PathVariable("cId") Integer cId, @PathVariable("eId") Integer eId){
        TransactionDto transaction = this.transactionService.buyEsop(transactionDto,cId,eId);

        return ResponseHandler.responseBuilder("transaction successfully", HttpStatus.OK,transaction);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/company/{comId}/emp/{empId}/sell")
    public ResponseEntity<Object> sellEsop(@RequestBody TransactionDto transactionDto, @PathVariable("comId") Integer comId, @PathVariable("empId") Integer empId){
        TransactionDto transaction = this.transactionService.sellEsop(transactionDto,comId,empId);

        return ResponseHandler.responseBuilder("transaction successfully", HttpStatus.OK,transaction);
    }

}
