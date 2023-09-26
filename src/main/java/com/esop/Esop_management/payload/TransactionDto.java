package com.esop.Esop_management.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {

    private Long tId;
    private String cname;
    private String orderType;
    private double price;

    private CompanyDto company;
    private EmpDto emp;

}
