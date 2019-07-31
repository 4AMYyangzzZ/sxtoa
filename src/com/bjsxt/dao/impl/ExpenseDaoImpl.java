package com.bjsxt.dao.impl;

import com.bjsxt.dao.BaseDao;
import com.bjsxt.dao.ExpenseDao;
import com.bjsxt.entity.Employee;
import com.bjsxt.entity.Expense;
import com.bjsxt.util.DBUtil;
import com.bjsxt.util.DBUtil1;
import com.bjsxt.util.DBUtil2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExpenseDaoImpl  extends  BaseDao implements ExpenseDao {

    @Override
    public void updateExp(Expense expense1) {
        Connection conn=null;
        PreparedStatement pstat=null;
        ResultSet resultSet=null;

        try {
            conn= DBUtil2.getConnection();
            String sql="UPDATE expense SET nextAuditor=? , lastResult=? ,status=? WHERE expId=?";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1,expense1.getNextAuditor());
            pstat.setString(2,expense1.getLastResult());
            pstat.setString(3,expense1.getStatus());
            pstat.setInt(4,expense1.getExpId());
            int i = pstat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil2.closeAll(resultSet,pstat,null);
        }
    }

    @Override
    public Expense find(int expId) {
        Connection conn=null;
        PreparedStatement pstat=null;
        ResultSet resultSet=null;
        Expense exp=null;
        try {
            conn=DBUtil1.getConnection();
            String sql="SELECT * FROM expense  WHERE expId=? ";
            pstat=conn.prepareStatement(sql);
            pstat.setInt(1,expId);
            resultSet=pstat.executeQuery();
            while (resultSet.next()){
                double totalAmount=resultSet.getDouble("totalAmount");
                Date expTime=resultSet.getDate("expTime");
                String expDesc=resultSet.getString("expDesc");
                String empId=resultSet.getString("empId");
                String nextAuditor=resultSet.getString("nextAuditor");
                String lastResult =resultSet.getString("lastResult");
                String status=resultSet.getString("status");
                exp=new Expense();
                exp.setEmpId(empId);
                exp.setExpId(expId);
                exp.setTotalAmount(totalAmount);
                exp.setExpTime(expTime);
                exp.setExpDesc(expDesc);
                exp.setNextAuditor(nextAuditor);
                exp.setLastResult(lastResult);
                exp.setStatus(status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exp;
    }

    @Override
    public List<Expense> findExpById(String empId) {
        Connection conn=null;
        PreparedStatement pstat=null;
        ResultSet resultSet=null;
        List<Expense>expList=null;
        try {
            conn=DBUtil1.getConnection();
            String sql="SELECT emp.REALNAME,exp.* FROM employee emp,expense exp WHERE emp.EMPID=exp.EMPID AND NEXTAUDITOR=? ";
            pstat=conn.prepareStatement(sql);
            pstat.setString(1,empId);
            resultSet=pstat.executeQuery();
            while (resultSet.next()){
                int expId=resultSet.getInt("expId");
                String realName=resultSet.getString("realName");
                double totalAmount=resultSet.getDouble("totalAmount");
                Date expTime=resultSet.getDate("expTime");
                String expDesc=resultSet.getString("expDesc");
                Expense expense=new Expense();
                Employee emp=new Employee();
                emp.setEmpId(empId);
                emp.setRealName(realName);
                expense.setExpId(expId);
                expense.setEmpId(empId);
                expense.setTotalAmount(totalAmount);
                expense.setExpTime(expTime);
                expense.setExpDesc(expDesc);
                expense.setEmp(emp);
                if (expList==null){
                    expList=new ArrayList<>();
                }
                expList.add(expense);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expList;
    }

    @Override
    public int addExpense(Expense expense) {
        Connection conn=null;
        PreparedStatement pstat=null;
        ResultSet resultSet=null;
        int i=0;
        try {
            conn= DBUtil2.getConnection();
            String sql="insert INTO expense VALUES(NULL ,?,?,?,?,?,?,?) ";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1,expense.getEmpId());
            pstat.setDouble(2,expense.getTotalAmount());
            pstat.setDate(3,java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(expense.getExpTime())));
            pstat.setString(4,expense.getExpDesc());
            pstat.setString(5,expense.getNextAuditor());
            pstat.setString(6,expense.getLastResult());
            pstat.setString(7,expense.getStatus());
            i = pstat.executeUpdate();
            sql="SELECT @@identity";
            pstat=conn.prepareStatement(sql);
            resultSet=pstat.executeQuery();
            resultSet.next();
            i=resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil2.closeAll(resultSet,pstat,null);
        }
        return i;
    }
}
