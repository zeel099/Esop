package com.esop.Esop_management.services.impl;

import com.esop.Esop_management.entity.Company;
import com.esop.Esop_management.entity.Emp;
import com.esop.Esop_management.entity.Transaction;
import com.esop.Esop_management.exceptions.ResourceNotFoundException;
import com.esop.Esop_management.payload.TransactionDto;
import com.esop.Esop_management.repositories.CompanyRepo;
import com.esop.Esop_management.repositories.EmpRepo;
import com.esop.Esop_management.repositories.TransactionRepo;
import com.esop.Esop_management.services.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepo transactionRepo;

    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private EmpRepo empRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TransactionDto buyEsop(TransactionDto transactionDto, Integer cId, Integer eId) {
        Company company = this.companyRepo.findById(cId).orElseThrow(
                ()-> new ResourceNotFoundException("Company","cId",cId));

        Emp emp = this.empRepo.findById(eId).orElseThrow(
                ()->new ResourceNotFoundException("Emp","eId",eId));

        Transaction transaction = this.modelMapper.map(transactionDto,Transaction.class);
        transaction.setCompany(company);
        transaction.setEmp(emp);

        Transaction savedTransaction = this.transactionRepo.save(transaction);
        return this.modelMapper.map(savedTransaction,TransactionDto.class);

    }

    @Override
    public TransactionDto sellEsop(TransactionDto transactionDto, Integer comId, Integer empId) {
        Company company = this.companyRepo.findById(comId).orElseThrow(
                ()-> new ResourceNotFoundException("Company","comId",comId));

        Emp emp = this.empRepo.findById(empId).orElseThrow(
                ()->new ResourceNotFoundException("Emp","empId",empId));

        Transaction transaction = this.modelMapper.map(transactionDto,Transaction.class);
        transaction.setCompany(company);
        transaction.setEmp(emp);

        Transaction savedTransaction = this.transactionRepo.save(transaction);
        return this.modelMapper.map(savedTransaction,TransactionDto.class);
        //return null;
    }

    @Override
    public List<TransactionDto> getAllTransaction() {
        return null;
    }

    @Override
    public List<TransactionDto> getAllTransactionByEmp(Integer eId) {
        return null;
    }

    @Override
    public List<TransactionDto> getAllTransactionByCompany(Integer cId) {
        return null;
    }
}
