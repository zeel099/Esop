package com.esop.Esop_management.payload;

import com.esop.Esop_management.entity.BuyRequest;
import com.esop.Esop_management.entity.SellRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor

public class BuyRequestDto {

    private int buyreq;
    private int esop;
    private String status;

    private EmpDto emp;
    private SellRequestDto sellRequest;
}
