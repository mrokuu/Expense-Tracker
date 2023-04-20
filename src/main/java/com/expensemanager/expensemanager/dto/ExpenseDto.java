package com.expensemanager.expensemanager.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private String name;
    private String description;

    private BigDecimal amount;
    private Date date;
    private String dateString;

}
