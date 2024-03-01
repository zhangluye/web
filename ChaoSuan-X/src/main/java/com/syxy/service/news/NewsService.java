package com.syxy.service.news;

import com.syxy.pojo.News;

import java.sql.SQLException;
import java.util.List;

public interface NewsService {
    //查询全部新闻
    public List<News> getAllNews() throws SQLException;
    //查询新闻数量
    public int getNewsCount() throws SQLException;
    //获取分页新闻
    public List<News> getNewsByPage(int currentPageNo,int pageSize) throws SQLException;
    //根据Id查询新闻
    public News getNewsById(int id) throws SQLException;
    //关键字检索新闻
    public List<News> queryNews(String message,int currentPageNo,int pageSize) throws SQLException;
    //关键字检索新闻的数量
    public int getSearchNewsCount(String message) throws SQLException;
}
