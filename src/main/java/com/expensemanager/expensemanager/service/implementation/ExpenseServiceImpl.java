package com.expensemanager.expensemanager.service.implementation;


import com.expensemanager.expensemanager.dto.ExpenseDto;
import com.expensemanager.expensemanager.dto.ExpenseFilterDto;
import com.expensemanager.expensemanager.entity.Expense;
import com.expensemanager.expensemanager.mapper.ExpenseMapper;
import com.expensemanager.expensemanager.repository.ExpenseRepository;
import com.expensemanager.expensemanager.service.ExpenseService;
import com.expensemanager.expensemanager.util.DateTimeUtil;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;
import java.sql.Date;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	
	private ExpenseRepository expenseRepository;

	public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}

	public List<ExpenseDto> findAllExpenses() {
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

//	@Override
//	public List<ExpenseDto> findFilteredExpenses(String keyword, String sortBy) {
//		List<Expense> expensesList = expenseRepository.findByNameContaining(keyword);
//		List<ExpenseDto> filteredList = expensesList
//				.stream()
//				.map(ExpenseMapper::mapToExpenseDto)
//				.collect(Collectors.toList());
//		if(sortBy.equals("date")){
//			filteredList.sort((obkect1,object2) -> object2.getDate().compareTo(obkect1.getDate()));
//		} else {
//			filteredList.sort((obkect1,object2) -> object2.getAmount().compareTo(obkect1.getAmount()));
//		}
//
//		return filteredList;
//	}


	public List<ExpenseDto> findFilteredExpenses(ExpenseFilterDto expenseFilterDTO) throws ParseException {
		String keyword = expenseFilterDTO.getKeyword();
		String sortBy = expenseFilterDTO.getSortBy();
		String startDateString = expenseFilterDTO.getStartDate();
		String endDateString =expenseFilterDTO.getEndDate();

		Date startDate = !startDateString.isEmpty() ? DateTimeUtil.convertStringToDate(startDateString): new Date(0);
		Date endDate = !endDateString.isEmpty() ? DateTimeUtil.convertStringToDate(endDateString): new Date(System.currentTimeMillis());
		List<Expense> list = expenseRepository.findByNameContainingAndDateBetween(keyword, startDate, endDate);
		List<ExpenseDto> filteredList = list.stream().map(ExpenseMapper::mapToExpenseDto).collect(Collectors.toList());
		if (sortBy.equals("date")) {

			filteredList.sort((o1, o2) -> o2.getDate().compareTo(o1.getDate()));
		}else {

			filteredList.sort((o1, o2) -> o2.getAmount().compareTo(o1.getAmount()));
		}
		return filteredList;
	}

	@Override
	public BigDecimal totalExpenses(List<ExpenseDto> expenseDtoList) {
		BigDecimal sum = new BigDecimal(0);
		BigDecimal totalSum = expenseDtoList
				.stream()
				.map(x -> x.getAmount().add(sum))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		return totalSum;
	}


}





















