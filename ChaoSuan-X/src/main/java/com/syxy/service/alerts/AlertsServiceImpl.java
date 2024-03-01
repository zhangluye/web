package com.syxy.service.alerts;

import com.syxy.dao.BaseDao;
import com.syxy.dao.alerts.AlertsDao;
import com.syxy.dao.alerts.AlertsDaoImpl;
import com.syxy.pojo.Alerts;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlertsServiceImpl implements AlertsService{
    private AlertsDao alertsDao;
    public AlertsServiceImpl(){
        alertsDao = new AlertsDaoImpl();
    }

    @Override
    public List<Alerts> getAllAlerts() throws SQLException {
        Connection connection = null;
        connection = BaseDao.getConnection();
        ArrayList<Alerts> alertsList = null;

        alertsList = (ArrayList<Alerts>) alertsDao.getAllAlerts(connection);
        BaseDao.closeResource(connection,null,null);

        return alertsList;
    }

    @Override
    public int getAlertsCount() throws SQLException {
        Connection connection = null;
        connection = BaseDao.getConnection();
        int pageCount = 0;

        pageCount = alertsDao.getAlertsCount(connection);
        BaseDao.closeResource(connection,null,null);
        return pageCount;
    }

    @Override
    public List<Alerts> getAlertsByPage(int currentPageNo, int pageSize) throws SQLException {
        Connection connection = null;
        connection = BaseDao.getConnection();
        ArrayList<Alerts> alertsList = null;

        alertsList = (ArrayList<Alerts>) alertsDao.getAlertsByPage(connection,currentPageNo,pageSize);
        BaseDao.closeResource(connection,null,null);
        return alertsList;
    }

    @Override
    public Alerts getAlertsById(int id) throws SQLException {
        Connection connection = null;
        connection = BaseDao.getConnection();
        Alerts alerts = null;

        alerts = alertsDao.getAlertsById(connection,id);
        BaseDao.closeResource(connection,null,null);
        return alerts;
    }
}
