package com.syxy.dao.admic;

import com.syxy.pojo.Admic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface AdmicDao {
    public List<Admic> getAllAdmics(Connection connection) throws SQLException;

    public int getAdmicsCount(Connection connection) throws SQLException;

    public List<Admic> getAdmicsByPage(Connection connection,int currentPageNo,int pageSize) throws SQLException;

    public Admic getAdmicById(Connection connection,int id) throws SQLException;
}
