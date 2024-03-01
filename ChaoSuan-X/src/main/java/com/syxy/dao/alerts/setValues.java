package com.syxy.dao.alerts;

import com.syxy.pojo.Alerts;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class setValues {
    //创建静态方法，将从数据库获取的结果集赋值给对象属性
     static List<Alerts> SetAlertsValue(ResultSet rs, ArrayList<Alerts> alertsList) throws SQLException {

        while (rs.next()) {
            Alerts alerts = new Alerts();
            alerts.setId(rs.getInt("id"));
            alerts.setTitle(rs.getString("title"));
            alerts.setContext(rs.getString("content"));
            alerts.setPubTime(rs.getDate("pubtime"));
            alertsList.add(alerts);
        }
        return alertsList;
    }


    static Alerts SetOneValue(ResultSet rs, Alerts alerts) throws SQLException {
        if (rs.next()) {
            alerts.setId(rs.getInt("id"));
            alerts.setTitle(rs.getString("title"));
            alerts.setContext(rs.getString("content"));
            alerts.setPubTime(rs.getDate("pubtime"));
        }
        return alerts;
    }
}
