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

public class newsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("newsServlet--Strating");
        try {
            this.getNewsByPage(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


    //获取所有新闻
    public void getAllNews(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("getAllNews-method");
        ArrayList<News> newsList = null;
        NewsService newsService = new NewsServiceImpl();
        try {
            newsList = (ArrayList<News>) newsService.getAllNews();
            System.out.println(newsList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if (newsList != null){
            req.getSession().setAttribute("newsList",newsList);
            resp.sendRedirect("jsp/newsTest.jsp");
        }
        else {
            req.setAttribute("error","获取列表结果为null");
            req.getRequestDispatcher("jsp/error/newsError.jsp").forward(req,resp);
        }
    }

    //获取分页新闻
    public void getNewsByPage(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        System.out.println("getNewsByPage-method");
        int pageSize = 8;
        int currentPageNo = 1;
        ArrayList<News> newsList = null;
        String pageIndex = req.getParameter("pageIndex");
        NewsService newsService = new NewsServiceImpl();
        if (pageIndex != null){
            currentPageNo = Integer.parseInt(pageIndex);
        }
        int totalCount = newsService.getNewsCount();

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

        newsList = (ArrayList<News>) newsService.getNewsByPage(currentPageNo,pageSize);
        if (newsList != null){
            req.getSession().setAttribute("newsList",newsList);
            req.getSession().setAttribute("totalCount",totalCount);
            req.getSession().setAttribute("currentPageNo",currentPageNo);
            req.getSession().setAttribute("totalPageCount",totalPageCount);
            req.getRequestDispatcher("jsp/news/dongtai.jsp").forward(req,resp);
        }else{
            req.setAttribute("error","获取结果为null");
            req.getRequestDispatcher("jsp/error/newsError.jsp").forward(req,resp);
        }

    }
}
