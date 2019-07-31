package com.bjsxt.service.impl;

import com.bjsxt.dao.DepartmentDao;
import com.bjsxt.dao.impl.DepartmentDaoImpl;
import com.bjsxt.entity.Department;
import com.bjsxt.service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService{
    private DepartmentDao departmentDao=new DepartmentDaoImpl();
    @Override
    public Department findDeptByEmpId(String empId) {
        return departmentDao.findDeptByEmpId(empId);
    }

    @Override
    public boolean add(Department dept) {
        return departmentDao.save(dept)>0;
    }

    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    @Override
    public boolean delete(int deptNo) {
        return departmentDao.delete(deptNo)>0;
    }

    @Override
    public Department findById(int deptNo) {
        return departmentDao.findById(deptNo);
    }

    @Override
    public boolean update(Department dept) {
        return departmentDao.update(dept)>0;
    }
}
