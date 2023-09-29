package com.esop.Esop_management.payload;

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


}
