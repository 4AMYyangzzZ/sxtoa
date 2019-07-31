package com.bjsxt.service;

import com.bjsxt.entity.CombineEmpAndDutyAndDept;

import java.util.Date;
import java.util.List;

public interface DutyService {
    public int sigin(String empId);

    public int sigout(String empId);

    public List<CombineEmpAndDutyAndDept> findDuty(String empId, int deptNo, Date dtDate);
}
