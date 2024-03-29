package com.esop.Esop_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "SellRequest")
@NoArgsConstructor
public class SellRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reqId;
    private int esop;
    private String status;

    @ManyToOne
    private Company company;

    @ManyToOne
    private Emp emp;

    @ManyToOne
    private BuyRequest buyRequest;

    @ManyToOne
    private Transaction transaction;


}
