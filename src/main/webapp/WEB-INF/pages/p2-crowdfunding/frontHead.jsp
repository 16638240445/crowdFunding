<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--上部导航栏开始-->
<div id="header">
    <div class="heade-con">
        <div class="logo"><a href="<%=basePath %>user/index.action"><img src="<%=basePath %>images/LOGO.png"/></a></div>
        <div class="nav posa">
            <ul>
                <li><a href="<%=basePath %>user/index.action">首页</a></li>
                <li><a href="<%=basePath %>crowdfunding/gyzcList.action">公益众筹</a></li>
                <li><a href="<%=basePath %>question/questionall.action">常见问题</a></li>
                <li><a href="<%=basePath %>information/lyList.action">众筹资讯</a></li>
                <li><a href="<%=basePath %>publish/front/publishProjects.action" style="">发布项目</a></li>
                <li><a href="<%=basePath %>user/personalCenter.action" style="">个人中心</a></li>
            </ul>
        </div>
        <div class="search">
            <form action="">
                <input type="text" class="search-txt" value="" placeholder="找项目">
                <input type="submit" class="search-but" value="">
            </form>
        </div>
        <div class="index-login">

            <a href="<%=basePath %>user/login.action">登录</a>
            <span style="color: white;">|</span>
            <a href="<%=basePath %>user/reg.action">注册</a>
        </div>
    </div>
</div>
<!--上不导航栏结束-->

</body>
</html>