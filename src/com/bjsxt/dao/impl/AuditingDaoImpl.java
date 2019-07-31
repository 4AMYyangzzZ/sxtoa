package com.bjsxt.dao.impl;

import com.bjsxt.dao.AuditingDao;
import com.bjsxt.entity.Auditing;
import com.bjsxt.util.DBUtil2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class AuditingDaoImpl implements AuditingDao {

    @Override
    public void addAudit(Auditing auditing) {
        Connection conn=null;
        PreparedStatement pstat=null;
        try {
            conn= DBUtil2.getConnection();
            String sql="insert INTO auditing VALUES(NULL ,?,?,?,?,?) ";
            pstat = conn.prepareStatement(sql);
            pstat.setInt(1,auditing.getExpId());
            pstat.setString(2,auditing.getEmpId());
            pstat.setString(3,auditing.getResult());
            pstat.setString(4,auditing.getAuditDesc());
            pstat.setString(5,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(auditing.getTime()));
            int i = pstat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil2.closeAll(null,pstat,null);
        }
    }
}
