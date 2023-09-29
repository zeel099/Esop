package com.esop.Esop_management.services;

import com.esop.Esop_management.entity.Grant_Transaction;
import com.esop.Esop_management.payload.GarntTransactionDto;

import java.util.List;

public interface GarntTransactionService {

    GarntTransactionDto grantEsop(GarntTransactionDto transactionDto, Integer cId, Integer eId);

    GarntTransactionDto sellEsop(GarntTransactionDto transactionDto, Integer comId, Integer empId);

    List<GarntTransactionDto> getAllTransaction();
    List<GarntTransactionDto> getAllTransactionByEmp(Integer eId);

    List<GarntTransactionDto> getAllTransactionByCompany(Integer cId);

    GarntTransactionDto deleteTransaction(Integer gId);
}
