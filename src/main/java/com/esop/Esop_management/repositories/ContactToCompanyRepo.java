package com.esop.Esop_management.repositories;

import com.esop.Esop_management.entity.Company;
import com.esop.Esop_management.entity.ContactToCompany;
import com.esop.Esop_management.entity.VestingPlan;
import com.esop.Esop_management.payload.ContactToCompanyDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContactToCompanyRepo extends JpaRepository<ContactToCompany,Integer> {
    Optional<ContactToCompany>findById(Integer id);

   List<ContactToCompanyDto>findAllById(Integer eId);

   List<ContactToCompany>findContactByCompany(Company company);

}
