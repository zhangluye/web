package com.syxy.dao.admic;

import com.syxy.dao.BaseDao;
import com.syxy.pojo.Admic;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdmicDaoImpl implements AdmicDao{
    @Override
    public List<Admic> getAllAdmics(Connection connection) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Admic> admicList = new ArrayList<>();

        if(connection != null){
            String sql = "select * from admic";
            //获取数据库查找结果集
            rs = BaseDao.execute(connection,sql,null,rs,pstm);
            admicList = setValues.SetAdmicsValue(rs, (ArrayList<Admic>) admicList);

        }else {
            System.out.println("数据库连接失败！");
        }
        BaseDao.closeResource(connection,pstm,rs);
        return admicList;
    }

    @Override
    public int getAdmicsCount(Connection connection) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int pageCount = 0;

        if (connection != null){
            String sql = "select count(1) as count from admic";
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
    public List<Admic> getAdmicsByPage(Connection connection, int currentPageNo, int pageSize) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Admic> admicList = new ArrayList<>();

        if (connection != null){
            String sql = "select * from admic limit ?,?";
            List<Object> list = new ArrayList<>();
            currentPageNo = (currentPageNo-1)*pageSize;
            list.add(currentPageNo);
            list.add(pageSize);
            Object[] param = list.toArray();

            rs = BaseDao.execute(connection, sql, param, rs, pstm);
            admicList = setValues.SetAdmicsValue(rs, (ArrayList<Admic>) admicList);
        }else {
            System.out.println("数据库连接失败!");
        }
        BaseDao.closeResource(connection,pstm,rs);
        return admicList;
    }

    @Override
    public Admic getAdmicById(Connection connection, int id) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Admic admic = new Admic();

        if (connection != null){
            String sql = "select * from admic where id=?";
            List<Object> list = new ArrayList<>();
            list.add(id);
            Object[] param = list.toArray();

            rs = BaseDao.execute(connection, sql, param, rs, pstm);
            admic = setValues.SetOneValue(rs,admic);
        }
        BaseDao.closeResource(connection,pstm,rs);
        return admic;
    }

    @Test
    public void test() throws SQLException {
        List<Admic> admicList = new ArrayList<>();
        admicList = getAllAdmics(BaseDao.getConnection());
        System.out.println(admicList);
    }
}
