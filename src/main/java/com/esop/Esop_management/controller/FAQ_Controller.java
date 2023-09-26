package com.esop.Esop_management.controller;


import com.esop.Esop_management.payload.FAQDto;
import com.esop.Esop_management.response.ResponseHandler;
import com.esop.Esop_management.services.FAQService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/faq")
public class FAQ_Controller {

    @Autowired
    private FAQService faqService;

    @CrossOrigin(origins = "*")
    @PostMapping("/addCreate")
    public ResponseEntity<Object> createFAQ(@val @RequestBody FAQDto faqDto){
        FAQDto createfaqDto = this.faqService.createFAQ(faqDto);

        return ResponseHandler.responseBuilder("QA added successfully",HttpStatus.OK,createfaqDto);
        //return new ResponseEntity<>(createCompanyDto, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/all")
    public ResponseEntity<List<FAQDto>> getAllFAQ(){

        List<FAQDto> list = this.faqService.getAllFAQ();
       // return ResponseHandlerFAQ.responseBuilder("QA added successfully",HttpStatus.OK,list);
        return ResponseEntity.ok(this.faqService.getAllFAQ());

    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{fId}")
    public ResponseEntity<Object>deleteFAQ(@PathVariable("fId") Integer fId){
        FAQDto faqDto = this.faqService.deleteFAQ(fId);

        return ResponseHandler.responseBuilder("deleted successfully",HttpStatus.OK,faqDto);
    }
}

