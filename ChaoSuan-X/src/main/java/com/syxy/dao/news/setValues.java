package com.syxy.dao.news;

import com.syxy.pojo.News;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class setValues {
    //创建静态方法，将从数据库获取的结果集赋值给对象属性
     static List<News> SetNewsValue(ResultSet rs, ArrayList<News> newsList) throws SQLException {

        while (rs.next()) {
            News news = new News();
            news.setId(rs.getInt("id"));
            news.setTitle(rs.getString("title"));
            news.setContext(rs.getString("content"));
            news.setPubTime(rs.getDate("pubtime"));
            newsList.add(news);
        }
        return newsList;
    }


    static News SetOneValue(ResultSet rs, News news) throws SQLException {
        if (rs.next()) {
            news.setId(rs.getInt("id"));
            news.setTitle(rs.getString("title"));
            news.setContext(rs.getString("content"));
            news.setPubTime(rs.getDate("pubtime"));
        }
        return news;
    }
}
