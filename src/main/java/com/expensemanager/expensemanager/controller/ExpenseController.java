package com.expensemanager.expensemanager.controller;

import com.expensemanager.expensemanager.dto.ExpenseDto;
import com.expensemanager.expensemanager.dto.ExpenseFilterDto;
import com.expensemanager.expensemanager.entity.Expense;
import com.expensemanager.expensemanager.service.implementation.ExpenseServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Controller
public class ExpenseController {

    private ExpenseServiceImpl expenseService;

    public ExpenseController(ExpenseServiceImpl expenseService) {

        this.expenseService = expenseService;
    }

    @GetMapping("/expenses")
    public String showExpenseList(Model model,
                                  ExpenseFilterDto expenseFilterDto){
        List<ExpenseDto> lists= expenseService.findAllExpenses();
        model.addAttribute("expenses", lists);
        model.addAttribute("filter", expenseFilterDto);
        return "expenses_list";
    }

    @GetMapping("/createExpense" )
    public String createExpense(Model model,
                                ExpenseDto expenseDto){
        model.addAttribute("expense", expenseDto);
        return "create_expense_form";
    }

    @PostMapping("/saveOrUpdateExpense")
    public String saveOrUpddateExpense(@ModelAttribute("expense") ExpenseDto expenseDto,
                                       BindingResult bindingResult, Model model) throws ParseException {
        expenseService.saveExpense(expenseDto);
        return "redirect:/expenses";
    }

    @GetMapping("/delete")
    public String deleteExpense(@RequestParam Long id){
    expenseService.deleteExpense(id);
    return "redirect:/expenses";
    }
    @GetMapping("/update")
    public String editExpense(@RequestParam Long id, Model model){
        ExpenseDto expenseDto = expenseService.findExpenseById(id);
        model.addAttribute("expense", expenseDto);
        return "create_expense_form";
    }


    @PostMapping("/update/{id}")
    public String updatePost(@PathVariable("id") Long id,
                             @ModelAttribute("expense") ExpenseDto expenseDto,
                             BindingResult result,
                             Model model) throws ParseException {

        expenseDto.setId(id);
        expenseService.upDateExpense(expenseDto);
         return "redirect:/expenses";
    }

}
