package com.syxy.service.admic;

import com.syxy.pojo.Admic;
import java.sql.SQLException;
import java.util.List;

public interface AdmicService {
    public List<Admic> getAllAdmics() throws SQLException;

    public int getAdmicsCount() throws SQLException;

    public List<Admic> getAdmicsByPage(int currentPageNo, int pageSize) throws SQLException;

    public Admic getAdmicById(int id) throws SQLException;
}
