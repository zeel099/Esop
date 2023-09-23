package com.esop.Esop_management.entity;

import com.carrotsearch.hppc.HashOrderMixing;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="notification")
@Getter
@Setter
@NoArgsConstructor

public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nid;
    private String notification;
    private boolean status;


    @ManyToOne
    private Company company;

}
