package com.esop.Esop_management.services.impl;

import com.esop.Esop_management.entity.Company;
import com.esop.Esop_management.entity.Emp;
import com.esop.Esop_management.entity.FAQ;
import com.esop.Esop_management.exceptions.ResourceNotFoundException;
import com.esop.Esop_management.payload.CompanyDto;
import com.esop.Esop_management.payload.EmpDto;
import com.esop.Esop_management.payload.FAQDto;
import com.esop.Esop_management.repositories.FAQ_Repo;
import com.esop.Esop_management.services.FAQService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FAQServiceImpl implements FAQService {

    @Autowired
    private FAQ_Repo faqRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public FAQDto createFAQ(FAQDto faqDto) {
        FAQ faq = this.modelMapper.map(faqDto,FAQ.class);
        FAQ savedFaq = this.faqRepo.save(faq);

        return this.modelMapper.map(savedFaq,FAQDto.class);
    }



    @Override
    public List<FAQDto> getAllFAQ() {
        List<FAQ> faqs = this.faqRepo.findAll();

        List<FAQDto> faqDtos = faqs.stream().map(faq->this.modelMapper.map(faq,FAQDto.class)).collect(Collectors.toList());
        return faqDtos;
    }

    public FAQDto deleteFAQ(Integer faqId) {

        FAQ faq = this.faqRepo.findById(faqId).
                orElseThrow(()->new ResourceNotFoundException("FAQ","faqId",faqId));
        this.faqRepo.delete(faq);
        return this.modelMapper.map(faq,FAQDto.class);

    }
}
