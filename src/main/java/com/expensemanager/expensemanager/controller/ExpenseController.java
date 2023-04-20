package com.expensemanager.expensemanager.controller;

import com.expensemanager.expensemanager.dto.ExpenseDto;
import com.expensemanager.expensemanager.service.implementation.ExpenseServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ExpenseController {

    private ExpenseServiceImpl expenseService;

    public ExpenseController(ExpenseServiceImpl expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/expenses")
    public String showExpenseList(Model model){
        List<ExpenseDto> lists= expenseService.getAllExpenses();
        model.addAttribute("expenses", lists);
        return "expenses_list";
    }

}
