package com.syxy.servlet.news;

import com.syxy.pojo.News;
import com.syxy.service.news.NewsService;
import com.syxy.service.news.NewsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class getNewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int num = Integer.parseInt(id);
        News news = null;
        NewsService newsService = new NewsServiceImpl();
        try {
            news = newsService.getNewsById(num);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if ((news.getTitle()!=null)&&(news.getContext()!=null)){
            req.getSession().setAttribute("title",news.getTitle());
            req.getSession().setAttribute("context",news.getContext());
            req.getSession().setAttribute("pubTime",news.getPubTime());
            req.getRequestDispatcher("jsp/news/newsPage.jsp").forward(req,resp);
        }else {
            req.setAttribute("error","获取内容为null，或请求内容不存在");
            req.getRequestDispatcher("jsp/error/newsError.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
