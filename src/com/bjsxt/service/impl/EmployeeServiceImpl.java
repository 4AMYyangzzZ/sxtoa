package com.bjsxt.service.impl;

import com.bjsxt.dao.EmployeeDao;
import com.bjsxt.dao.impl.EmployeeDaoImpl;
import com.bjsxt.entity.*;
import com.bjsxt.service.EmployeeService;

import java.util.Date;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao=new EmployeeDaoImpl();
    @Override
    public boolean empAdd(Employee emp) {
        return employeeDao.empAdd(emp)>0;
    }

    @Override
    public List<CombineDeptAndEmpAndPos> empFindAll() {
        return employeeDao.empFindAll();
    }

    @Override
    public List<Department> deptFindAll() {
        return employeeDao.deptFindAll();
    }

    @Override
    public List<Position> posFindAll() {
        return employeeDao.posFindAll();
    }

    @Override
    public List<CombineMgr> mgrFindAll() {
        return employeeDao.mgrFindAll();
    }

    @Override
    public CombineDeptAndEmpAndPos empInfoById(String empId) {
        return employeeDao.empInfoById(empId);
    }

    @Override
    public boolean empUpdate(Employee emp) {
        return employeeDao.empUpdate(emp)>0;
    }

    @Override
    public List<CombineMgr> mgrFindAllExcludeSelef(String empId) {
        return employeeDao.mgrFindAllExcludeSelef(empId);
    }

    @Override
    public boolean empDelete(String empId) {
        return employeeDao.empDelete(empId)>0;
    }

    @Override
    public List<CombineDeptAndEmpAndPos> empQuery(String empId, int deptNo, int onDuty, Date hireDate) {
        return employeeDao.empQuery(empId,deptNo,onDuty,hireDate);
    }

    @Override
    public boolean modifyPwd(String empId) {
        return employeeDao.modifyPwd(empId)>0;
    }

    @Override
    public CombineDeptAndEmpAndPos empInfoById(String empId, String password) {
        CombineDeptAndEmpAndPos emp=employeeDao.empInfoById(empId);
        if (emp==null) {
            return null;
        }else {
            if (emp.getPassword().equals(password)){
                return emp;
            }else {
                return null;
            }
        }
    }
}
