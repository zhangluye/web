package com.syxy.service.alerts;


import com.syxy.pojo.Alerts;

import java.sql.SQLException;
import java.util.List;

public interface AlertsService {
    //查询全部新闻
    public List<Alerts> getAllAlerts() throws SQLException;
    //查询新闻数量
    public int getAlertsCount() throws SQLException;
    //获取分页新闻
    public List<Alerts> getAlertsByPage(int currentPageNo,int pageSize) throws SQLException;
    //根据Id查询新闻
    public Alerts getAlertsById(int id) throws SQLException;
}
