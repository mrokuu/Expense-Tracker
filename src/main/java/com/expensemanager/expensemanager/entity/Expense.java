package com.expensemanager.expensemanager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


import java.math.BigDecimal;
import java.sql.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String expenseId;

    private String name;

    private String description;

    private BigDecimal amount;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


}
