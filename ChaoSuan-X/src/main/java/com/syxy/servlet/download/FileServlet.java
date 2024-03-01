package com.syxy.servlet.download;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

//文件下载类
public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("content-type","text/html;charset=utf-8");
        String fileName = req.getParameter("fileName");
        System.out.println(fileName);

        String dlType = fileName.substring(fileName.lastIndexOf(".")+1);
        System.out.println(dlType);

        String type = switch (dlType) {
            case "jpg", "jpeg" -> "image/jpeg";
            case "png" -> "image/png";
            case "pdf" -> "application/pdf";
            case "doc" -> "application/msword";
            case "txt" -> "text/plain";
            default -> "text/html";
        };

        resp.setContentType(type);
        resp.setHeader("Content-disposition","attachment;filename="+ URLEncoder.encode(fileName, StandardCharsets.UTF_8));

        String realPath = this.getServletContext().getRealPath("WEB-INF/DLfile/" + fileName);

        InputStream inputStream = new FileInputStream(realPath);
        int len = 0;
        byte[] buffer = new byte[1024];
        ServletOutputStream outputStream = resp.getOutputStream();
        while ((len=inputStream.read(buffer))>0) {
            outputStream.write(buffer, 0, len);
        }
        inputStream.close();
        outputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
