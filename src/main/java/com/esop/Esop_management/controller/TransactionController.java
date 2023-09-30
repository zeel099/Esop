package com.esop.Esop_management.controller;

import com.esop.Esop_management.entity.Transaction;
import com.esop.Esop_management.payload.TransactionDto;
import com.esop.Esop_management.response.ResponseHandler;
import com.esop.Esop_management.services.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private ModelMapper modelMapper;

    @CrossOrigin(origins = "*")
    @PostMapping("Company/{cId}/BuyRequest/{buyerId}/SellRequest/{sellerId}")
    public ResponseEntity<Object>createTransaction(@RequestBody TransactionDto transactionDto ,@PathVariable("cId") Integer cId,
                                @PathVariable("buyerId") Integer buyerId,
                                                   @PathVariable("sellerId") Integer sellerId){
        TransactionDto transcation = this.transactionService.createTransaction(transactionDto,cId,buyerId,sellerId);
        return ResponseHandler.responseBuilder("transactino successfull", HttpStatus.OK,transcation);
    }

    @CrossOrigin(origins="*")
    @GetMapping("/allTransaction")
    public ResponseEntity<List<TransactionDto>>getAllTransaction(){
        return ResponseEntity.ok(this.transactionService.getAllTransaction());
    }

}
