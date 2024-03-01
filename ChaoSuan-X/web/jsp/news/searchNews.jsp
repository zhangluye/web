<%@ page import="com.syxy.pojo.News" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>新闻公告-三亚学院超算中心</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Static/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Static/css/gonggao/gonggao.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/Static/js/common.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/Static/js/common2.js"></script>


</head>
<body>
<!--form[0]，第一个表单，设置用于提交分页请求-->
<form action="${pageContext.request.contextPath}/search">
    <input type="hidden" name="pageIndex" value="1"/>
</form>

<section class="return">
    <a href="javascript:" id="btn" title="回到顶部"></a>
</section>
<nav>
    <div class="navTo widthBox">
        <div class="logo">
            <a href="${pageContext.request.contextPath}/Static/html/index.html"><img src="${pageContext.request.contextPath}/Static/images/logo.png" alt="LOGO"></a>
            <a href="${pageContext.request.contextPath}/Static/html/index.html"><h1>超算中心</h1></a>
        </div>
        <form action="${pageContext.request.contextPath}/search" method="post">
            <div  id="search">
                <input type="text" name="message">
            </div>
            <input value="查询" type="submit" id="searchbutton">
        </form>
    </div>
    <div class="namber">
        <ul class="widthBox">
            <li>
                <h2><a href="${pageContext.request.contextPath}/Static/html/index.html">首页</a></h2>
            </li>
            <li>
                <h2><a href="${pageContext.request.contextPath}/Static/html/center/generalization.html">中心介绍</a></h2>
                <dl>
                    <dd>
                        <a href="${pageContext.request.contextPath}/Static/html/center/generalization.html">中心概括</a>
                    </dd>
                    <dd>
                        <a href="${pageContext.request.contextPath}/Static/html/center/message.html">主任寄语</a>
                    </dd>
                    <dd>
                        <a href="${pageContext.request.contextPath}/Static/html/center/managementTeam.html">管理团队</a>
                    </dd>
                    <dd>
                        <a href="${pageContext.request.contextPath}/Static/html/center/developmentHistory.html">发展历程</a>
                    </dd>
                    <dd>
                        <a href="${pageContext.request.contextPath}/Static/html/center/honor.html">荣誉资质</a>
                    </dd>
                    <dd>
                        <a href="${pageContext.request.contextPath}/Static/html/center/elegantDemeanor.html">中心风采</a>
                    </dd>
                </dl>
            </li>
            <li>
                <h2><a href="${pageContext.request.contextPath}/Static/html/scientificwork/post-doctoral.html">科研工作</a></h2>
                <dl>
                    <dd>
                        <a href="${pageContext.request.contextPath}/Static/html/scientificwork/post-doctoral.html">博士后工作站</a>
                    </dd>
                    <dd>
                        <a href="${pageContext.request.contextPath}/Static/html/scientificwork/union.html">联合实验室</a>
                    </dd>
                    <dd>
                        <a href="${pageContext.request.contextPath}/Static/html/scientificwork/bigData.html">高性能大数据处理</a>
                    </dd>
                </dl>
            </li>
            <li>
                <h2><a href="${pageContext.request.contextPath}/Static/html/team.html">人才队伍</a></h2>
            </li>
            <li>
                <h2><a href="${pageContext.request.contextPath}/Static/html/resources/highPerformance.html">超算资源</a></h2>
                <dl>
                    <dd>
                        <a href="${pageContext.request.contextPath}/Static/html/resources/highPerformance.html">高性能计算平台</a>
                    </dd>
                    <dd>
                        <a href="${pageContext.request.contextPath}/Static/html/resources/cloud.html">云计算平台</a>
                    </dd>
                    <dd>
                        <a href="${pageContext.request.contextPath}/Static/html/resources/download.html">资料下载</a>
                    </dd>
                </dl>
            </li>
            <li>
                <h2><a href="${pageContext.request.contextPath}/alerts">新闻动态</a></h2>
                <dl>
                    <dd>
                        <a href="${pageContext.request.contextPath}/alerts">超算快讯</a>
                    </dd>
                    <dd>
                        <a href="${pageContext.request.contextPath}/admic">学术动态</a>
                    </dd>
                    <dd>
                        <a href="${pageContext.request.contextPath}/media">媒体报道</a>
                    </dd>
                </dl>
            </li>
            <li>
                <h2><a href="/news">公告公示</a></h2>
            </li>
            <li>
                <h2><a href="${pageContext.request.contextPath}/Static/html/connect/consulting.html">联系我们</a></h2>
                <dl>
                    <dd>
                        <a href="${pageContext.request.contextPath}/Static/html/connect/consulting.html">业务咨询</a>
                    </dd>
                    <dd>
                        <a href="${pageContext.request.contextPath}/Static/html/connect/visit.html">参观访问</a>
                    </dd>
                </dl>
            </li>
        </ul>
    </div>
