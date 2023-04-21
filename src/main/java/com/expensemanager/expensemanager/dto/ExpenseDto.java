package com.expensemanager.expensemanager.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenseDto {


    private Long id;

    private String expenseId;
    @NotBlank(message = "Expense name should not be empty")
    private String name;

    private String description;
    @NotNull(message = "Expense amount should not be empty")
    @Min(value = 1, message = "Expense amount should not be less than 1")
    private BigDecimal amount;

    private Date date;

    private String dateString;

}
