package com.esop.Esop_management.services;

import java.util.List;

import com.esop.Esop_management.payload.CompanyDto;
import com.esop.Esop_management.payload.LoginDto;
import com.esop.Esop_management.payload.LoginResponse;

public interface CompanyService {

	CompanyDto create(CompanyDto companyDto);
	LoginResponse loginCompany(LoginDto LoginDto);
	CompanyDto update(CompanyDto companyDto,Integer comId);
	
	CompanyDto getCompanyById(Integer comId);
	
	List<CompanyDto>getAllCompany();
	
	 void deleteCompany(Integer comId);
}
