package com.FinanceApp.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description; // "Dinner at Cafe", "Salary"
    private Double amount;
    private LocalDate date;
    private String type; // "INCOME" or "EXPENSE"
    
    @ManyToOne
    private Category category; // Links to a Category
    
    @ManyToOne
    private Account account; // Links to an Account

	public Transaction() {
		super();
	}

	public Transaction(Long id, String description, Double amount, LocalDate date, String type, Category category,
			Account account) {
		super();
		this.id = id;
		this.description = description;
		this.amount = amount;
		this.date = date;
		this.type = type;
		this.category = category;
		this.account = account;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", description=" + description + ", amount=" + amount + ", date=" + date
				+ ", type=" + type + ", category=" + category + ", account=" + account + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
    
}