package com.bjsxt.dao.impl;

import com.bjsxt.dao.BaseDao;
import com.bjsxt.dao.EmployeeDao;
import com.bjsxt.entity.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class EmployeeDaoImpl extends BaseDao implements EmployeeDao {
    @Override
    public int empAdd(Employee emp) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Object []param={emp.getEmpId(),
                        emp.getEmp_empId(),
                        emp.getPosId(),
                        emp.getDeptNo(),
                        emp.getPassword(),
                        emp.getRealName(),
                        emp.getSex(),
                        Date.valueOf(sdf.format(emp.getBirthDate())),
                        Date.valueOf(sdf.format(emp.getHireDate())),
                        Date.valueOf(sdf.format(emp.getLeaveDate())),
                        emp.getOnDuty(),
                        emp.getEmpType(),
                        emp.getPhone(),
                        emp.getQq(),
                        emp.getEmerContactPerson(),
                        emp.getIdCard()
        };
        return baseUpdate("insert into employee values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",param);
    }

    @Override
    public List<CombineDeptAndEmpAndPos> empFindAll() {
        String sql="SELECT * FROM employee e,dept d,position p WHERE e.DEPTNO=d.DEPTNO AND e.POSID=p.POSID";
        return baseQuery(CombineDeptAndEmpAndPos.class,sql);
    }

    @Override
    public List<Department> deptFindAll() {
        return baseQuery(Department.class,"select * from dept");
    }

    @Override
    public List<Position> posFindAll() {
        return baseQuery(Position.class,"select * from position");
    }

    @Override
    public List<CombineMgr> mgrFindAll() {
        return baseQuery(CombineMgr.class,"SELECT e1.EMPID,e1.REALNAME FROM employee e1,employee e2 WHERE e1.EMP_EMPID=e2.EMPID AND e1.EMPTYPE=0");
    }

    @Override
    public CombineDeptAndEmpAndPos empInfoById(String empId) {
        return (CombineDeptAndEmpAndPos)baseQuery(CombineDeptAndEmpAndPos.class,"SELECT * FROM employee e,dept d,position p WHERE e.DEPTNO=d.DEPTNO AND e.POSID=p.POSID and empId=?",empId).get(0);
    }

    @Override
    public int empUpdate(Employee emp) {
        Object []param={emp.getRealName(),emp.getSex(),emp.getBirthDate(),emp.getHireDate(),emp.getLeaveDate(),emp.getOnDuty(),emp.getDeptNo(),emp.getEmp_empId(),emp.getPhone(),emp.getQq(),emp.getEmerContactPerson(),emp.getIdCard(),emp.getEmpId()};
        return baseUpdate("UPDATE employee  SET REALNAME=?,SEX=?,BIRTHDATE=?,HIREDATE=?,LEAVEDATE=?,ONDUTY=?,DEPTNO=?,EMP_EMPID=?,PHONE=?,QQ=?,EMERCONTACTPERSON=?,IDCARD=? WHERE EMPID=?",param);
    }

    @Override
    public List<CombineMgr> mgrFindAllExcludeSelef(String empId) {
        return baseQuery(CombineMgr.class,"SELECT e1.EMPID,e1.REALNAME FROM employee e1,employee e2 WHERE e1.EMP_EMPID=e2.EMPID AND e1.EMPTYPE=0 and e1.empId!=?",empId);
    }

    @Override
    public int empDelete(String empId) {
        return baseUpdate("delete from employee where empId=?",empId);
    }

    @Override
    public List<CombineDeptAndEmpAndPos> empQuery(String empId, int deptNo, int onDuty, java.util.Date hireDate) {
        boolean flag1=false;
        boolean flag2=false;
        //StringBuffer sql=new StringBuffer("SELECT * FROM employee e,dept d,position p WHERE e.DEPTNO=d.DEPTNO AND e.POSID=p.POSID and e.deptNo=? and onDuty=?");
        StringBuffer sql=new StringBuffer("SELECT * FROM employee e,dept d,position p WHERE e.DEPTNO=d.DEPTNO AND e.POSID=p.POSID");
        if (deptNo!=-1){
            sql.append(" and e.deptNo="+deptNo);
        }
        if (onDuty!=-1){
            sql.append(" and onDuty="+onDuty);
        }
        if(!"".equals(empId) && empId!=null ){
            sql.append(" and empId like '%"+empId+"%'");
            flag1=true;
        }
//        if(!"".equals(empId) && empId!=null ){
//            sql.append(" and empId like \"%\"?\"%\"");
//            flag1=true;
//        }
//        if(hireDate!=null ){
//            sql.append(" and hireDate=?");
//            flag2=true;
//        }
        if(hireDate!=null ){
            sql.append(" and hireDate<='"+hireDate+"'");
            flag2=true;
        }
//        if(flag1 && flag2){
//            return baseQuery(CombineDeptAndEmpAndPos.class,sql.toString(),deptNo,onDuty,empId,hireDate);
//        }else if (!flag1 && flag2){
//            return baseQuery(CombineDeptAndEmpAndPos.class,sql.toString(),deptNo,onDuty,hireDate);
//        }else if(flag1 && !flag2){
//            return baseQuery(CombineDeptAndEmpAndPos.class,sql.toString(),deptNo,onDuty,empId);
//        }else {
//            return baseQuery(CombineDeptAndEmpAndPos.class,sql.toString(),deptNo,onDuty);
//        }
        return baseQuery(CombineDeptAndEmpAndPos.class,sql.toString());
    }

    @Override
    public int modifyPwd(String empId) {
        return baseUpdate("update employee set password='123456' where empId=?",empId);
    }
}
