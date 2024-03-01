package com.syxy.service.news;

import com.syxy.dao.BaseDao;
import com.syxy.dao.news.NewsDao;
import com.syxy.dao.news.NewsDaoImpl;
import com.syxy.pojo.News;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsServiceImpl implements NewsService{
    private NewsDao newsDao;
    public NewsServiceImpl(){
        newsDao = new NewsDaoImpl();
    }

    @Override
    public List<News> getAllNews() throws SQLException {
        Connection connection = null;
        connection = BaseDao.getConnection();
        ArrayList<News> newsList = null;

        newsList = (ArrayList<News>) newsDao.getAllNews(connection);
        BaseDao.closeResource(connection,null,null);

        return newsList;
    }

    @Override
    public int getNewsCount() throws SQLException {
        Connection connection = null;
        connection = BaseDao.getConnection();
        int pageCount = 0;

        pageCount = newsDao.getNewsCount(connection);
        BaseDao.closeResource(connection,null,null);
        return pageCount;
    }

    @Override
    public List<News> getNewsByPage(int currentPageNo, int pageSize) throws SQLException {
        Connection connection = null;
        connection = BaseDao.getConnection();
        ArrayList<News> newsList = null;

        newsList = (ArrayList<News>) newsDao.getNewsByPage(connection,currentPageNo,pageSize);
        BaseDao.closeResource(connection,null,null);
        return newsList;
    }

    @Override
    public News getNewsById(int id) throws SQLException {
        Connection connection = null;
        connection = BaseDao.getConnection();
        News news = null;

        news = newsDao.getNewsById(connection,id);
        BaseDao.closeResource(connection,null,null);
        return news;
    }

    @Override
    public List<News> queryNews(String message,int currentPageNo, int pageSize) throws SQLException {
        Connection connection = null;
        connection = BaseDao.getConnection();
        ArrayList<News> newsList = null;

        newsList = (ArrayList<News>) newsDao.queryNews(connection,currentPageNo,pageSize,message);
        BaseDao.closeResource(connection,null,null);
        return newsList;
    }

    @Override
    public int getSearchNewsCount(String message) throws SQLException {
        Connection connection = null;
        connection = BaseDao.getConnection();
        int pageCount = 0;

        pageCount = newsDao.getSearchNewsCount(connection,message);
        BaseDao.closeResource(connection,null,null);
        return pageCount;
    }

    //测试类
    @Test
    public void test1() throws SQLException {
        List<News> newsList = new ArrayList<>();
        newsList = getAllNews();
        for (News news : newsList) {
            System.out.println(news);
        }
    }

    @Test
    public void test2() throws SQLException {
        int pageCount = 0;
        pageCount = getNewsCount();
        System.out.println("新闻数: "+pageCount);
    }

    @Test
    public void test3() throws SQLException {
        List<News> newsList = new ArrayList<>();
        newsList = getNewsByPage(1,5);
        for (News news : newsList) {
            System.out.println(news);
        }
    }

    @Test
    public void test4() throws SQLException {
        News news = new News();
        news = getNewsById(1);
        System.out.println(news);
    }
}
