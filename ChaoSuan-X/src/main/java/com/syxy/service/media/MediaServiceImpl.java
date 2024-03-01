package com.syxy.service.media;

import com.syxy.dao.BaseDao;
import com.syxy.dao.media.MediaDao;
import com.syxy.dao.media.MediaDaoImpl;
import com.syxy.pojo.Media;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MediaServiceImpl implements MediaService{
    private MediaDao mediaDao;
    public MediaServiceImpl(){
        mediaDao = new MediaDaoImpl();
    }

    @Override
    public List<Media> getAllMedias() throws SQLException {
        Connection connection = null;
        connection = BaseDao.getConnection();
        ArrayList<Media> MediaList = null;

        MediaList = (ArrayList<Media>) mediaDao.getAllMedias(connection);
        BaseDao.closeResource(connection,null,null);

        return MediaList;
    }

    @Override
    public int getMediasCount() throws SQLException {
        Connection connection = null;
        connection = BaseDao.getConnection();
        int pageCount = 0;

        pageCount = mediaDao.getMediasCount(connection);
        BaseDao.closeResource(connection,null,null);
        return pageCount;
    }

    @Override
    public List<Media> getMediasByPage(int currentPageNo, int pageSize) throws SQLException {
        Connection connection = null;
        connection = BaseDao.getConnection();
        ArrayList<Media> mediaList = null;

        mediaList = (ArrayList<Media>) mediaDao.getMediasByPage(connection,currentPageNo,pageSize);
        BaseDao.closeResource(connection,null,null);
        return mediaList;
    }

    @Override
    public Media getMediaById(int id) throws SQLException {
        Connection connection = null;
        connection = BaseDao.getConnection();
        Media media = null;

        media = mediaDao.getMediaById(connection,id);
        BaseDao.closeResource(connection,null,null);
        return media;
    }
}
