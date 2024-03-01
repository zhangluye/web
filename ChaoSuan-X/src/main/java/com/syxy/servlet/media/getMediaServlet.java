package com.syxy.servlet.media;

import com.syxy.pojo.Admic;
import com.syxy.pojo.Media;
import com.syxy.service.admic.AdmicService;
import com.syxy.service.admic.AdmicServiceImpl;
import com.syxy.service.media.MediaService;
import com.syxy.service.media.MediaServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class getMediaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int num = Integer.parseInt(id);
        Media media  = null;
        MediaService mediaService = new MediaServiceImpl();
        try {
            media = mediaService.getMediaById(num);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if ((media.getTitle()!=null)&&(media.getContext()!=null)){
            req.getSession().setAttribute("title",media.getTitle());
            req.getSession().setAttribute("context",media.getContext());
            req.getSession().setAttribute("pubTime",media.getPubTime());
            req.getRequestDispatcher("jsp/media/mediaPage.jsp").forward(req,resp);
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
