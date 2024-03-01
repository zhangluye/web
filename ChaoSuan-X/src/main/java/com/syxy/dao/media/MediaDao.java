package com.syxy.dao.media;

import com.syxy.pojo.Media;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface MediaDao {
    public List<Media> getAllMedias(Connection connection) throws SQLException;

    public int getMediasCount(Connection connection) throws SQLException;

    public List<Media> getMediasByPage(Connection connection,int currentPageNo,int pageSize) throws SQLException;

    public Media getMediaById(Connection connection,int id) throws SQLException;
}
