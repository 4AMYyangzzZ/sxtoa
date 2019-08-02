package com.bjsxt.service;

import com.bjsxt.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee login(Employee employee);

    List<Employee> selectAllLeader();

    List<Employee> selectAllEmp();

    int addEmployee(Employee employee);

    Employee selectEmpById(String empid);

    List<Employee> selectAllLeaderExcludeSelf(String empid);

    int updateEmpById(Employee employee);

    int deleteEmpById(String empid);

    Employee checkOldPwd(String empid, String password);

    int updatePwd(String empid, String password);

    List<Employee> selectEmpByCondition(Employee employee);
}
