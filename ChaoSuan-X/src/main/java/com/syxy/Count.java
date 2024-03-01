package com.syxy;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Count extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter out=resp.getWriter();
        ServletContext context = req.getSession().getServletContext();
        Object o = context.getAttribute("access");

        if (o != null && o instanceof Integer) {
            o = ((Integer) o) + 1;
            out.print("网站共"+o+"次访问");
            context.setAttribute("access", o);
        } else {
            context.setAttribute("access", 1);
            out.print("网站共1次访问");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
