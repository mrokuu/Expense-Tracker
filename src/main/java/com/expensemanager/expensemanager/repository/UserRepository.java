package com.expensemanager.expensemanager.repository;

import com.expensemanager.expensemanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
