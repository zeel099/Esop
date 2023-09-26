package com.esop.Esop_management.services;

import com.esop.Esop_management.payload.CompanyDto;
import com.esop.Esop_management.payload.FAQDto;

import java.util.List;

public interface FAQService {

    FAQDto createFAQ(FAQDto faqDto);

    FAQDto deleteFAQ(Integer id);

    List<FAQDto> getAllFAQ();


}
