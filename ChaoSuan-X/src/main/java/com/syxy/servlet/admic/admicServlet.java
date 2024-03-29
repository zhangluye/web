package com.syxy.servlet.admic;

import com.syxy.pojo.Admic;
import com.syxy.service.admic.AdmicService;
import com.syxy.service.admic.AdmicServiceImpl;
import com.syxy.utils.PageSupport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class admicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.getAdmicsByPage(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    //获取分页学术动态
    public void getAdmicsByPage(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        int pageSize = 8;
        int currentPageNo = 1;
        ArrayList<Admic> admicsList = null;
        String pageIndex = req.getParameter("pageIndex");
        AdmicService admicService = new AdmicServiceImpl();
        if (pageIndex != null){
            currentPageNo = Integer.parseInt(pageIndex);
        }
        int totalCount = admicService.getAdmicsCount();

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

        admicsList = (ArrayList<Admic>) admicService.getAdmicsByPage(currentPageNo,pageSize);
        if (admicsList != null){
            req.getSession().setAttribute("admicsList",admicsList);
            req.getSession().setAttribute("totalCount",totalCount);
            req.getSession().setAttribute("currentPageNo",currentPageNo);
            req.getSession().setAttribute("totalPageCount",totalPageCount);
            req.getRequestDispatcher("jsp/admic/admicMain.jsp").forward(req,resp);
        }else{
            req.setAttribute("error","获取结果为null");
            req.getRequestDispatcher("jsp/error/newsError.jsp").forward(req,resp);
        }

    }
}
