package com.expensemanager.expensemanager.validator;

import com.expensemanager.expensemanager.dto.ExpenseDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ExpenseValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return ExpenseDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ExpenseDto expenseDto = (ExpenseDto) target;
        if(expenseDto.getDateString().equals("") || expenseDto.getDateString().isEmpty()
        || expenseDto.getDateString() == null){
            errors.rejectValue("dateString", null,
                    "Expense date should not be null");
        }
    }
}
