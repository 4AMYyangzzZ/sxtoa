package com.bjsxt.dao;

import com.bjsxt.entity.Income;

import java.util.List;

public interface IncomeDao {
    public List<Object[]> getIncomeData();

    public List<Object[]> getPaymentData();

    public List<Income> getAllIncome();

    public int save(Income income);
}
