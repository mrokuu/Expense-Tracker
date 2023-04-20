package com.expensemanager.expensemanager.service.implementation;


import com.expensemanager.expensemanager.dto.ExpenseDto;
import com.expensemanager.expensemanager.entity.Expense;
import com.expensemanager.expensemanager.mapper.ExpenseMapper;
import com.expensemanager.expensemanager.repository.ExpenseRepository;
import com.expensemanager.expensemanager.service.ExpenseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	
	private ExpenseRepository expenseRepository;

	public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}

	public List<ExpenseDto> getAllExpenses() {
		List<Expense> list = expenseRepository.findAll();
		List<ExpenseDto> expenseList = list.stream().map(ExpenseMapper::mapToExpenseDto).collect(Collectors.toList());
		return expenseList;
	}
	

}





















