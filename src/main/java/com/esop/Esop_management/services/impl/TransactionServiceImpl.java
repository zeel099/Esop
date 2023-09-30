package com.esop.Esop_management.services.impl;

import com.esop.Esop_management.entity.BuyRequest;
import com.esop.Esop_management.entity.Company;
import com.esop.Esop_management.entity.SellRequest;
import com.esop.Esop_management.entity.Transaction;
import com.esop.Esop_management.exceptions.ResourceNotFoundException;
import com.esop.Esop_management.payload.SellRequestDto;
import com.esop.Esop_management.payload.TransactionDto;
import com.esop.Esop_management.repositories.BuyRequestRepo;
import com.esop.Esop_management.repositories.CompanyRepo;
import com.esop.Esop_management.repositories.SellRequestRepo;
import com.esop.Esop_management.repositories.TransactionRepo;
import com.esop.Esop_management.response.ResponseHandler;
import com.esop.Esop_management.services.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepo transactionRepo;

    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private BuyRequestRepo buyRequestRepo;

    @Autowired
    private SellRequestRepo sellRequestRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TransactionDto createTransaction(TransactionDto transactionDto, Integer cId,Integer buyerId,Integer sellerId) {
        Company company = this.companyRepo.findById(cId).orElseThrow(
                ()->new ResourceNotFoundException("Company","cId",cId));
        BuyRequest buyRequest = this.buyRequestRepo.findById(buyerId).orElseThrow(
                ()->new ResourceNotFoundException("BuyRequest","buyerId",buyerId));
        SellRequest sellRequest = this.sellRequestRepo.findById(sellerId).orElseThrow(
                ()->new ResourceNotFoundException("SellRequest","sellerId",sellerId));

        Transaction transaction = this.modelMapper.map(transactionDto,Transaction.class);
        transaction.setCompany(company);
        transaction.setBuyRequest(buyRequest);
        transaction.setSellRequest(sellRequest);

        Transaction transactionDto1 = this.transactionRepo.save(transaction);

        return this.modelMapper.map(transaction,TransactionDto.class);
    }

    @Override
    public List<TransactionDto> getAllTransaction() {
        List<Transaction>transaction = this.transactionRepo.findAll();
        List<TransactionDto>transactionList = transaction.stream().map(tran->this.modelMapper.map(tran,TransactionDto.class)).collect(Collectors.toList());
        return transactionList;

    }
}
