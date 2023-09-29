package com.esop.Esop_management.services.impl;

import com.esop.Esop_management.entity.Company;
import com.esop.Esop_management.entity.Emp;
import com.esop.Esop_management.entity.Grant_Transaction;
import com.esop.Esop_management.exceptions.ResourceNotFoundException;
import com.esop.Esop_management.payload.GarntTransactionDto;
import com.esop.Esop_management.repositories.CompanyRepo;
import com.esop.Esop_management.repositories.EmpRepo;
import com.esop.Esop_management.repositories.GarntTransactionRepo;
import com.esop.Esop_management.services.GarntTransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GarntTransactionServiceImpl implements GarntTransactionService {

    @Autowired
    private GarntTransactionRepo transactionRepo;

    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private EmpRepo empRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public GarntTransactionDto grantEsop(GarntTransactionDto transactionDto, Integer cId, Integer eId) {
        Company company = this.companyRepo.findById(cId).orElseThrow(
                ()-> new ResourceNotFoundException("Company","cId",cId));

        Emp emp = this.empRepo.findById(eId).orElseThrow(
                ()->new ResourceNotFoundException("Emp","eId",eId));

        Grant_Transaction transaction = this.modelMapper.map(transactionDto, Grant_Transaction.class);
        transaction.setCompany(company);
        transaction.setEmp(emp);

        Grant_Transaction savedTransaction = this.transactionRepo.save(transaction);
        return this.modelMapper.map(savedTransaction, GarntTransactionDto.class);

    }

    @Override
    public GarntTransactionDto sellEsop(GarntTransactionDto transactionDto, Integer comId, Integer empId) {
        Company company = this.companyRepo.findById(comId).orElseThrow(
                ()-> new ResourceNotFoundException("Company","comId",comId));

        Emp emp = this.empRepo.findById(empId).orElseThrow(
                ()->new ResourceNotFoundException("Emp","empId",empId));

        Grant_Transaction transaction = this.modelMapper.map(transactionDto, Grant_Transaction.class);
        transaction.setCompany(company);
        transaction.setEmp(emp);

        Grant_Transaction savedTransaction = this.transactionRepo.save(transaction);
        return this.modelMapper.map(savedTransaction, GarntTransactionDto.class);
        //return null;
    }

    @Override
    public List<GarntTransactionDto> getAllTransaction() {

        return null;
    }

    @Override
    public List<GarntTransactionDto> getAllTransactionByEmp(Integer eId) {


        return null;
    }

    @Override
    public List<GarntTransactionDto> getAllTransactionByCompany(Integer cId) {
        Company company = this.companyRepo.findById(cId).orElseThrow(()->new ResourceNotFoundException("company","cId",cId));

        List<Grant_Transaction>list = this.transactionRepo.findByCompany(company);

        List<GarntTransactionDto>tarnsactionList = list.stream().map((transaction)->this.modelMapper.map(transaction,GarntTransactionDto.class)).collect(Collectors.toList());

        return tarnsactionList;
    }

    @Override
    public GarntTransactionDto deleteTransaction(Integer gtId) {

        Grant_Transaction grantTransaction = this.transactionRepo.findById(gtId).orElseThrow(
                ()->new ResourceNotFoundException("Grant_Transaction","gtId",gtId));

        this.transactionRepo.delete(grantTransaction);
        return this.modelMapper.map(grantTransaction,GarntTransactionDto.class);
    }
}
