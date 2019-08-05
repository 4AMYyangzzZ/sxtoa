package com.bjsxt.service.impl;

import com.bjsxt.mapper.DutyMapper;
import com.bjsxt.pojo.Duty;
import com.bjsxt.pojo.Employee;
import com.bjsxt.service.DutyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class DutyServiceImpl implements DutyService {
    @Autowired
    private DutyMapper dutyMapper;

    public DutyMapper getDutyMapper() {
        return dutyMapper;
    }

    public void setDutyMapper(DutyMapper dutyMapper) {
        this.dutyMapper = dutyMapper;
    }

    @Override
    public int sigin(String empid) {
        Duty duty=dutyMapper.selectDutyByIdAndDate(empid,new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        if (duty!=null){
            return 2;
        }else {
            Duty duty1=new Duty();
            duty1.setEmpId(empid);
            try {
                duty1.setDtDate(new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
                duty1.setSigninTime(new SimpleDateFormat("HH:mm:ss").format(new Date()));
                return dutyMapper.sigin(duty1);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return -1;
        }
    }

    @Override
    public String sigout(String empid) {
        Duty duty = new Duty();
        duty.setEmpId(empid);
        try {
            duty.setDtDate(new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
            duty.setSignoutTime(new SimpleDateFormat("HH:mm:ss").format(new Date()));
            if(dutyMapper.selectDutyByIdAndDate(empid,new SimpleDateFormat("yyyy-MM-dd").format(new Date()))!=null){
                if(dutyMapper.sigout(duty)>0){
                    return "签退成功";
                }else {
                    return "签退失败";
                }
            }else {
                return "请先签到";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> selectDutyByCondition(String empId, Integer deptNo, String dtDate) {
        return dutyMapper.selectDutyByCondition(empId,deptNo,dtDate);
    }


    @Override
    public List<Duty> selectDutyByMyself(String empid) {
        return dutyMapper.selectDutyByMyself(empid);
    }
}
