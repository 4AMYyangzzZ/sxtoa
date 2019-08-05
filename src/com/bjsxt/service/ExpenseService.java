package com.bjsxt.service;

import com.bjsxt.pojo.Auditing;
import com.bjsxt.pojo.Employee;
import com.bjsxt.pojo.Expense;

import java.util.List;

public interface ExpenseService {
    void addExpense(Expense expense, String[] type, double[] amount, String[] itemDesc);

    List<Expense> myExpense(String empid);

    List<Expense> toAudit(String empid);

    void audit(Auditing auditing, Employee user);
}
