package com.syxy.servlet.media;

import com.syxy.pojo.Admic;
import com.syxy.pojo.Media;
import com.syxy.service.admic.AdmicServiceImpl;
import com.syxy.service.media.MediaService;
import com.syxy.service.media.MediaServiceImpl;
import com.syxy.utils.PageSupport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class mediaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.getMediasByPage(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    //获取分页媒体报道
    public void getMediasByPage(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        int pageSize = 8;
        int currentPageNo = 1;
        ArrayList<Media> mediaList = null;
        String pageIndex = req.getParameter("pageIndex");
        MediaService mediaService = new MediaServiceImpl();
        if (pageIndex != null){
            currentPageNo = Integer.parseInt(pageIndex);
        }
        int totalCount = mediaService.getMediasCount();

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

        mediaList = (ArrayList<Media>) mediaService.getMediasByPage(currentPageNo,pageSize);
        if (mediaList != null){
            req.getSession().setAttribute("mediaList",mediaList);
            req.getSession().setAttribute("totalCount",totalCount);
            req.getSession().setAttribute("currentPageNo",currentPageNo);
            req.getSession().setAttribute("totalPageCount",totalPageCount);
            req.getRequestDispatcher("jsp/media/mediaMain.jsp").forward(req,resp);
        }else{
            req.setAttribute("error","获取结果为null");
            req.getRequestDispatcher("jsp/error/newsError.jsp").forward(req,resp);
        }

    }
}
