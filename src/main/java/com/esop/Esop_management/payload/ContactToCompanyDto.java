package com.esop.Esop_management.payload;

import com.esop.Esop_management.entity.Company;
import com.esop.Esop_management.entity.Emp;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContactToCompanyDto {

    private int id;
    private String uname;
    private String email;
    private String message;
    private String time;

    private EmpDto emp;


    private CompanyDto company;
}
