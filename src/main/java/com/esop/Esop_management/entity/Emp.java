package com.esop.Esop_management.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="employee")
@NoArgsConstructor

public class Emp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;
	private String fname;
	private String lname;

	private String email;
	private String password;
	private long mobile;
	private String address;


	private Date joiningdate;
	private int esop;

	private String department;
	private int granted;
	private int exercise;

	private String status;
	private double price;
	private long account_no;
	private String ifscno;
	@ManyToOne
	private Company company;

	@ManyToOne
	private VestingPlan vestingPlan;

	@ManyToOne
	private Grant_Transaction transaction;

	@ManyToOne
	private SellRequest sellReqest;


}
