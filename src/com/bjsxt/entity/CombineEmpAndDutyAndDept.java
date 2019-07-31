package com.bjsxt.entity;

import java.util.Date;

public class CombineEmpAndDutyAndDept {
    private String empId;
    private String realName;
    private String deptName;
    private Date dtDate;
    private String signinTime;
    private String signoutTime;

    public CombineEmpAndDutyAndDept() {
    }

    public CombineEmpAndDutyAndDept(String empId, String realName, String deptName, Date dtDate, String signinTime, String signoutTime) {
        this.empId = empId;
        this.realName = realName;
        this.deptName = deptName;
        this.dtDate = dtDate;
        this.signinTime = signinTime;
        this.signoutTime = signoutTime;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
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
        return "CombineEmpAndDutyAndDept{" +
                "empId='" + empId + '\'' +
                ", realName='" + realName + '\'' +
                ", deptName='" + deptName + '\'' +
                ", dtDate=" + dtDate +
                ", signinTime='" + signinTime + '\'' +
                ", signoutTime='" + signoutTime + '\'' +
                '}';
    }
}
