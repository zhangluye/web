package com.syxy.service.media;

import com.syxy.pojo.Media;
import java.sql.SQLException;
import java.util.List;

public interface MediaService {
    public List<Media> getAllMedias() throws SQLException;

    public int getMediasCount() throws SQLException;

    public List<Media> getMediasByPage(int currentPageNo, int pageSize) throws SQLException;

    public Media getMediaById(int id) throws SQLException;
}
