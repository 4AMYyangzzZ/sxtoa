package com.bjsxt.pojo;

public class Department  {
    private Integer deptNo;
    private String deptName;
    private String location;

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptNo=" + deptNo +
                ", deptName='" + deptName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
