package com.esop.Esop_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="contact")
@NoArgsConstructor
public class ContactToCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String uname;
    private String email;
    private String message;
    private String time;

    @ManyToOne
    private Emp emp;

    @ManyToOne
    private Company company;
}
