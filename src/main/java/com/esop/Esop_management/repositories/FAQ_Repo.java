package com.esop.Esop_management.repositories;

import com.esop.Esop_management.entity.FAQ;
import com.esop.Esop_management.payload.FAQDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FAQ_Repo extends JpaRepository<FAQ,Integer> {
    Optional<FAQ> findById(FAQ id);
    void save(FAQDto faq);
}
