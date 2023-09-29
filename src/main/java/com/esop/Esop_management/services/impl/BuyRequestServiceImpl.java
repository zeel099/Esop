package com.esop.Esop_management.services.impl;

import com.esop.Esop_management.entity.BuyRequest;
import com.esop.Esop_management.entity.Company;
import com.esop.Esop_management.entity.Emp;
import com.esop.Esop_management.entity.SellRequest;
import com.esop.Esop_management.exceptions.ResourceNotFoundException;
import com.esop.Esop_management.payload.BuyRequestDto;
import com.esop.Esop_management.payload.SellRequestDto;
import com.esop.Esop_management.repositories.BuyRequestRepo;
import com.esop.Esop_management.repositories.EmpRepo;
import com.esop.Esop_management.repositories.SellRequestRepo;
import com.esop.Esop_management.services.BuyRequestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuyRequestServiceImpl implements BuyRequestService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmpRepo empRepo;

    @Autowired
    private BuyRequestRepo buyRequestRepo;

    @Autowired
    private SellRequestRepo sellRequestRepo;
    @Override
    public BuyRequestDto createBuyRequest(BuyRequestDto buyRequestDto, Integer eId,Integer sellReqId) {


        Emp emp = this.empRepo.findById(eId).orElseThrow(()->new ResourceNotFoundException("Emp","eId",eId));
        SellRequest sellRequest = this.sellRequestRepo.findById(sellReqId).orElseThrow(
                ()->new ResourceNotFoundException("SellRequest","sellReqId",sellReqId));
        BuyRequest buyRequest = this.modelMapper.map(buyRequestDto, BuyRequest.class);
        buyRequest.setEmp(emp);
        buyRequest.setSellRequest(sellRequest);

        BuyRequest savedReq = this.buyRequestRepo.save(buyRequest);
        return this.modelMapper.map(savedReq,BuyRequestDto.class);
    }

    @Override
    public List<BuyRequestDto> getAllBuyRequest() {

        List<BuyRequest> requests = this.buyRequestRepo.findAll();

        List<BuyRequestDto> reqDto = requests.stream().map(req->this.modelMapper.map(req,BuyRequestDto.class)).collect(Collectors.toList());
        return reqDto;
    }

    @Override
    public BuyRequestDto updateBuyRequest(BuyRequestDto buyRequestDto, Integer reqId) {
        BuyRequest buyRequest = this.buyRequestRepo.findById(reqId).orElseThrow(()->new ResourceNotFoundException("buyRequest","reqId",reqId));
        buyRequest.setEsop(buyRequestDto.getEsop());
        buyRequest.setStatus(buyRequestDto.getStatus());

        BuyRequest updateBuyRequest = this.buyRequestRepo.save(buyRequest);
        return this.modelMapper.map(updateBuyRequest,BuyRequestDto.class);
    }

    @Override
    public BuyRequestDto deleteBuyRequest(Integer buyReqId) {
        BuyRequest buyRequest = this.buyRequestRepo.findById(buyReqId).orElseThrow(()->new ResourceNotFoundException("buyRequest","buyReqId",buyReqId));
        this.buyRequestRepo.delete(buyRequest);
        return this.modelMapper.map(buyRequest,BuyRequestDto.class);
    }


}
