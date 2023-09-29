package com.esop.Esop_management.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GarntTransactionDto {

    private Long gtId;
    private String date;
    private int esop;


    private CompanyDto company;
    private EmpDto emp;

}
