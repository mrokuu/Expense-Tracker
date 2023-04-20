package com.expensemanager.expensemanager.repository;

import com.expensemanager.expensemanager.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
