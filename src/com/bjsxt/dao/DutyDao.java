package com.bjsxt.dao;

import com.bjsxt.entity.CombineEmpAndDutyAndDept;
import com.bjsxt.entity.Duty;

import java.util.Date;
import java.util.List;

public interface DutyDao {
    public Duty findByEmpId(String empId);

    public int insert(Duty duty);

    public int updateSigoutTime(String sigoutTime, String empId, String dtDate);

    public List<CombineEmpAndDutyAndDept> findDuty(String empId, int deptNo, Date dtDate);
}
