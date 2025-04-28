package com.FinanceApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FinanceApp.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
