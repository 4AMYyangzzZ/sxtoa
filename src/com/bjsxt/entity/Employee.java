package com.bjsxt.entity;

import java.util.Date;
import java.util.List;

public class Employee {
    private String empId;
    private String emp_empId;//上级领导编号
    private int posId;//岗位编号
    private int deptNo;//部门编号
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

//    private Department dept;
//    private Position pos;
//    private Employee mgr;//上级
//    private List<Employee>employeeList;//所有下级


    public Employee() {
    }


    public Employee(String empId, String emp_empId, int posId, int deptNo, String password, String realName, String sex, Date birthDate, Date hireDate, Date leaveDate, int onDuty, int empType, String phone, String qq, String emerContactPerson, String idCard) {
        this.empId = empId;
        this.emp_empId = emp_empId;
        this.posId = posId;
        this.deptNo = deptNo;
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

//    public Department getDept() {
//        return dept;
//    }
//
//    public void setDept(Department dept) {
//        this.dept = dept;
//    }
//
//    public Position getPos() {
//        return pos;
//    }
//
//    public void setPos(Position pos) {
//        this.pos = pos;
//    }
//
//    public Employee getMgr() {
//        return mgr;
//    }
//
//    public void setMgr(Employee mgr) {
//        this.mgr = mgr;
//    }
//
//    public List<Employee> getEmployeeList() {
//        return employeeList;
//    }
//
//    public void setEmployeeList(List<Employee> employeeList) {
//        this.employeeList = employeeList;
//    }

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

    public int getPosId() {
        return posId;
    }

    public void setPosId(int posId) {
        this.posId = posId;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
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

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", emp_empId='" + emp_empId + '\'' +
                ", posId=" + posId +
                ", deptNo=" + deptNo +
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
}
