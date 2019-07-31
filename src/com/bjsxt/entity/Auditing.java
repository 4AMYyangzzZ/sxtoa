package com.bjsxt.entity;

import java.util.Date;

public class Auditing {
    private int auditId;
    private int expId;
    private String empId;
    private String result;
    private String auditDesc;
    private Date time;
    private Employee emp;

    public Auditing(int auditId, int expId, String empId, String result, String auditDesc, Date time, Employee emp) {
        this.auditId = auditId;
        this.expId = expId;
        this.empId = empId;
        this.result = result;
        this.auditDesc = auditDesc;
        this.time = time;
        this.emp = emp;
    }

    public Auditing(int expId, String empId, String result, String auditDesc, Date time) {
        this.expId = expId;
        this.empId = empId;
        this.result = result;
        this.auditDesc = auditDesc;
        this.time = time;
    }

    public Auditing(int expId, String empId, String result, String auditDesc, Date time, Employee emp) {
        this.expId = expId;
        this.empId = empId;
        this.result = result;
        this.auditDesc = auditDesc;
        this.time = time;
        this.emp = emp;
    }

    public Auditing() {
    }

    public int getAuditId() {
        return auditId;
    }

    public void setAuditId(int auditId) {
        this.auditId = auditId;
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getAuditDesc() {
        return auditDesc;
    }

    public void setAuditDesc(String auditDesc) {
        this.auditDesc = auditDesc;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    @Override
    public String toString() {
        return "Auditing{" +
                "auditId=" + auditId +
                ", expId=" + expId +
                ", empId='" + empId + '\'' +
                ", result='" + result + '\'' +
                ", auditDesc='" + auditDesc + '\'' +
                ", time=" + time +
                ", emp=" + emp +
                '}';
    }
}
