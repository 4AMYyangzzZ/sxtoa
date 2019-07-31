package com.bjsxt.entity;

import java.util.Date;

public class Payment {
    private int payId;
    private int expId;
    private String payEmpId;
    private double amount;
    private Date date;
    private String empId;

    public Payment() {
    }

    public Payment(int expId, String payEmpId, double amount, Date date, String empId) {
        this.expId = expId;
        this.payEmpId = payEmpId;
        this.amount = amount;
        this.date = date;
        this.empId = empId;
    }

    public Payment(int payId, int expId, String payEmpId, double amount, Date date, String empId) {
        this.payId = payId;
        this.expId = expId;
        this.payEmpId = payEmpId;
        this.amount = amount;
        this.date = date;
        this.empId = empId;
    }

    public int getPayId() {
        return payId;
    }

    public void setPayId(int payId) {
        this.payId = payId;
    }

    public int getExpId() {
        return expId;
    }

    public void setExpId(int expId) {
        this.expId = expId;
    }

    public String getPayEmpId() {
        return payEmpId;
    }

    public void setPayEmpId(String payEmpId) {
        this.payEmpId = payEmpId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "payId=" + payId +
                ", expId=" + expId +
                ", payEmpId='" + payEmpId + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", empId='" + empId + '\'' +
                '}';
    }
}
