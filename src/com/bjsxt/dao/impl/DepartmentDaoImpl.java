package com.bjsxt.dao.impl;

import com.bjsxt.dao.BaseDao;
import com.bjsxt.dao.DepartmentDao;
import com.bjsxt.entity.Department;

import java.util.List;

public class DepartmentDaoImpl extends BaseDao implements DepartmentDao {
    @Override
    public Department findDeptByEmpId(String empId) {
        return (Department) baseQuery(Department.class,"SELECT DISTINCT(d.DEPTNO),d.DEPTNAME,d.LOCATION FROM income i ,employee emp,dept d WHERE i.EMPID=emp.EMPID AND emp.DEPTNO=d.DEPTNO AND i.EMPID=?",empId).get(0);
    }

    @Override
    public int save(Department dept) {
        return baseUpdate("insert into dept values(?,?,?)",dept.getDeptNo(),dept.getDeptName(),dept.getLocation());
    }

    @Override
    public List<Department> findAll() {
        return baseQuery(Department.class,"select * from dept");
    }

    @Override
    public int delete(int deptNo) {
        return baseUpdate("delete from dept where deptNo=?",deptNo);
    }

    @Override
    public Department findById(int deptNo) {
        return (Department)baseQuery(Department.class,"select * from dept where deptNo=?",deptNo).get(0);
    }

    @Override
    public int update(Department dept) {
        return baseUpdate("update dept set deptName=?,location=? where deptNo=?",dept.getDeptName(),dept.getLocation(),dept.getDeptNo());
    }
}
