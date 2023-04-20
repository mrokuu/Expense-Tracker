package com.expensemanager.expensemanager.service.implementation;


import com.expensemanager.expensemanager.dto.ExpenseDto;
import com.expensemanager.expensemanager.entity.Expense;
import com.expensemanager.expensemanager.mapper.ExpenseMapper;
import com.expensemanager.expensemanager.repository.ExpenseRepository;
import com.expensemanager.expensemanager.service.ExpenseService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {
    private ExpenseRepository expenseRepository;


    @Override
    public List<ExpenseDto> findAll() {
        List<Expense> expenses = expenseRepository.findAll();
        return expenses.stream().map(ExpenseMapper::mapToExpenseDto).collect(Collectors.toList());
    }
}