</nav>
<section class="zhongjian">

        <% ArrayList<News> newsList = (ArrayList<News>) request.getSession().getAttribute("newsList"); %>

        <div id="tj">
            <div id="tj_top">推荐栏</div>
            <div id="tj_bottom">
                <ul id="tj_ul" >
                    <c:forEach var="news" items="${newsList}" begin="0" end="8">
                        <li style="margin: 12px auto"><a href="${pageContext.request.contextPath}/news.one?id=${news.id}">
                            <span style="color: white"><c:out value="${news.title}"/>&emsp;&emsp;</span>
                        </a></li>
                    </c:forEach>

                    <c:if test="${newsList == '[]'}">
                        <li style="text-align: center">暂无内容</li>
                    </c:if>
                </ul>
            </div>
        </div>
    </div>

    <div id="neirong">
<%--        <div id="nr_daohang">--%>
<%--            <p><a href="../../Static/html/index.html">首页</a> >> <a href="#">搜索结果</a> </p>--%>
<%--        </div>--%>

            <div id="zw_biaoti">
                <h1 style="font-size: 28px;">搜索结果</h1>
            </div>

            <c:if test="${newsList == '[]'}">
                <h3 style="color: white; text-align: center">暂无搜索内容</h3>
            </c:if>

            <c:forEach var="news" items="${newsList}">
                    <p style="margin: 8.5px auto;"><a href="${pageContext.request.contextPath}/news.one?id=${news.id}">
                    <span><c:out value="${news.title}"/>&emsp;&emsp;</span>
                    <span><c:out value="${news.pubTime}"/>&emsp;</span><br>
                    </a></p>
                <hr class="liebiao_fenge"/>
            </c:forEach>
            <hr class="liebiao_fenge"/>

            <input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
            <c:import url="../rollpage.jsp">
                <c:param name="totalCount" value="${totalCount}"/>
                <c:param name="currentPageNo" value="${currentPageNo}"/>
                <c:param name="totalPageCount" value="${totalPageCount}"/>
            </c:import>
        </div>
    </div>
</section>
<footer>
    <div class="fromT">
        <div class="widthBox clearfix1">
            <div  class="fromTLeft">
                <h2>联系我们</h2>
                <ul>
                    <li><p>业务咨询：nscc@hnu.edu.cn</p></li>
                    <li><p>参观访问：nscccs@hnu.edu.cn</p></li>
                </ul>
                <ul>
                    <li><p>联系电话：0731-88664162</p></li>
                    <li><p>邮编：410082</p></li>
                    <li><p>传真：0731-88664162</p></li>
                    <li><p>地址：海南省三亚市吉阳区迎宾大道学院路三亚学院191号</p></li>
                </ul>
            </div>
            <img src="${pageContext.request.contextPath}/Static/images/weixing.jpg">
        </div>
    </div>
    <div class="fromB">
        <p>三亚学院超算中心版权所有© 2018</p>
    </div>
</footer>
</body>
</html>
