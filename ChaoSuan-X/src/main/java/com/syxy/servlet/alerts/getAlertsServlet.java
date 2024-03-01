package com.syxy.servlet.alerts;

import com.syxy.pojo.Alerts;
import com.syxy.service.alerts.AlertsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class getAlertsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int num = Integer.parseInt(id);
        Alerts alerts = null;
        AlertsServiceImpl alertsService = new AlertsServiceImpl();
        try {
            alerts = alertsService.getAlertsById(num);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if ((alerts.getTitle()!=null)&&(alerts.getContext()!=null)){
            req.getSession().setAttribute("title",alerts.getTitle());
            req.getSession().setAttribute("context",alerts.getContext());
            req.getSession().setAttribute("pubTime",alerts.getPubTime());
            req.getRequestDispatcher("jsp/alerts/alertsPage.jsp").forward(req,resp);
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
