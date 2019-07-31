package com.bjsxt.entity;

public class CombineMgr {
    private String empId;
    private String realName;

    public CombineMgr(String empId, String realName) {
        this.empId = empId;
        this.realName = realName;
    }

    public CombineMgr() {
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

    @Override
    public String toString() {
        return "CombineMgr{" +
                "empId='" + empId + '\'' +
                ", realName='" + realName + '\'' +
                '}';
    }
}
