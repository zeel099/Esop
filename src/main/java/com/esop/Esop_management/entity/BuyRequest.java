package com.esop.Esop_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
@Getter
@Setter
@Table(name="buy_request")
@NoArgsConstructor
public class BuyRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int buyreq;

    private int esop;
    private String status;

    @ManyToOne
    private SellRequest sellRequest;

    @ManyToOne
    private Emp emp;

}
