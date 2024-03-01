package com.syxy.servlet.admic;

import com.syxy.pojo.Admic;
import com.syxy.pojo.Alerts;
import com.syxy.service.admic.AdmicService;
import com.syxy.service.admic.AdmicServiceImpl;
import com.syxy.service.alerts.AlertsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class getAdmicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int num = Integer.parseInt(id);
        Admic admic = null;
        AdmicService admicService = new AdmicServiceImpl();
        try {
            admic = admicService.getAdmicById(num);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if ((admic.getTitle()!=null)&&(admic.getContext()!=null)){
            req.getSession().setAttribute("title",admic.getTitle());
            req.getSession().setAttribute("context",admic.getContext());
            req.getSession().setAttribute("pubTime",admic.getPubTime());
            req.getRequestDispatcher("jsp/admic/admicPage.jsp").forward(req,resp);
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
