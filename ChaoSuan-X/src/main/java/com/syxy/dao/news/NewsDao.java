package com.syxy.dao.news;

import com.syxy.pojo.News;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface NewsDao {
    //获取所有新闻动态
    public List<News> getAllNews(Connection connection) throws SQLException;
    //查询新闻记录数
    public int getNewsCount(Connection connection) throws SQLException;
    //获取分页新闻结果
    public List<News> getNewsByPage(Connection connection,int currentPageNo,int pageSize) throws SQLException;
    //根据id获取新闻
    public News getNewsById(Connection connection,int id) throws SQLException;
    //获取关键字检索新闻的结果
    public List<News> queryNews(Connection connection,int currentPageNo,int pageSize,String message) throws SQLException;
    //查询检索新闻的记录数
    public int getSearchNewsCount(Connection connection,String message) throws SQLException;
}