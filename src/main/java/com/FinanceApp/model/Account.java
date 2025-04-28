package com.FinanceApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Account {
	
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; // "HDFC Savings", "Cash", "PayTM"
    private String type; // "BANK", "CASH", "EWALLET"
    private Double balance;
    @ManyToOne // Many accounts can belong to one user
    private User user;
    
	public Account() {
		super();
	}
	
	public Account(Long id, String name, String type, Double balance, User user) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.balance = balance;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
