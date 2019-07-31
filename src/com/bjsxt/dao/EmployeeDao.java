package com.bjsxt.dao;

import com.bjsxt.entity.*;

import java.util.Date;
import java.util.List;

public interface EmployeeDao {
    public int empAdd(Employee emp);
    public List<CombineDeptAndEmpAndPos> empFindAll();

    public List<Department> deptFindAll();

    public List<Position> posFindAll();

    public List<CombineMgr> mgrFindAll();

    public CombineDeptAndEmpAndPos empInfoById(String empId);

    public int empUpdate(Employee emp);

    public List<CombineMgr> mgrFindAllExcludeSelef(String empId);

    public int empDelete(String empId);

    public List<CombineDeptAndEmpAndPos> empQuery(String empId, int deptNo, int onDuty, Date hireDate);

    public int modifyPwd(String empId);
}