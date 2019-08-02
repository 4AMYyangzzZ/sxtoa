package com.bjsxt.service.impl;

import com.bjsxt.pojo.Department;
import com.bjsxt.mapper.DepartmentMapper;
import com.bjsxt.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentMapper departmentMapper;

    public DepartmentMapper getDepartmentMapper() {
        return departmentMapper;
    }

    public void setDepartmentMapper(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    @Override
    public int addDepartment(Department dept) {
        return departmentMapper.addDepartment(dept);
    }

    @Override
    public List<Department> selectAllDept() {
        return departmentMapper.selectAllDept();
    }

    @Override
    public Department selectDeptById(String deptNo) {
        return departmentMapper.selectDeptById(deptNo);
    }

    @Override
    public int updateDeptById(Department department) {
        return departmentMapper.updateDeptById(department);
    }

    @Override
    public int deleteDeptById(String deptNo) {
        return departmentMapper.deleteDeptById(deptNo);
    }
}
