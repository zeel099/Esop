package com.esop.Esop_management.services;

import com.esop.Esop_management.entity.Transaction;
import com.esop.Esop_management.payload.TransactionDto;

import java.util.List;

public interface TransactionService {

    TransactionDto buyEsop(TransactionDto transactionDto,Integer cId,Integer eId);

    TransactionDto sellEsop(TransactionDto transactionDto,Integer comId,Integer empId);

    List<TransactionDto> getAllTransaction();
    List<TransactionDto> getAllTransactionByEmp(Integer eId);

    List<TransactionDto> getAllTransactionByCompany(Integer cId);
}
