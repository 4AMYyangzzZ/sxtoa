package com.bjsxt.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Employee {
    private String empid;
    private String emp_empid;//上级领导编号
    private Integer posid;//岗位编号
    private Integer deptno;//部门编号
    private String password;
    private String realname;
    private String sex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date birthdate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date hiredate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date leavedate;
    private Integer onduty;//是否在职
    private Integer emptype;//员工类型 0是领导，1是普通员工
    private String phone;
    private String qq;
    private String emerContactPerson;
    private String idCard;

    //关联属性部门
    private Department department;

    //关联属性职位
    private Position position;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getEmp_empid() {
        return emp_empid;
    }

    public void setEmp_empid(String emp_empid) {
        this.emp_empid = emp_empid;
    }

    public Integer getPosid() {
        return posid;
    }

    public void setPosid(Integer posid) {
        this.posid = posid;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Date getLeavedate() {
        return leavedate;
    }

    public void setLeavedate(Date leavedate) {
        this.leavedate = leavedate;
    }

    public Integer getOnduty() {
        return onduty;
    }

    public void setOnduty(Integer onduty) {
        this.onduty = onduty;
    }

    public Integer getEmptype() {
        return emptype;
    }

    public void setEmptype(Integer emptype) {
        this.emptype = emptype;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmerContactPerson() {
        return emerContactPerson;
    }

    public void setEmerContactPerson(String emerContactPerson) {
        this.emerContactPerson = emerContactPerson;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empid='" + empid + '\'' +
                ", emp_empid='" + emp_empid + '\'' +
                ", posid=" + posid +
                ", deptno=" + deptno +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", sex='" + sex + '\'' +
                ", birthdate=" + birthdate +
                ", hiredate=" + hiredate +
                ", leavedate=" + leavedate +
                ", onduty=" + onduty +
                ", emptype=" + emptype +
                ", phone='" + phone + '\'' +
                ", qq='" + qq + '\'' +
                ", emerContactPerson='" + emerContactPerson + '\'' +
                ", idCard='" + idCard + '\'' +
                '}';
    }
}
