package com.FinanceApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FinanceApp.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
