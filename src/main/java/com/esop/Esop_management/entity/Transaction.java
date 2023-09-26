package com.esop.Esop_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tId;
    private String cname;
    private String orderType;
    private double price;

    @ManyToOne
    private Company company;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Emp emp;

}
