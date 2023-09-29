package com.esop.Esop_management.services;

import com.esop.Esop_management.entity.ContactToCompany;
import com.esop.Esop_management.payload.ContactToCompanyDto;
import com.esop.Esop_management.payload.VestingPlanDto;

import java.util.List;

public interface ContactToCompanyService {


    ContactToCompanyDto createreq(ContactToCompanyDto contactToCompanyDto,Integer cId,Integer eId );
    List<ContactToCompanyDto>getContactByCompany(Integer cId);
}
