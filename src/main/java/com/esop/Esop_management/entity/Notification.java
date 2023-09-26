package com.esop.Esop_management.entity;

import com.carrotsearch.hppc.HashOrderMixing;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.util.Date;

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
    //private boolean status;

    private String time;

    @ManyToOne
    private Company company;



}
