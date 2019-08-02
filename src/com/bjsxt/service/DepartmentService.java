package com.bjsxt.service;

import com.bjsxt.pojo.Department;

import java.util.List;

public interface DepartmentService {
    public int addDepartment(Department dept);

    List<Department> selectAllDept();

    Department selectDeptById(String deptNo);

    int updateDeptById(Department department);

    int deleteDeptById(String deptNo);
}
