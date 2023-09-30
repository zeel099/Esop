package com.esop.Esop_management.payload;

import com.esop.Esop_management.entity.SellRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TransactionDto {

    private int tId;

    private String date;
    private double price;

    private CompanyDto company;

    private BuyRequestDto buyRequest;

    private SellRequestDto sellRequest;
}
