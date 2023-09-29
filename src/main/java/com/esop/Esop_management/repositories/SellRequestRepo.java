package com.esop.Esop_management.repositories;

import com.esop.Esop_management.entity.SellRequest;
import com.esop.Esop_management.payload.SellRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SellRequestRepo extends JpaRepository<SellRequest,Integer> {

    Optional<SellRequest> findById(Integer reqId);

}
