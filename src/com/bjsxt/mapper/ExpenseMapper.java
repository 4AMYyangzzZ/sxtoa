package com.bjsxt.mapper;

import com.bjsxt.pojo.Expense;
import com.bjsxt.pojo.ExpenseItem;

import java.util.List;

public interface ExpenseMapper {
    void addExpense(Expense expense);

    List<Expense> myExpense(String empid);

    List<Expense> toAudit(String empid);

    Expense findExpenseById(Integer expId);

    void updateExpense(Expense expense1);
}
