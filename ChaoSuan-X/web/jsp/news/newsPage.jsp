<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>新闻动态-三亚学院超算中心</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Static/css/common.css">
    <script src="${pageContext.request.contextPath}/Static/js/common.js"></script>
</head>
<body>

<section class="return">
    <a href="javascript:" id="btn" title="回到顶部"></a>
</section>
<nav>
    <div class="navTo widthBox">
        <div class="logo">
            <a href="${pageContext.request.contextPath}/Static/html/index.html"><img src="${pageContext.request.contextPath}/Static/images/logo.png" alt="LOGO"></a>
            <a href="${pageContext.request.contextPath}/Static/html/index.html"><h1>超算中心</h1></a>
        </div>

        <form action="/search" method="post">
            <div id="search">
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
    <div id="zj">
        <div id="zj_z">
            <div id="zj_z_top">新闻公告</div>
            <div id="zj_z_bottom">
                <ul id="zj_ul" >
                    <li><a href="${pageContext.request.contextPath}/news" id="xuanzhong">新闻动态</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div id="neirong">
        <div id="nr_daohang">
            <p><a href="${pageContext.request.contextPath}/Static/html/index.html">首页</a> >> <a href="/news">新闻动态</a> >> <a href="#"><%=request.getSession().getAttribute("title")%></a></p>
        </div>
        <div id="zhengwen">
            <div id="zw_biaoti">
                <h1 style="font-size: 28px;"><%=request.getSession().getAttribute("title")%></h1>
                <div id="shuju">
                    <p style="float: right;margin: 15px 80px auto auto">发表日期:<span id="riqi"><%=request.getSession().getAttribute("pubTime")%></span></p>
                </div>
            </div>
            <div id="wenzi">
                <p class="suojin" style="line-height: 35px;font-size: 18px;">
                    <%=request.getSession().getAttribute("context")%>
                </p>
            </div>
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