package com.esop.Esop_management.services;

import com.esop.Esop_management.entity.Transaction;
import com.esop.Esop_management.payload.TransactionDto;

import java.util.List;

public interface TransactionService {

    TransactionDto createTransaction(TransactionDto transactionDto, Integer cId,Integer buyerId,Integer sellerId);

    List<TransactionDto> getAllTransaction();
}
