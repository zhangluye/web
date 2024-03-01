package com.syxy.service.admic;

import com.syxy.dao.BaseDao;
import com.syxy.dao.admic.AdmicDao;
import com.syxy.dao.admic.AdmicDaoImpl;
import com.syxy.pojo.Admic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdmicServiceImpl implements AdmicService{
    private AdmicDao admicDao;
    public AdmicServiceImpl(){
        admicDao = new AdmicDaoImpl();
    }

    @Override
    public List<Admic> getAllAdmics() throws SQLException {
        Connection connection = null;
        connection = BaseDao.getConnection();
        ArrayList<Admic> admicsList = null;

        admicsList = (ArrayList<Admic>) admicDao.getAllAdmics(connection);
        BaseDao.closeResource(connection,null,null);

        return admicsList;
    }

    @Override
    public int getAdmicsCount() throws SQLException {
        Connection connection = null;
        connection = BaseDao.getConnection();
        int pageCount = 0;

        pageCount = admicDao.getAdmicsCount(connection);
        BaseDao.closeResource(connection,null,null);
        return pageCount;
    }

    @Override
    public List<Admic> getAdmicsByPage(int currentPageNo, int pageSize) throws SQLException {
        Connection connection = null;
        connection = BaseDao.getConnection();
        ArrayList<Admic> admicsList = null;

        admicsList = (ArrayList<Admic>) admicDao.getAdmicsByPage(connection,currentPageNo,pageSize);
        BaseDao.closeResource(connection,null,null);
        return admicsList;
    }

    @Override
    public Admic getAdmicById(int id) throws SQLException {
        Connection connection = null;
        connection = BaseDao.getConnection();
        Admic admic = null;

        admic = admicDao.getAdmicById(connection,id);
        BaseDao.closeResource(connection,null,null);
        return admic;
    }
}
