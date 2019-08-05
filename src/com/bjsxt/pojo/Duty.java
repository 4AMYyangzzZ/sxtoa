package com.bjsxt.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Duty {
    private Integer dtId;
    private String empId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dtDate;
    private String signinTime;
    private String signoutTime;

    public Integer getDtId() {
        return dtId;
    }

    public void setDtId(Integer dtId) {
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
