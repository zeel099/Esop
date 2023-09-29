package com.esop.Esop_management.services;

import com.esop.Esop_management.entity.SellRequest;
import com.esop.Esop_management.payload.SellRequestDto;

public interface SellRequestService {

    SellRequestDto cretateRequest(SellRequestDto sellRequestDto,Integer cId,Integer eId);

}
