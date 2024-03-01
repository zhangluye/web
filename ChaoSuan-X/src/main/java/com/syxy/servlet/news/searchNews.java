package com.syxy.servlet.news;

import com.syxy.pojo.News;
import com.syxy.service.news.NewsService;
import com.syxy.service.news.NewsServiceImpl;
import com.syxy.utils.PageSupport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class searchNews extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Strating Search...");
        String startMessage=req.getParameter("message");
        String startMessageSession=(String) req.getSession().getAttribute("startMessage");
        String pageIndex = req.getParameter("pageIndex");
        if(startMessage==null) {//1.换页  2.全局搜索
            if (pageIndex != null) { //换页
                startMessage = startMessageSession;
            } else {//全局搜索
                req.getSession().setAttribute("startMessage", startMessage);
            }
        }else {
            req.getSession().setAttribute("startMessage", startMessage);
        }

        try {
            this.search(req, resp,startMessage);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //按关键字查询新闻
    public void search(HttpServletRequest req, HttpServletResponse resp,String startMessage) throws SQLException, IOException, ServletException {
        StringBuffer buf=new StringBuffer();
        String message=buf.append('%').append(startMessage).append('%').toString();
        System.out.println("search-method"+message);
        int pageSize = 8;
        int currentPageNo = 1;
        ArrayList<News> newsList = null;
        String pageIndex = req.getParameter("pageIndex");
        NewsService newsService = new NewsServiceImpl();
        if (pageIndex != null){
            currentPageNo = Integer.parseInt(pageIndex);
        }

        int totalCount;
        if(message.equals("%%")){
            totalCount=newsService.getNewsCount();
        } else {
            totalCount=newsService.getSearchNewsCount(message);  //获取查询到的新闻总条数
        }

        PageSupport pageSupport = new PageSupport();
        pageSupport.setCurrentPageNo(currentPageNo);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(totalCount);

        int totalPageCount = pageSupport.getTotalPageCount();
        if (currentPageNo <1 ){
            currentPageNo = 1;
        }else if (currentPageNo > totalPageCount){
            currentPageNo = totalPageCount;
        }

        newsList = (ArrayList<News>) newsService.queryNews(message,currentPageNo,pageSize);


        if (newsList != null){
            req.getSession().setAttribute("newsList",newsList);
            req.getSession().setAttribute("totalCount",totalCount);
            req.getSession().setAttribute("currentPageNo",currentPageNo);
            req.getSession().setAttribute("totalPageCount",totalPageCount);
            req.getRequestDispatcher("jsp/news/searchNews.jsp").forward(req,resp);
        }else{
            req.setAttribute("error","获取结果为null");
            req.getRequestDispatcher("jsp/error/newsError.jsp").forward(req,resp);
        }

    }
}
