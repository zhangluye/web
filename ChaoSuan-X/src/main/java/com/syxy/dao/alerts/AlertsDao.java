package com.syxy.dao.alerts;


import com.syxy.pojo.Alerts;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface AlertsDao {
    //获取所有快讯
    public List<Alerts> getAllAlerts(Connection connection) throws SQLException;
    //查询记录数
    public int getAlertsCount(Connection connection) throws SQLException;
    //获取分页结果
    public List<Alerts> getAlertsByPage(Connection connection,int currentPageNo,int pageSize) throws SQLException;
    //根据id获取结果
    public Alerts getAlertsById(Connection connection,int id) throws SQLException;
}
