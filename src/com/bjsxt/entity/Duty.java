package com.bjsxt.entity;

import java.util.Date;

public class Duty {
    private int dtId;
    private String empId;
    private Date dtDate;
    private String signinTime;
    private String signoutTime;

    public Duty(String empId, Date dtDate, String signinTime, String signoutTime) {
        this.empId = empId;
        this.dtDate = dtDate;
        this.signinTime = signinTime;
        this.signoutTime = signoutTime;
    }

    public Duty() {
    }

    public Duty(int dtId, String empId, Date dtDate, String signinTime, String signoutTime) {
        this.dtId = dtId;
        this.empId = empId;
        this.dtDate = dtDate;
        this.signinTime = signinTime;
        this.signoutTime = signoutTime;
    }

    public int getDtId() {
        return dtId;
    }

    public void setDtId(int dtId) {
        this.dtId = dtId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public Date getDtDate() {
        return dtDate;
    }

    public void setDtDate(Date dtDate) {
        this.dtDate = dtDate;
    }

    public String getSigninTime() {
        return signinTime;
    }

    public void setSigninTime(String signinTime) {
        this.signinTime = signinTime;
    }

    public String getSignoutTime() {
        return signoutTime;
    }

    public void setSignoutTime(String signoutTime) {
        this.signoutTime = signoutTime;
    }

    @Override
    public String toString() {
        return "Duty{" +
                "dtId=" + dtId +
                ", empId='" + empId + '\'' +
                ", dtDate=" + dtDate +
                ", signinTime='" + signinTime + '\'' +
                ", signoutTime='" + signoutTime + '\'' +
                '}';
    }
}
