package com.esop.Esop_management.repositories;

import com.esop.Esop_management.entity.Transaction;
import com.esop.Esop_management.payload.TransactionDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionRepo extends JpaRepository<Transaction,Integer> {

    Optional<Transaction> findById( Integer tId);
}
