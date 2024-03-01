<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
    <title>Title</title>
</head>
<body>
    <div class="page-bar">
        <ul class="page-num-ul clearfix" style="list-style: none">
            <li style="display: flex;justify-content: flex-end; list-style: none; margin: 0px 30px 5px 0px;">共${param.totalCount}条&emsp;&nbsp;第${param.currentPageNo}/${param.totalPageCount}页</li>
            <c:if test="${param.currentPageNo < param.totalPageCount}">
                <a href="javascript:page_nav(document.forms[0],${param.totalPageCount});" style="float: right;margin: auto 5px;">尾页</a>
                <a href="javascript:page_nav(document.forms[0],${param.currentPageNo+1});" style="float: right;margin: auto 5px;">下一页</a>
            </c:if>
            <c:if test="${param.currentPageNo > 1}">
                <a href="javascript:page_nav(document.forms[0],${param.currentPageNo-1});" style="float: right;margin: auto 5px;">上一页</a>
                <a href="javascript:page_nav(document.forms[0],1);" style="float: right;margin: auto 5px;">首页</a>
            </c:if>

        </ul>
    </div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/Static/js/rollpage.js"></script>
</html>
