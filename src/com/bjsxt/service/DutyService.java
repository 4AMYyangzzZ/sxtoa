package com.bjsxt.service;

import com.bjsxt.pojo.Duty;
import com.bjsxt.pojo.Employee;

import java.util.List;

public interface DutyService {
    int sigin(String empid);

    String sigout(String empid);

    List<Employee> selectDutyByCondition(String empId, Integer deptNo, String dtDate);

    List<Duty> selectDutyByMyself(String empid);

}
