package com.syxy.pojo;

import java.util.Date;

//快讯实体类
public class Alerts {
    private int id;
    private String title;
    private String context;
    private Date pubTime;

    public Alerts(){}
    public Alerts(int id, String title, String context, Date pubTime) {
        this.id = id;
        this.title = title;
        this.context = context;
        this.pubTime = pubTime;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContext() {
        return context;
    }
    public void setContext(String context) {
        this.context = context;
    }
    public Date getPubTime() {
        return pubTime;
    }
    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }
    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", context='" + context + '\'' +
                ", pubTime=" + pubTime +
                '}';
    }
}
