package com.syxy.dao.alerts;

import com.syxy.dao.BaseDao;
import com.syxy.pojo.Alerts;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlertsDaoImpl implements AlertsDao{
    @Override
    public List<Alerts> getAllAlerts(Connection connection) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Alerts> alertsList = new ArrayList<>();

        if(connection != null){
            String sql = "select * from alerts";
            //获取数据库查找结果集
            rs = BaseDao.execute(connection,sql,null,rs,pstm);
            alertsList = setValues.SetAlertsValue(rs, (ArrayList<Alerts>) alertsList);

        }else {
            System.out.println("数据库连接失败！");
        }
        BaseDao.closeResource(connection,pstm,rs);
        return alertsList;
    }

    @Override
    public int getAlertsCount(Connection connection) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int pageCount = 0;

        if (connection != null){
            String sql = "select count(1) as count from alerts";
            rs = BaseDao.execute(connection,sql,null,rs,pstm);
            if (rs.next()){
                pageCount = rs.getInt("count");
            }
        }else {
            System.out.println("数据库连接失败!");
        }
        BaseDao.closeResource(connection,pstm,rs);
        return pageCount;
    }

    @Override
    public List<Alerts> getAlertsByPage(Connection connection, int currentPageNo, int pageSize) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Alerts> alertsList = new ArrayList<>();

        if (connection != null){
            String sql = "select * from alerts limit ?,?";
            List<Object> list = new ArrayList<>();
            currentPageNo = (currentPageNo-1)*pageSize;
            list.add(currentPageNo);
            list.add(pageSize);
            Object[] param = list.toArray();

            rs = BaseDao.execute(connection, sql, param, rs, pstm);
            alertsList = setValues.SetAlertsValue(rs, (ArrayList<Alerts>) alertsList);
        }else {
            System.out.println("数据库连接失败!");
        }
        BaseDao.closeResource(connection,pstm,rs);
        return alertsList;
    }

    @Override
    public Alerts getAlertsById(Connection connection, int id) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Alerts alerts = new Alerts();

        if (connection != null){
            String sql = "select * from alerts where id=?";
            List<Object> list = new ArrayList<>();
            list.add(id);
            Object[] param = list.toArray();

            rs = BaseDao.execute(connection, sql, param, rs, pstm);
            alerts = setValues.SetOneValue(rs,alerts);

        }
        BaseDao.closeResource(connection,pstm,rs);
        return alerts;
    }

    @Test
    public void test01() throws SQLException {
        List<Alerts> alertsList = new ArrayList<>();
        alertsList = getAllAlerts(BaseDao.getConnection());
        System.out.println(alertsList);
    }
}
