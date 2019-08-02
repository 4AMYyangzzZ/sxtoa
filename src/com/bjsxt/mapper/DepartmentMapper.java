package com.bjsxt.mapper;

import com.bjsxt.pojo.Department;

import java.util.List;

public interface DepartmentMapper {
    public int addDepartment(Department department);

    List<Department> selectAllDept();

    Department selectDeptById(String deptNo);

    int updateDeptById(Department department);

    int deleteDeptById(String deptNo);
}
