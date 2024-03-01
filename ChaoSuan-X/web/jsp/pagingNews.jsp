<%@ page import="com.syxy.pojo.News" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/news">
    <input type="hidden" name="pageIndex" value="1"/>
<%--    <input value="查询" type="submit" id="searchbutton">--%>
</form>

<h3>新闻总览: </h3>
<%
    ArrayList<News> newsList = (ArrayList<News>) request.getSession().getAttribute("newsList");
%>

<h4>新闻序号&emsp;新闻标题&emsp;发布时间</h4>
<c:forEach var="news" items="${newsList}">
    <hr>
    <a href="${pageContext.request.contextPath}/jsp/news/newsPage.jsp?id=${news.id}&title=${news.title}&context=${news.context}&pubTime=${news.pubTime}">
        <span><c:out value="${news.id}"/>&emsp;&nbsp;</span>
        <span><c:out value="${news.title}"/>&emsp;&emsp;</span>
        <span><c:out value="${news.pubTime}"/>&emsp;</span><br>
    </a>
</c:forEach>

<input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
<c:import url="rollpage.jsp">
    <c:param name="totalCount" value="${totalCount}"/>
    <c:param name="currentPageNo" value="${currentPageNo}"/>
    <c:param name="totalPageCount" value="${totalPageCount}"/>
</c:import>

</body>
</html>
