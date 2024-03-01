package com.syxy.dao.admic;

import com.syxy.pojo.Admic;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class setValues {
    //创建静态方法，将从数据库获取的结果集赋值给对象属性
     static List<Admic> SetAdmicsValue(ResultSet rs, ArrayList<Admic> admicsList) throws SQLException {

        while (rs.next()) {
            Admic admic = new Admic();
            admic.setId(rs.getInt("id"));
            admic.setTitle(rs.getString("title"));
            admic.setContext(rs.getString("content"));
            admic.setPubTime(rs.getDate("pubtime"));
            admicsList.add(admic);
        }
        return admicsList;
    }


    static Admic SetOneValue(ResultSet rs, Admic admic) throws SQLException {
        if (rs.next()) {
            admic.setId(rs.getInt("id"));
            admic.setTitle(rs.getString("title"));
            admic.setContext(rs.getString("content"));
            admic.setPubTime(rs.getDate("pubtime"));
        }
        return admic;
    }
}
