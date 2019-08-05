package com.bjsxt.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * `EXPID` int(10) NOT NULL AUTO_INCREMENT,
 `EMPID` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
 `TOTALAMOUNT` double(10,2) DEFAULT NULL,
 `EXPTIME` date DEFAULT NULL,
 `EXPDESC` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
 `NEXTAUDITOR` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
 `LASTRESULT` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
 `STATUS` char(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '1�������   2 ��˽���ͨ��  3 ��˽�������',
 */
public class Expense {
    private Integer expId;
    private String empId;
    private Double totalAmount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date expTime;
    private String expDesc;
    private String nextAuditor;
    private String lastResult;
    private String status;//0 尚未审核 1 审核中 2审核成功 3审核拒绝 4审核打回 5财务打款
    private Employee emp;
    private List<ExpenseItem> list=new ArrayList<>();

    public Integer getExpId() {
        return expId;
    }

    public void setExpId(Integer expId) {
        this.expId = expId;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
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

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public List<ExpenseItem> getList() {
        return list;
    }

    public void setList(List<ExpenseItem> list) {
        this.list = list;
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
                ", emp=" + emp +
                ", list=" + list +
                '}';
    }
}
