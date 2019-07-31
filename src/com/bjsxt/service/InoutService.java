package com.bjsxt.service;

import com.bjsxt.entity.Income;

import java.util.List;

public interface InoutService {
    public String getIncomeData();


    public String getPaymentData();

    public List<Income> getAllIncome();

    public boolean incomeAdd(Income income);
}
