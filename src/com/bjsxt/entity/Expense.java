package com.bjsxt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Expense {
    private int expId;
    private String empId;
    private double totalAmount;
    private Date expTime;
    private String expDesc;
    private String nextAuditor;
    private String lastResult;
    private String status;//0 尚未审核 1 审核中 2审核成功 3审核拒绝 4审核打回 5财务打款
    private Employee emp;
    private List<ExpenseItem>list=new ArrayList<>();

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public Expense(String empId, double totalAmount, Date expTime, String expDesc, String nextAuditor, String lastResult, String status, Employee emp) {
        this.empId = empId;
        this.totalAmount = totalAmount;
        this.expTime = expTime;
        this.expDesc = expDesc;
        this.nextAuditor = nextAuditor;
        this.lastResult = lastResult;
        this.status = status;
        this.emp = emp;
    }

    public Expense(int expId, String empId, double totalAmount, Date expTime, String expDesc, String nextAuditor, String lastResult, String status, Employee emp, List<ExpenseItem> list) {
        this.expId = expId;
        this.empId = empId;
        this.totalAmount = totalAmount;
        this.expTime = expTime;
        this.expDesc = expDesc;
        this.nextAuditor = nextAuditor;
        this.lastResult = lastResult;
        this.status = status;
        this.emp = emp;
        this.list = list;
    }

    public Expense(String empId, double totalAmount, Date expTime, String expDesc, String nextAuditor, String lastResult, String status, List<ExpenseItem> list) {
        this.empId = empId;
        this.totalAmount = totalAmount;
        this.expTime = expTime;
        this.expDesc = expDesc;
        this.nextAuditor = nextAuditor;
        this.lastResult = lastResult;
        this.status = status;
        this.list = list;
    }

    public Expense(int expId, String empId, double totalAmount, Date expTime, String expDesc, String nextAuditor, String lastResult, String status, List<ExpenseItem> list) {
        this.expId = expId;
        this.empId = empId;
        this.totalAmount = totalAmount;
        this.expTime = expTime;
        this.expDesc = expDesc;
        this.nextAuditor = nextAuditor;
        this.lastResult = lastResult;
        this.status = status;
        this.list = list;
    }


    public List<ExpenseItem> getList() {
        return list;
    }

    public void setList(List<ExpenseItem> list) {
        this.list = list;
    }

    public Expense() {
    }

    public Expense(int expId, String empId, double totalAmount, Date expTime, String expDesc, String nextAuditor, String lastResult, String status) {
        this.expId = expId;
        this.empId = empId;
        this.totalAmount = totalAmount;
        this.expTime = expTime;
        this.expDesc = expDesc;
        this.nextAuditor = nextAuditor;
        this.lastResult = lastResult;
        this.status = status;
    }

    public Expense(String empId, double totalAmount, Date expTime, String expDesc, String nextAuditor, String lastResult, String status) {
        this.empId = empId;
        this.totalAmount = totalAmount;
        this.expTime = expTime;
        this.expDesc = expDesc;
        this.nextAuditor = nextAuditor;
        this.lastResult = lastResult;
        this.status = status;
    }

    public int getExpId() {
        return expId;
    }

    public void setExpId(int expId) {
        this.expId = expId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getExpTime() {
        return expTime;
    }

    public void setExpTime(Date expTime) {
        this.expTime = expTime;
    }

    public String getExpDesc() {
        return expDesc;
    }

    public void setExpDesc(String expDesc) {
        this.expDesc = expDesc;
    }

    public String getNextAuditor() {
        return nextAuditor;
    }

    public void setNextAuditor(String nextAuditor) {
        this.nextAuditor = nextAuditor;
    }

    public String getLastResult() {
        return lastResult;
    }

    public void setLastResult(String lastResult) {
        this.lastResult = lastResult;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;

    }

    @Override
    public String toString() {
        return "Expense{" +
                "expId=" + expId +
                ", empId='" + empId + '\'' +
                ", totalAmount=" + totalAmount +
                ", expTime=" + expTime +
                ", expDesc='" + expDesc + '\'' +
                ", nextAuditor='" + nextAuditor + '\'' +
                ", lastResult='" + lastResult + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
