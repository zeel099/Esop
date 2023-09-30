package com.esop.Esop_management.entity;

import java.util.List;


import com.esop.Esop_management.payload.SellRequestDto;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="company")
@Getter
@Setter
@NoArgsConstructor
public class Company {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	
	
	//@Column(unique=true)
	private String cname;
	private String ceo;
	private long funding;
	private long valuation;
	private long esop;
	private long mobile;
	private String address;
	private double price;

	//@Column(unique=true)
	private String email;
	private String password;
	private double baseprice;
//	@OneToOne(mappedBy = "company",cascade = CascadeType.ALL)
//	private VestingPlan vestingPlan;

	@OneToMany(mappedBy = "company",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private List<VestingPlan> plans ;

	@OneToMany(mappedBy = "company",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Emp>empList;

	@OneToMany(mappedBy = "company",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Notification>notifications;

	@OneToMany(mappedBy = "company",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Grant_Transaction>transactionList;

	@OneToMany(mappedBy = "company",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private List<ContactToCompany>contacts;

	@OneToMany(mappedBy="company",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private List<SellRequest>sellRequestList;

	@OneToMany(mappedBy = "company",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Transaction>transaction;

//	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
//	@JoinTable(name="user_role",
//	joinColumns=@JoinColumn(name="company",referencedColumnName="cid"),
//	inverseJoinColumns=@JoinColumn(name="role",referencedColumnName="id"))
//	private Set<Role>roles = new HashSet<>();

	
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//
//		List<SimpleGrantedAuthority> authorities =this.roles.stream().map((role)-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
//		return authorities;
//	}
//	@Override
//	public String getUsername() {
//		return this.email;
//	}
//	@Override
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;
//	}
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//	@Override
//	public boolean isEnabled() {
//		return true;
//	}
//
	
	
}
