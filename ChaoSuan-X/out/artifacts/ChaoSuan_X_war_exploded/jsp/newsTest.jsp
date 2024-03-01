<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.syxy.pojo.News" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新闻动态</title>
</head>
<body>
<h3>新闻总览: </h3>
<%
    ArrayList<News> newsList = (ArrayList<News>) request.getSession().getAttribute("newsList");
%>

<h4>新闻序号&emsp;新闻标题&emsp;发布时间</h4>
<c:forEach var="news" items="${newsList}">
    <a href="${pageContext.request.contextPath}/jsp/news/newsPage.jsp?id=${news.id}&title=${news.title}&context=${news.context}&pubTime=${news.pubTime}">
        <span><c:out value="${news.id}"/>&emsp;&nbsp;</span>
        <span><c:out value="${news.title}"/>&emsp;&emsp;</span>
        <span><c:out value="${news.pubTime}"/>&emsp;</span><br>
    </a>
</c:forEach>

</body>
</html>
