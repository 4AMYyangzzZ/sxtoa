package com.bjsxt.dao.impl;

import com.bjsxt.dao.BaseDao;
import com.bjsxt.dao.IncomeDao;
import com.bjsxt.entity.Employee;
import com.bjsxt.entity.Expense;
import com.bjsxt.entity.Income;
import com.bjsxt.util.DBUtil1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IncomeDaoImpl implements IncomeDao {
    @Override
    public int save(Income income) {
        String sql="insert into income values(null,?,?,?,?,?)";
        Object param[]={income.getEmpId(),income.getAmount(),income.getIncomeDate(),income.getIncomeType(),income.getIncomeDesc()};
        return DBUtil1.executeUpdate(sql,param);
    }

    @Override
    public List<Income> getAllIncome() {
        Connection conn=null;
        PreparedStatement pstat=null;
        ResultSet resultSet=null;
        List<Income>list=null;
        try {
            conn= DBUtil1.getConnection();
            String sql="SELECT * FROM income GROUP BY ICTYPE";
            pstat=conn.prepareStatement(sql);
            resultSet=pstat.executeQuery();
            while (resultSet.next()){
                int incomeId=resultSet.getInt(1);
                String empId=resultSet.getString(2);
                int amount=resultSet.getInt(3);
                Date incomeDate=resultSet.getDate(4);
                String incomeType=resultSet.getString(5);
                String incomeDesc=resultSet.getString(6);
                Income income=new Income(incomeId,empId,amount,incomeDate,incomeType,incomeDesc);
                if (list==null){
                    list=new ArrayList<>();
                }
                list.add(income);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Object[]> getIncomeData() {
        Connection conn=null;
        PreparedStatement pstat=null;
        ResultSet resultSet=null;
        List<Object[]>list=null;
        try {
            conn= DBUtil1.getConnection();
            String sql="SELECT ictype,SUM(AMOUNT) FROM income GROUP BY ICTYPE ORDER BY ICTYPE DESC";
            pstat=conn.prepareStatement(sql);
            resultSet=pstat.executeQuery();
            while (resultSet.next()){
                String icType=resultSet.getString(1);
                int amount=resultSet.getInt(2);
                Object[]objects={icType,amount};
                if (list==null){
                    list=new ArrayList<>();
                }
                list.add(objects);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Object[]> getPaymentData() {
        return null;
    }
}
