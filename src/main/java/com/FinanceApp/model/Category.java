package com.FinanceApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Category {
	
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; // "Food", "Transport", "Salary"
    @ManyToOne
    private User user; // User-specific categories
    
	public Category() {
		super();
	}

	public Category(Long id, String name, User user) {
		super();
		this.id = id;
		this.name = name;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", user=" + user + "]";
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
}