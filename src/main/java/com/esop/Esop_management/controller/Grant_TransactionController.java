package com.esop.Esop_management.controller;

import com.esop.Esop_management.entity.Emp;
import com.esop.Esop_management.entity.Grant_Transaction;
import com.esop.Esop_management.payload.EmpDto;
import com.esop.Esop_management.payload.GarntTransactionDto;
import com.esop.Esop_management.payload.VestingPlanDto;
import com.esop.Esop_management.response.ResponseHandler;
import com.esop.Esop_management.services.GarntTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/grant_transaction")
public class Grant_TransactionController {

    @Autowired
    GarntTransactionService grantTransactionService;

    @CrossOrigin(origins = "*")
    @PostMapping("/company/{cId}/emp/{eId}/grant")
    public ResponseEntity<Object> grantEsop(@RequestBody GarntTransactionDto transactionDto, @PathVariable("cId") Integer cId, @PathVariable("eId") Integer eId){
        GarntTransactionDto transaction = this.grantTransactionService.grantEsop(transactionDto,cId,eId);

        return ResponseHandler.responseBuilder("transaction successfully", HttpStatus.OK,transaction);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/company/{comId}/emp/{empId}/sell")
    public ResponseEntity<Object> sellEsop(@RequestBody GarntTransactionDto transactionDto, @PathVariable("comId") Integer comId, @PathVariable("empId") Integer empId){
        GarntTransactionDto transaction = this.grantTransactionService.sellEsop(transactionDto,comId,empId);

        return ResponseHandler.responseBuilder("transaction successfully", HttpStatus.OK,transaction);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/grant_transaction")
    public ResponseEntity<List<GarntTransactionDto>> getAllTransaction(){

//
        return ResponseEntity.ok(this.grantTransactionService.getAllTransaction());
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/company/{cId}")
    public ResponseEntity<Object> getAllTransactionByCompany(@PathVariable("cId") Integer cId){

        List<GarntTransactionDto>transaction = this.grantTransactionService.getAllTransactionByCompany(cId);
        ResponseEntity<List<GarntTransactionDto>> transactionList = new ResponseEntity<>(transaction, HttpStatus.OK);

        return ResponseHandler.responseBuilder("get transaction history",HttpStatus.OK,transaction);

    }

    @CrossOrigin("*")
    @DeleteMapping("/{gtId}/delete")
    public ResponseEntity<Object> deleteTransaction(@PathVariable("gtId") Integer gtId){
        GarntTransactionDto gtDto = this.grantTransactionService.deleteTransaction(gtId);
        return ResponseHandler.responseBuilder("Delete successfully",HttpStatus.OK,gtDto);
    }


}
