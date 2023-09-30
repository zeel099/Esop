package com.esop.Esop_management.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="Final_Transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tId;
    private String date;
    private double price;

    @ManyToOne
    private Company company;

    @ManyToOne
    private BuyRequest buyRequest;

    @ManyToOne
    private SellRequest sellRequest;



}
