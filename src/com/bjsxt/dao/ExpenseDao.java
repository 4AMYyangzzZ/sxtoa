package com.bjsxt.dao;

import com.bjsxt.entity.Expense;

import java.util.List;

public interface ExpenseDao {
    public int addExpense(Expense expense);

    public List<Expense> findExpById(String empId);

    public Expense find(int expId);

    public void updateExp(Expense expense1);
}
