package com.bjsxt.mapper;

import com.bjsxt.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    public Employee login(Employee employee);

    List<Employee> selectAllLeader();

    List<Employee> selectAllEmp();

    int addEmployee(Employee employee);

    Employee selectEmpById(String empid);

    List<Employee> selectAllLeaderExcludeSelf(String empid);

    int updateEmpById(Employee employee);

    int deleteEmpById(String empid);

    Employee checkOldPwd(@Param("empid") String empid, @Param("password") String password);

    int updatePwd(@Param("empid")String empid, @Param("password")String password);

    List<Employee> selectEmpByCondition(Employee employee);
}
