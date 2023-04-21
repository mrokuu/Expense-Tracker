package com.expensemanager.expensemanager.controller;

import com.expensemanager.expensemanager.dto.ExpenseDto;
import com.expensemanager.expensemanager.dto.ExpenseFilterDto;
import com.expensemanager.expensemanager.entity.Expense;
import com.expensemanager.expensemanager.service.implementation.ExpenseServiceImpl;
import com.expensemanager.expensemanager.validator.ExpenseValidator;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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
        List<ExpenseDto> list= expenseService.findAllExpenses();
        model.addAttribute("expenses", list);
        model.addAttribute("filter", expenseFilterDto);
        BigDecimal totalExpenses = expenseService.totalExpenses(list);
        model.addAttribute("totalExpenses", totalExpenses);
        return "expenses_list";
    }

    @GetMapping("/createExpense" )
    public String createExpense(Model model,
                                ExpenseDto expenseDto){
        model.addAttribute("expense", expenseDto);
        return "create_expense_form";
    }

    @PostMapping("/saveOrUpdateExpense")
    public String saveOrUpddateExpense(@Valid @ModelAttribute("expense") ExpenseDto expenseDto,
                                       BindingResult bindingResult, Model model) throws ParseException {
        new ExpenseValidator().validate(expenseDto, bindingResult);

        if(bindingResult.hasErrors()){
           return "create_expense_form";
        }
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
