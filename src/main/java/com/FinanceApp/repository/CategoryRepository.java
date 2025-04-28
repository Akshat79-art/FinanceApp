package com.FinanceApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FinanceApp.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
