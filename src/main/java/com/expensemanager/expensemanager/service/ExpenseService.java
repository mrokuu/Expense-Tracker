package com.expensemanager.expensemanager.service;

import com.expensemanager.expensemanager.dto.ExpenseDto;

import java.util.List;

public interface ExpenseService {
    public List<ExpenseDto> getAllExpenses();
}
