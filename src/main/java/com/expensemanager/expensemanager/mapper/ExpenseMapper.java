package com.expensemanager.expensemanager.mapper;

import com.expensemanager.expensemanager.dto.ExpenseDto;
import com.expensemanager.expensemanager.entity.Expense;
import com.expensemanager.expensemanager.util.DateTimeUtil;

import java.text.ParseException;
import java.util.UUID;


public class ExpenseMapper {



    public static ExpenseDto mapToExpenseDto(Expense expense){
        return ExpenseDto.builder()
                .id(expense.getId())
                .expenseId(expense.getExpenseId())
                .name(expense.getName())
                .description(expense.getDescription())
                .amount(expense.getAmount())
                .date(expense.getDate())
                .dateString(DateTimeUtil.convertDateToString(expense.getDate()))
                .build();

    }


    public static Expense mapToExpense(ExpenseDto expense) throws ParseException {
        return Expense.builder()
                .id(expense.getId())
                .expenseId(UUID.randomUUID().toString())
                .name(expense.getName())
                .description(expense.getDescription())
                .amount(expense.getAmount())
                .date(DateTimeUtil.convertStringToDate(expense.getDateString()))
                .build();

    }



}
