package com.bjsxt.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Payment {
    private Integer payId;
    private Integer expId;
    private String payEmpId;
    private Double amount;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date date;
    private String empId;

    public Integer getPayId() {
        return payId;
    }

    public void setPayId(Integer payId) {
        this.payId = payId;
    }

    public Integer getExpId() {
        return expId;
    }

    public void setExpId(Integer expId) {
        this.expId = expId;
    }

    public String getPayEmpId() {
        return payEmpId;
    }

    public void setPayEmpId(String payEmpId) {
        this.payEmpId = payEmpId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
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
