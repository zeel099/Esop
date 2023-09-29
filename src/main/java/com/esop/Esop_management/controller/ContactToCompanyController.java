package com.esop.Esop_management.controller;

import com.esop.Esop_management.entity.ContactToCompany;
import com.esop.Esop_management.payload.ContactToCompanyDto;
import com.esop.Esop_management.payload.VestingPlanDto;
import com.esop.Esop_management.response.ResponseHandler;
import com.esop.Esop_management.services.ContactToCompanyService;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContactToCompanyController {
    @Autowired
    private ContactToCompanyService contactToCompanyService;

    @CrossOrigin(origins = "*")
    @PostMapping("/company/{cId}/emp/{eId}/contact")
    public ResponseEntity<Object> createreq(@RequestBody ContactToCompanyDto contactToCompanyDto,@PathVariable("cId") Integer cId,@PathVariable("eId") Integer eId ){
        ContactToCompanyDto contactToCompany  = this.contactToCompanyService.createreq(contactToCompanyDto,cId,eId);

        return ResponseHandler.responseBuilder("Thank you... we will contact you shortly..", HttpStatus.OK,contactToCompany);

    }

    @CrossOrigin(origins = "*")
    @GetMapping("/company/{cId}/contact")
    public ResponseEntity<Object> getContactByCompany(@PathVariable Integer cId){

        List<ContactToCompanyDto>contact = this.contactToCompanyService.getContactByCompany(cId);
        ResponseEntity<List<ContactToCompanyDto>> listResponseEntity = new ResponseEntity<>(contact, HttpStatus.OK);

        return ResponseHandler.responseBuilder("contact",HttpStatus.OK,contact);

        //return new ResponseEntity<List<VestingPlanDto>>(plans,HttpStatus.OK);
    }
}
