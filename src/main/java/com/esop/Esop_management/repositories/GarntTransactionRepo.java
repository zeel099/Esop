package com.esop.Esop_management.repositories;

import com.esop.Esop_management.entity.Company;
import com.esop.Esop_management.entity.Grant_Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GarntTransactionRepo extends JpaRepository<Grant_Transaction,Integer> {
    Optional<Grant_Transaction> findById(Integer id);

    List<Grant_Transaction> findByCompany(Company company);
}
