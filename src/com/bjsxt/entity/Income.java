package com.bjsxt.entity;

import java.util.Date;

public class Income {
    private int incomeId;
    private String empId;
    private int amount;
    private Date incomeDate;
    private String incomeType;
    private String incomeDesc;

    public Income() {
    }

    public Income(String empId, int amount, Date incomeDate, String incomeType, String incomeDesc) {
        this.empId = empId;
        this.amount = amount;
        this.incomeDate = incomeDate;
        this.incomeType = incomeType;
        this.incomeDesc = incomeDesc;
    }

    public Income(int incomeId, String empId, int amount, Date incomeDate, String incomeType, String incomeDesc) {
        this.incomeId = incomeId;
        this.empId = empId;
        this.amount = amount;
        this.incomeDate = incomeDate;
        this.incomeType = incomeType;
        this.incomeDesc = incomeDesc;
    }

    public int getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(int incomeId) {
        this.incomeId = incomeId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(Date incomeDate) {
        this.incomeDate = incomeDate;
    }

    public String getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(String incomeType) {
        this.incomeType = incomeType;
    }

    public String getIncomeDesc() {
        return incomeDesc;
    }

    public void setIncomeDesc(String incomeDesc) {
        this.incomeDesc = incomeDesc;
    }
}
