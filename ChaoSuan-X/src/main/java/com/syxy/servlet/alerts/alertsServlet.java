package com.syxy.servlet.alerts;

import com.syxy.pojo.Alerts;
import com.syxy.service.alerts.AlertsService;
import com.syxy.service.alerts.AlertsServiceImpl;
import com.syxy.utils.PageSupport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class alertsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.getAlertsByPage(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    //获取分页快讯内容
    public void getAlertsByPage(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        int pageSize = 8;
        int currentPageNo = 1;
        ArrayList<Alerts> alertsList = null;
        String pageIndex = req.getParameter("pageIndex");
        AlertsService alertsService = new AlertsServiceImpl();
        if (pageIndex != null){
            currentPageNo = Integer.parseInt(pageIndex);
        }
        int totalCount = alertsService.getAlertsCount();

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

        alertsList = (ArrayList<Alerts>) alertsService.getAlertsByPage(currentPageNo,pageSize);
        if (alertsList != null){
            req.getSession().setAttribute("alertsList",alertsList);
            req.getSession().setAttribute("totalCount",totalCount);
            req.getSession().setAttribute("currentPageNo",currentPageNo);
            req.getSession().setAttribute("totalPageCount",totalPageCount);
            req.getRequestDispatcher("jsp/alerts/alertsMain.jsp").forward(req,resp);
        }else{
            req.setAttribute("error","获取结果为null");
            req.getRequestDispatcher("jsp/error/newsError.jsp").forward(req,resp);
        }

    }
}
