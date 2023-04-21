package com.expensemanager.expensemanager.controller;

import com.expensemanager.expensemanager.dto.ExpenseDto;
import com.expensemanager.expensemanager.dto.ExpenseFilterDto;
import com.expensemanager.expensemanager.service.implementation.ExpenseServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.text.ParseException;
import java.util.List;

@Controller
public class ExpenseFilterController {

   private ExpenseServiceImpl expenseService;

    public ExpenseFilterController(ExpenseServiceImpl expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/filterExpenses")
    public String filterExpenses(@ModelAttribute("filter") ExpenseFilterDto expenseFilterDto, Model model) throws ParseException {
        List<ExpenseDto> expenseDtoList = expenseService.findFilteredExpenses(expenseFilterDto);
        model.addAttribute("expenses", expenseDtoList);
        return "expenses_list";
    }



}
