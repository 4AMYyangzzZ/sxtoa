package com.bjsxt.entity;

import java.io.Serializable;
import java.util.Objects;

public class Department implements Serializable,Comparable<Department> {
    private int deptNo;
    private String deptName;
    private String location;

    @Override
    public int compareTo(Department o) {
        return 0;
    }

    public Department() {
    }

    public Department(int deptNo, String deptName, String location) {
        this.deptNo = deptNo;
        this.deptName = deptName;
        this.location = location;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return deptNo == that.deptNo &&
                Objects.equals(deptName, that.deptName) &&
                Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {

        return Objects.hash(deptNo, deptName, location);
    }
}
