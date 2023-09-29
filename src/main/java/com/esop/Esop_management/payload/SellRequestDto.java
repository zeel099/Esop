package com.esop.Esop_management.payload;

import com.esop.Esop_management.entity.Company;
import com.esop.Esop_management.entity.Emp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SellRequestDto {

    private int reqId;
    private int esop;
    private String status;

    private CompanyDto company;
    private EmpDto emp;
}
