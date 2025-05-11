package com.FinanceApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.FinanceApp.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);
	
	@Modifying
	@Query("update User u set u.email = :newEmail where u.email =: oldEmail")
	void updateEmail(@Param(value = "oldEmail") String oldEmail, @Param(value = "newEmail") String newEmail);
}
