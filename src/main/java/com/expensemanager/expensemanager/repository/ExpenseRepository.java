package com.expensemanager.expensemanager.repository;

import com.expensemanager.expensemanager.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

import java.util.List;


public interface ExpenseRepository extends JpaRepository<Expense, Long> {

//    List<Expense> findByNameContaining(String keyword);

    List<Expense> findByNameContainingAndDateBetweenAndUserId(String keyword, Date startDate, Date endDate, Long id);
    List<Expense> findByUserId(Long id);

}
