package com.esop.Esop_management.services;

import com.esop.Esop_management.payload.BuyRequestDto;
import com.esop.Esop_management.payload.SellRequestDto;
import com.esop.Esop_management.repositories.BuyRequestRepo;
import com.esop.Esop_management.services.impl.BuyRequestServiceImpl;

import java.util.List;

public interface BuyRequestService {

    BuyRequestDto createBuyRequest(BuyRequestDto buyRequestDto, Integer eId,Integer sellReqId);

    List<BuyRequestDto> getAllBuyRequest();

    BuyRequestDto updateBuyRequest(BuyRequestDto buyRequestDto,Integer reqId);

    BuyRequestDto deleteBuyRequest(Integer buyReqId);
}
