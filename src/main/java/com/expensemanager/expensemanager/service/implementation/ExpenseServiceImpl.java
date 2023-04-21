package com.expensemanager.expensemanager.service.implementation;


import com.expensemanager.expensemanager.dto.ExpenseDto;
import com.expensemanager.expensemanager.entity.Expense;
import com.expensemanager.expensemanager.mapper.ExpenseMapper;
import com.expensemanager.expensemanager.repository.ExpenseRepository;
import com.expensemanager.expensemanager.service.ExpenseService;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	
	private ExpenseRepository expenseRepository;

	public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}

	public List<ExpenseDto> getAllExpenses() {
		return expenseRepository.findAll()
				.stream()
				.map(ExpenseMapper::mapToExpenseDto)
				.collect(Collectors.toList());

	}

//	@Override
//	public ExpenseDto saveExpense(ExpenseDto expenseDto) throws ParseException {
//		Expense expense = ExpenseMapper.mapToExpense(expenseDto);
//		expenseRepository.save(expense);
//		return ExpenseMapper.mapToExpenseDto(expense);
//	}

	@Override
	public void saveExpense(ExpenseDto expenseDto) throws ParseException {
		Expense expense = ExpenseMapper.mapToExpense(expenseDto);
		expenseRepository.save(expense);
	}

	@Override
	public void deleteExpense(Long id) {
		expenseRepository.deleteById(id);
	}

	@Override
	public ExpenseDto findExpenseById(Long id) {
		Expense expense = expenseRepository.findById(id).get();
		return ExpenseMapper.mapToExpenseDto(expense);
	}

	@Override
	public void upDateExpense(ExpenseDto expenseDto) throws ParseException {
		Expense expense = ExpenseMapper.mapToExpense(expenseDto);
		expenseRepository.save(expense);
	}


}





















