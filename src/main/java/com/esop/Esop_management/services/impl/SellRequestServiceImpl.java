package com.esop.Esop_management.services.impl;

import com.esop.Esop_management.entity.Company;
import com.esop.Esop_management.entity.Emp;
import com.esop.Esop_management.entity.SellRequest;
import com.esop.Esop_management.exceptions.ResourceNotFoundException;
import com.esop.Esop_management.payload.SellRequestDto;
import com.esop.Esop_management.repositories.CompanyRepo;
import com.esop.Esop_management.repositories.EmpRepo;
import com.esop.Esop_management.repositories.SellRequestRepo;
import com.esop.Esop_management.services.SellRequestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellRequestServiceImpl implements SellRequestService {

    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private EmpRepo empRepo;

    @Autowired
    private SellRequestRepo  sellRequestRepo;


    @Autowired
    private ModelMapper modelMapper;
    @Override
    public SellRequestDto cretateRequest(SellRequestDto sellRequestDto, Integer cId, Integer eId) {

        Company company = this.companyRepo.findById(cId).orElseThrow(
                ()->new ResourceNotFoundException("Company","cId",cId));
        Emp emp = this.empRepo.findById(eId).orElseThrow(()->new ResourceNotFoundException("Emp","eId",eId));

        SellRequest sellRequest = this.modelMapper.map(sellRequestDto, SellRequest.class);

        sellRequest.setCompany(company);
        sellRequest.setEmp(emp);

        SellRequest saveReq = this.sellRequestRepo.save(sellRequest);
        return this.modelMapper.map(sellRequest,SellRequestDto.class);
    }
}
