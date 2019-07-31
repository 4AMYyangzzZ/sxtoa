package com.bjsxt.service;

import com.bjsxt.entity.Auditing;
import com.bjsxt.entity.Expense;

import java.util.List;

public interface ExpenseService {
    public void addExpense(Expense expense);

    public List<Expense> toAudit(String empId);

    public void audit(Auditing auditing);
}
