package com.esop.Esop_management.services.impl;

import com.esop.Esop_management.entity.Company;
import com.esop.Esop_management.entity.Emp;
import com.esop.Esop_management.entity.SellRequest;
import com.esop.Esop_management.exceptions.ResourceNotFoundException;
import com.esop.Esop_management.payload.CompanyDto;
import com.esop.Esop_management.payload.SellRequestDto;
import com.esop.Esop_management.repositories.CompanyRepo;
import com.esop.Esop_management.repositories.EmpRepo;
import com.esop.Esop_management.repositories.SellRequestRepo;
import com.esop.Esop_management.services.SellRequestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<SellRequestDto> getAllRequest() {

        List<SellRequest> requests = this.sellRequestRepo.findAll();

        List<SellRequestDto> reqDto = requests.stream().map(req->this.modelMapper.map(req,SellRequestDto.class)).collect(Collectors.toList());
        return reqDto;
    }

    @Override
    public SellRequestDto updateRequest(SellRequestDto sellRequestDto, Integer reqId) {
        SellRequest sellRequest = this.sellRequestRepo.findById(reqId).orElseThrow(()->new ResourceNotFoundException("sellRequest","reqId",reqId));
        sellRequest.setEsop(sellRequestDto.getEsop());
        sellRequest.setStatus(sellRequestDto.getStatus());

        SellRequest updateSellRequest = this.sellRequestRepo.save(sellRequest);
        return this.modelMapper.map(updateSellRequest,SellRequestDto.class);
    }

    @Override
    public SellRequestDto deleteSellRequest(Integer sellReqId) {

        SellRequest sellRequest = this.sellRequestRepo.findById(sellReqId).orElseThrow(()->new ResourceNotFoundException("sellRequeest","sellReqId",sellReqId));
        this.sellRequestRepo.delete(sellRequest);

        return this.modelMapper.map(sellRequest,SellRequestDto.class);
    }
}
