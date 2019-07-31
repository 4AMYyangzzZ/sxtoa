package com.bjsxt.dao.impl;

import com.bjsxt.dao.PaymentDao;
import com.bjsxt.entity.Payment;
import com.bjsxt.util.DBUtil;
import com.bjsxt.util.DBUtil1;
import com.bjsxt.util.DBUtil2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentDaoImpl implements PaymentDao {
    @Override
    public void save(Payment payment) {
        String sql="insert into payment values(null,?,?,?,?,?)";
        Object[] param={payment.getExpId(),payment.getPayEmpId(),payment.getAmount(),payment.getDate(),payment.getEmpId()};
        DBUtil2.executeUpdate(sql,param);
    }

    @Override
    public List<Object[]> getPaymentData() {

        Connection conn=null;
        PreparedStatement pstat=null;
        ResultSet resultSet=null;
        List<Object[]>list=null;
        try {
            conn= DBUtil1.getConnection();
            String sql="SELECT item.TYPE,SUM(item.AMOUNT) FROM payment p,expense exp,expenseitem item WHERE p.EXPID=exp.EXPID AND exp.EXPID=item.EXPID GROUP BY item.TYPE";
            pstat=conn.prepareStatement(sql);
            resultSet=pstat.executeQuery();
            while (resultSet.next()){
                String type=resultSet.getString(1);
                double sum=resultSet.getDouble(2);
                Object[]objects={type,sum};
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
}
