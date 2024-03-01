package com.syxy.dao.media;


import com.syxy.pojo.Media;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class setValues {
    //创建静态方法，将从数据库获取的结果集赋值给对象属性
     static List<Media> SetMediasValue(ResultSet rs, ArrayList<Media> mediaList) throws SQLException {

        while (rs.next()) {
            Media media = new Media();
            media.setId(rs.getInt("id"));
            media.setTitle(rs.getString("title"));
            media.setContext(rs.getString("content"));
            media.setPubTime(rs.getDate("pubtime"));
            mediaList.add(media);
        }
        return mediaList;
    }


    static Media SetOneValue(ResultSet rs, Media media) throws SQLException {
        if (rs.next()) {
            media.setId(rs.getInt("id"));
            media.setTitle(rs.getString("title"));
            media.setContext(rs.getString("content"));
            media.setPubTime(rs.getDate("pubtime"));
        }
        return media;
    }
}
