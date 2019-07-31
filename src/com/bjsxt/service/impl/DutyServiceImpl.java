package com.bjsxt.service.impl;

import com.bjsxt.dao.DutyDao;
import com.bjsxt.dao.impl.DutyDaoImpl;
import com.bjsxt.entity.CombineEmpAndDutyAndDept;
import com.bjsxt.entity.Duty;
import com.bjsxt.service.DutyService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DutyServiceImpl implements DutyService {
    DutyDao dutyDao=new DutyDaoImpl();
    @Override
    public int sigin(String empId) {
       //判断是否已经签到过
        Duty duty=dutyDao.findByEmpId(empId);
        if (duty==null){
            Date date=new Date();
            duty=new Duty();
            duty.setEmpId(empId);
            duty.setSigninTime(new SimpleDateFormat("hh:mm:ss").format(date));
            duty.setDtDate(java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(date)));
            return dutyDao.insert(duty);
        }else {
            return 2;
        }
    }


    @Override
    public int sigout(String empId) {
        //判断是否签到
        Duty duty=dutyDao.findByEmpId(empId);
        if (duty==null){
            return 2;
        }else {
            Date date=new Date();
            return dutyDao.updateSigoutTime(new SimpleDateFormat("hh:mm:ss").format(date),empId,new SimpleDateFormat("yyyy-MM-dd").format(date));
        }
    }

    @Override
    public List<CombineEmpAndDutyAndDept> findDuty(String empId, int deptNo, Date dtDate) {
        return dutyDao.findDuty(empId,deptNo,dtDate);
    }
}
