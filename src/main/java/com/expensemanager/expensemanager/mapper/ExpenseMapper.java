package com.expensemanager.expensemanager.mapper;

import com.expensemanager.expensemanager.dto.ExpenseDto;
import com.expensemanager.expensemanager.entity.Expense;


public class ExpenseMapper {



    public static ExpenseDto mapToExpenseDto(Expense expense){
        return ExpenseDto.builder()
                .id(expense.getId())
                .expenseId(expense.getExpenseId())
                .name(expense.getName())
                .description(expense.getDescription())
                .amount(expense.getAmount())
                .date(expense.getDate())
                .build();

    }


    public static Expense mapToExpense(ExpenseDto expense){
        return Expense.builder()
                .id(expense.getId())
                .expenseId(expense.getExpenseId())
                .name(expense.getName())
                .description(expense.getDescription())
                .amount(expense.getAmount())
                .date(expense.getDate())
                .build();

    }



}
