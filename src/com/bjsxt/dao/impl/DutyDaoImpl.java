package com.bjsxt.dao.impl;

import com.bjsxt.dao.BaseDao;
import com.bjsxt.dao.DutyDao;
import com.bjsxt.entity.CombineEmpAndDutyAndDept;
import com.bjsxt.entity.Duty;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class DutyDaoImpl extends BaseDao implements DutyDao {
    @Override
    public Duty findByEmpId(String empId) {
        List<Duty> dutyList = baseQuery(Duty.class, "select * from duty where empId=? and dtDate=?", empId, new Date(new java.util.Date().getTime()));
        if (dutyList==null){
            return null;
        }else {
            return (Duty)dutyList.get(0);
        }
    }

    @Override
    public int insert(Duty duty) {

        return baseUpdate("insert into duty values(null,?,?,?,?)",duty.getEmpId(),duty.getDtDate(),duty.getSigninTime(),duty.getSignoutTime());
    }

    @Override
    public int updateSigoutTime(String sigoutTime, String empId, String dtDate) {
        return baseUpdate("update duty set signoutTime=? where empId=? and dtDate=?",sigoutTime,empId,Date.valueOf(dtDate));
    }

    @Override
    public List<CombineEmpAndDutyAndDept> findDuty(String empId, int deptNo, java.util.Date dtDate) {
        StringBuffer sb=new StringBuffer("SELECT e.EMPID,e.REALNAME,de.DEPTNAME,d.DTDATE,d.SIGNINTIME,d.SIGNOUTTIME FROM employee e,dept de,duty d WHERE e.DEPTNO=de.DEPTNO AND e.EMPID=d.EMPID");
        if (!"".equals(empId) && empId!=null){
            sb.append(" and e.EMPID like '%"+empId+"%'");
        }
        if (deptNo!=0){
            sb.append(" and de.deptNo ="+deptNo);
        }
        if (dtDate!=null){
            sb.append(" and d.DTDATE='"+Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(dtDate))+"'");
        }
        return baseQuery(CombineEmpAndDutyAndDept.class,sb.toString());
    }
}
