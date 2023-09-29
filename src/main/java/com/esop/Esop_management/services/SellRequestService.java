package com.esop.Esop_management.services;

import com.esop.Esop_management.entity.SellRequest;
import com.esop.Esop_management.payload.SellRequestDto;

import java.util.List;

public interface SellRequestService {

    SellRequestDto cretateRequest(SellRequestDto sellRequestDto,Integer cId,Integer eId);

    List<SellRequestDto> getAllRequest();

    SellRequestDto updateRequest(SellRequestDto sellRequestDto,Integer reqId);

    SellRequestDto deleteSellRequest(Integer sellReqId);
}
