package com.bjsxt.service.impl;

import com.bjsxt.mapper.EmployeeMapper;
import com.bjsxt.pojo.Employee;
import com.bjsxt.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    public EmployeeMapper getEmployeeMapper() {
        return employeeMapper;
    }

    public void setEmployeeMapper(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Override
    public Employee login(Employee employee) {
        return employeeMapper.login(employee);
    }

    @Override
    public List<Employee> selectAllLeader() {
        return employeeMapper.selectAllLeader();
    }

    @Override
    public List<Employee> selectAllEmp() {
        return employeeMapper.selectAllEmp();
    }

    @Override
    public int addEmployee(Employee employee) {
        employee.setPassword("root");
        return employeeMapper.addEmployee(employee);
    }

    @Override
    public Employee selectEmpById(String empid) {
        return employeeMapper.selectEmpById(empid);
    }

    @Override
    public List<Employee> selectAllLeaderExcludeSelf(String empid) {
        return employeeMapper.selectAllLeaderExcludeSelf(empid);
    }

    @Override
    public int updateEmpById(Employee employee) {
        return employeeMapper.updateEmpById(employee);
    }

    @Override
    public int deleteEmpById(String empid) {
        return employeeMapper.deleteEmpById(empid);
    }

    @Override
    public Employee checkOldPwd(String empid, String password) {
        return employeeMapper.checkOldPwd(empid,password);
    }

    @Override
    public int updatePwd(String empid, String password) {
        return employeeMapper.updatePwd(empid,password);
    }

    @Override
    public List<Employee> selectEmpByCondition(Employee employee) {
        return employeeMapper.selectEmpByCondition(employee);
    }
}
