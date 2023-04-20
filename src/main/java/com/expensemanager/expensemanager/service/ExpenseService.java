package com.expensemanager.expensemanager.service;

import com.expensemanager.expensemanager.dto.ExpenseDto;
import com.expensemanager.expensemanager.entity.Expense;

import java.util.List;

public interface ExpenseService {

    public List<ExpenseDto> findAll();
}
