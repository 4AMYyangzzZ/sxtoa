package com.bjsxt.service;

import com.bjsxt.entity.Department;

import java.util.List;

public interface DepartmentService {
    public boolean add(Department dept);

    public List<Department> findAll();

    public boolean delete(int deptNo);

    public Department findById(int deptNo);

    public boolean update(Department dept);

    public Department findDeptByEmpId(String empId);
}
