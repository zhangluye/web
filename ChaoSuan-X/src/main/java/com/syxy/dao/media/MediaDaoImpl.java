package com.syxy.dao.media;

import com.syxy.dao.BaseDao;
import com.syxy.pojo.Media;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MediaDaoImpl implements MediaDao{
    @Override
    public List<Media> getAllMedias(Connection connection) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Media> mediaList = new ArrayList<>();

        if(connection != null){
            String sql = "select * from media";
            //获取数据库查找结果集
            rs = BaseDao.execute(connection,sql,null,rs,pstm);
            mediaList = setValues.SetMediasValue(rs, (ArrayList<Media>) mediaList);

        }else {
            System.out.println("数据库连接失败！");
        }
        BaseDao.closeResource(connection,pstm,rs);
        return mediaList;
    }

    @Override
    public int getMediasCount(Connection connection) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int pageCount = 0;

        if (connection != null){
            String sql = "select count(1) as count from media";
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
    public List<Media> getMediasByPage(Connection connection, int currentPageNo, int pageSize) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Media> mediaList = new ArrayList<>();

        if (connection != null){
            String sql = "select * from media limit ?,?";
            List<Object> list = new ArrayList<>();
            currentPageNo = (currentPageNo-1)*pageSize;
            list.add(currentPageNo);
            list.add(pageSize);
            Object[] param = list.toArray();

            rs = BaseDao.execute(connection, sql, param, rs, pstm);
            mediaList = setValues.SetMediasValue(rs, (ArrayList<Media>) mediaList);
        }else {
            System.out.println("数据库连接失败!");
        }
        BaseDao.closeResource(connection,pstm,rs);
        return mediaList;
    }

    @Override
    public Media getMediaById(Connection connection, int id) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Media media = new Media();

        if (connection != null){
            String sql = "select * from media where id=?";
            List<Object> list = new ArrayList<>();
            list.add(id);
            Object[] param = list.toArray();

            rs = BaseDao.execute(connection, sql, param, rs, pstm);
            media = setValues.SetOneValue(rs,media);
        }
        BaseDao.closeResource(connection,pstm,rs);
        return media;
    }

    @Test
    public void test01() throws SQLException {
        List<Media> mediaList = new ArrayList<>();
        mediaList = getAllMedias(BaseDao.getConnection());
        System.out.println(mediaList);
    }
}
