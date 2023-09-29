package com.esop.Esop_management.services.impl;

import com.esop.Esop_management.entity.Company;
import com.esop.Esop_management.entity.ContactToCompany;
import com.esop.Esop_management.entity.Emp;
import com.esop.Esop_management.exceptions.ResourceNotFoundException;
import com.esop.Esop_management.payload.ContactToCompanyDto;
import com.esop.Esop_management.payload.EmpDto;
import com.esop.Esop_management.repositories.CompanyRepo;
import com.esop.Esop_management.repositories.ContactToCompanyRepo;
import com.esop.Esop_management.repositories.EmpRepo;
import com.esop.Esop_management.services.ContactToCompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactToCompanyServiceImpl implements ContactToCompanyService {

    @Autowired
    private ContactToCompanyRepo contactToCompanyRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmpRepo empRepo;

    @Autowired
    CompanyRepo companyRepo;


    @Override
    public ContactToCompanyDto createreq(ContactToCompanyDto contactToCompanyDto,Integer cId,Integer eId) {
        Company company = this.companyRepo.findById(cId).orElseThrow(
                ()->new ResourceNotFoundException("company","cId",cId));
        Emp emp = this.empRepo.findById(eId).orElseThrow(
                ()->new ResourceNotFoundException("emp","eId",eId));

        ContactToCompany  contactToCompany = this.modelMapper.map(contactToCompanyDto, ContactToCompany.class);
        contactToCompany.setCompany(company);
        contactToCompany.setEmp(emp);

        ContactToCompany savedContact = this.contactToCompanyRepo.save(contactToCompany);

        return this.modelMapper.map(savedContact,ContactToCompanyDto.class);

    }

    @Override
    public List<ContactToCompanyDto> getContactByCompany(Integer cId) {
        Company company = this.companyRepo.findById(cId).orElseThrow(
                ()->new ResourceNotFoundException("company","cId",cId));

        List<ContactToCompany>contact = this.contactToCompanyRepo.findContactByCompany(company);
        List<ContactToCompanyDto>contactList=contact.stream().map(con->this.modelMapper.map(con, ContactToCompanyDto.class)).collect(Collectors.toList());

        return contactList;
    }
}
