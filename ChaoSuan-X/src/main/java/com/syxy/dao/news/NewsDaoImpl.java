package com.syxy.dao.news;

import com.syxy.dao.BaseDao;
import com.syxy.pojo.News;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDaoImpl implements NewsDao{

    @Override
    public List<News> getAllNews(Connection connection) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<News> newsList = new ArrayList<>();

        if(connection != null){
            String sql = "select * from news";
            //获取数据库查找结果集
            rs = BaseDao.execute(connection,sql,null,rs,pstm);
            newsList = setValues.SetNewsValue(rs, (ArrayList<News>) newsList);

        }else {
            System.out.println("数据库连接失败！");
        }
        BaseDao.closeResource(connection,pstm,rs);
        return newsList;
    }

    @Override
    public int getNewsCount(Connection connection) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int pageCount = 0;

        if (connection != null){
            String sql = "select count(1) as count from news";
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
    public List<News> getNewsByPage(Connection connection, int currentPageNo, int pageSize) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<News> newsList = new ArrayList<>();

        if (connection != null){
            String sql = "select * from news limit ?,?";
            List<Object> list = new ArrayList<>();
            currentPageNo = (currentPageNo-1)*pageSize;
            list.add(currentPageNo);
            list.add(pageSize);
            Object[] param = list.toArray();

            rs = BaseDao.execute(connection, sql, param, rs, pstm);
            newsList = setValues.SetNewsValue(rs, (ArrayList<News>) newsList);
        }else {
            System.out.println("数据库连接失败!");
        }
        BaseDao.closeResource(connection,pstm,rs);
        return newsList;
    }

    @Override
    public News getNewsById(Connection connection, int id) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        News news = new News();

        if (connection != null){
            String sql = "select * from news where id=?";
            List<Object> list = new ArrayList<>();
            list.add(id);
            Object[] param = list.toArray();

            rs = BaseDao.execute(connection, sql, param, rs, pstm);
            news = setValues.SetOneValue(rs,news);

        }
        BaseDao.closeResource(connection,pstm,rs);
        return news;
    }

    @Override
    public List<News> queryNews(Connection connection, int currentPageNo, int pageSize, String message) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<News> newsList = new ArrayList<>();

        if (connection != null){
            String sql;
            List<Object> list = new ArrayList<>();
            currentPageNo = (currentPageNo-1)*pageSize;
            if(message.equals("%%")){
                sql = "select * from news limit ?,?";
            }else {
                sql ="select * from news where title like ? or content like ? limit ?,?";   //根据标题和文章内容关键字搜索
                list.add(message);
                list.add(message);
                /*
                *只根据标题搜索：
                * sql ="select * from news where title like ? or content like ? limit ?,?";
                 list.add(message);
                 list.add(message);
                *
                * */
            }
            list.add(currentPageNo);
            list.add(pageSize);
            Object[] param = list.toArray();

            rs = BaseDao.execute(connection, sql, param, rs, pstm);
            newsList = setValues.SetNewsValue(rs, (ArrayList<News>) newsList);
        }else {
            System.out.println("数据库连接失败!");
        }
        BaseDao.closeResource(connection,pstm,rs);
        return newsList;
    }

    @Override
    public int getSearchNewsCount(Connection connection, String message) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int pageCount = 0;

        if (connection != null){
            String sql = "select count(1) as count from news where title like ? or content like ?";
            List<Object> list = new ArrayList<>();
            list.add(message);
            list.add(message);
            Object[] param = list.toArray();
            rs = BaseDao.execute(connection,sql,param,rs,pstm);
            if (rs.next()){
                pageCount = rs.getInt("count");
            }
        }else {
            System.out.println("数据库连接失败!");
        }
        BaseDao.closeResource(connection,pstm,rs);
        return pageCount;
    }

    @Test
    public void test1() throws SQLException {
        List<News> list = new ArrayList<>();
        list = getAllNews(BaseDao.getConnection());
        for (News news : list) {
            System.out.println(news);
        }
    }

    @Test
    public void test2() throws SQLException {
        int pageCount = 0;
        pageCount = getNewsCount(BaseDao.getConnection());
        System.out.println("pageCount = "+pageCount);
    }

    @Test
    public void test3() throws SQLException {
        List<News> newsList = new ArrayList<>();
        newsList = getNewsByPage(BaseDao.getConnection(),1,5);
        for (News news : newsList) {
            System.out.println(news);
        }
    }

    @Test
    public void test4() throws SQLException {
        News news = new News();
        news = getNewsById(BaseDao.getConnection(),1);
        System.out.println(news);
    }
}
