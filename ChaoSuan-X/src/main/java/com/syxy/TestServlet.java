package com.syxy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//传值测试servlet
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        String name = req.getParameter("name");
        String password = req.getParameter("password");

        PrintWriter writer = resp.getWriter();
        writer.println("<html><title>servlet测试</title>");
        writer.println("<body><h3>这里是servlet获取前端参数测试！</h3></body></html>");
        writer.println("<p>获取表单的值：</p>");
        writer.println("参数名:");
        writer.println("<p>姓名: "+name+"</p>");
        writer.println("<p>密码: "+password+"</p>");

        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
