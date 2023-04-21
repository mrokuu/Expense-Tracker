package com.expensemanager.expensemanager.service;

import com.expensemanager.expensemanager.dto.ExpenseDto;

import java.text.ParseException;
import java.util.List;

public interface ExpenseService {
    public List<ExpenseDto> getAllExpenses();
//    ExpenseDto saveExpense(ExpenseDto expenseDto) throws ParseException;
    void saveExpense(ExpenseDto expenseDto) throws ParseException;

    void deleteExpense(Long id);

    ExpenseDto findExpenseById(Long id);

    void upDateExpense(ExpenseDto expenseDto) throws ParseException;
}
