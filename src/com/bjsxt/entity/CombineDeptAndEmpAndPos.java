package com.bjsxt.entity;

import java.util.Date;

public class CombineDeptAndEmpAndPos {
    private int deptNo;
    private String deptName;
    private String location;

    private int posId;
    private String pName;
    private String pDesc;

    private String empId;
    private String emp_empId;//上级领导编号
    private String password;
    private String realName;
    private String sex;
    private Date birthDate;
    private Date hireDate;
    private Date leaveDate;
    private int onDuty;//是否在职
    private int empType;//员工类型
    private String phone;
    private String qq;
    private String emerContactPerson;
    private String idCard;

    public CombineDeptAndEmpAndPos(String deptName, String pName, String empId, String realName, Date hireDate, String phone) {
        this.deptName = deptName;
        this.pName = pName;
        this.empId = empId;
        this.realName = realName;
        this.hireDate = hireDate;
        this.phone = phone;
    }

    public CombineDeptAndEmpAndPos() {
    }

    public CombineDeptAndEmpAndPos(int deptNo, String deptName, String location, int posId, String pName, String pDesc, String empId, String emp_empId, String password, String realName, String sex, Date birthDate, Date hireDate, Date leaveDate, int onDuty, int empType, String phone, String qq, String emerContactPerson, String idCard) {
        this.deptNo = deptNo;
        this.deptName = deptName;
        this.location = location;
        this.posId = posId;
        this.pName = pName;
        this.pDesc = pDesc;
        this.empId = empId;
        this.emp_empId = emp_empId;
        this.password = password;
        this.realName = realName;
        this.sex = sex;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
        this.leaveDate = leaveDate;
        this.onDuty = onDuty;
        this.empType = empType;
        this.phone = phone;
        this.qq = qq;
        this.emerContactPerson = emerContactPerson;
        this.idCard = idCard;
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

    public int getPosId() {
        return posId;
    }

    public void setPosId(int posId) {
        this.posId = posId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpDesc() {
        return pDesc;
    }

    public void setpDesc(String pDesc) {
        this.pDesc = pDesc;
    }

    @Override
    public String toString() {
        return "CombineDeptAndEmpAndPos{" +
                "deptNo=" + deptNo +
                ", deptName='" + deptName + '\'' +
                ", location='" + location + '\'' +
                ", posId=" + posId +
                ", pName='" + pName + '\'' +
                ", pDesc='" + pDesc + '\'' +
                ", empId='" + empId + '\'' +
                ", emp_empId='" + emp_empId + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", sex='" + sex + '\'' +
                ", birthDate=" + birthDate +
                ", hireDate=" + hireDate +
                ", leaveDate=" + leaveDate +
                ", onDuty=" + onDuty +
                ", empType=" + empType +
                ", phone='" + phone + '\'' +
                ", qq='" + qq + '\'' +
                ", emerContactPerson='" + emerContactPerson + '\'' +
                ", idCard='" + idCard + '\'' +
                '}';
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmp_empId() {
        return emp_empId;
    }

    public void setEmp_empId(String emp_empId) {
        this.emp_empId = emp_empId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    public int getOnDuty() {
        return onDuty;
    }

    public void setOnDuty(int onDuty) {
        this.onDuty = onDuty;
    }

    public int getEmpType() {
        return empType;
    }

    public void setEmpType(int empType) {
        this.empType = empType;
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
}
