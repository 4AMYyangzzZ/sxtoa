package com.bjsxt.dao;

import com.bjsxt.entity.Department;

import java.util.List;

public interface DepartmentDao {
    public int save(Department dept);

    public List<Department> findAll();

    public int delete(int deptNo);

    public Department findById(int deptNo);

    public int update(Department dept);

    public Department findDeptByEmpId(String empId);
}
