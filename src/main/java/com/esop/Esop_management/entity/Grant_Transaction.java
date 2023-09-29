package com.esop.Esop_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "grant_transaction")
public class Grant_Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gtId;
    private String date;
    private int esop;


    @ManyToOne
    private Company company;

    @ManyToOne
    private Emp emp;

}
