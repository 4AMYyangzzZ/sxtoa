package com.bjsxt.service;

import com.bjsxt.entity.*;

import java.util.Date;
import java.util.List;

public interface EmployeeService {
    public boolean empAdd(Employee emp);

    public List<CombineDeptAndEmpAndPos> empFindAll();

    public List<Department> deptFindAll();

    public List<Position> posFindAll();

    public List<CombineMgr> mgrFindAll();

    public CombineDeptAndEmpAndPos empInfoById(String empId);

    public boolean empUpdate(Employee emp);

    public List<CombineMgr> mgrFindAllExcludeSelef(String empId);

    public boolean empDelete(String empId);

    public List<CombineDeptAndEmpAndPos> empQuery(String empId, int deptNo, int onDuty, Date hireDate);

    public boolean modifyPwd(String empId);

    public CombineDeptAndEmpAndPos empInfoById(String empId, String password);
}
