package com.esop.Esop_management.repositories;



import java.util.Optional;

import com.esop.Esop_management.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;

import com.esop.Esop_management.entity.Company;
import com.esop.Esop_management.payload.CompanyDto;


public interface CompanyRepo extends JpaRepository<Company,Integer>{

	Optional<Company>findById(Integer cId);
	Optional<Company>findOneByEmailAndAndPassword(String email,String password);
	Company findByEmail(String email);
	void save(CompanyDto company);
}
