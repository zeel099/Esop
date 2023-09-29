package com.esop.Esop_management.repositories;

import com.esop.Esop_management.entity.BuyRequest;
import com.esop.Esop_management.payload.SellRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BuyRequestRepo extends JpaRepository<BuyRequest,Integer> {
    Optional<BuyRequest> findById(Integer reqId);
    void save(SellRequestDto sellRequestDto);
}
