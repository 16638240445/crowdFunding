<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>无标题文档</title>
    <script type="text/javascript" src="<%=basePath %>js/jquery-1.42.min.js"></script>
<link href="<%=basePath %>css/base.css" rel="stylesheet" type="text/css">
<link href="<%=basePath %>css/reg.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="<%=basePath %>css/headbott.css" type="text/css"/>
</head>

<body>

<!-- 头部 -->
<jsp:include page="frontHead.jsp"></jsp:include>
<!-- 头部 -->


<div id="cop">
   <div class="cop-mian">
   <c:forEach items="${list }" var="list" varStatus="ih">
       <div class="cop_part${ih.count}"> 
         <h1 class="title">${list.questionname}</h1>
         <ul class="Newlist">
          <c:forEach items="${list.other }" var="lists" >
            <li><a href="#">${lists.questionothername }</a></li>
          </c:forEach>
            <!-- <li><a href="#">新型式下的中小企业融资策略</a></li>
            <li><a href="#">企业融资途径</a></li>
            <li><a href="#">中小企业融资方式</a></li>
            <li><a href="#">【干货】武媚娘如何完成五轮融资成就周氏企业帝国</a></li> -->
         </ul>
      </div>
     </c:forEach>
     <!--  <div class="cop_part2">
      <h1 class="title">众筹项目</h1>
         <ul class="Newlist">
            <li><a href="#">金融新政策</a></li>
            <li><a href="#">新型式下的中小企业融资策略</a></li>
            <li><a href="#">企业融资途径</a></li>
            <li><a href="#">中小企业融资方式</a></li>
            <li><a href="#">【干货】武媚娘如何完成五轮融资成就周氏企业帝国</a></li>
         </ul>
        </div>
      <div class="cop_part3">
        <h1 class="title">个人账户</h1>
         <ul class="Newlist">
            <li><a href="#">金融新政策</a></li>
            <li><a href="#">新型式下的中小企业融资策略</a></li>
            <li><a href="#">企业融资途径</a></li>
            <li><a href="#">中小企业融资方式</a></li>
            <li><a href="#">【干货】武媚娘如何完成五轮融资成就周氏企业帝国</a></li>
         </ul>
      </div>
      <div class="cop_part4">
        <h1 class="title">资金问题</h1>
         <ul class="Newlist">
            <li><a href="#">金融新政策</a></li>
            <li><a href="#">新型式下的中小企业融资策略</a></li>
            <li><a href="#">企业融资途径</a></li>
            <li><a href="#">中小企业融资方式</a></li>
            <li><a href="#">【干货】武媚娘如何完成五轮融资成就周氏企业帝国</a></li>
         </ul>
      </div> -->
   </div>
</div>
<div id="bottom">
    <div class="bot-con1">
        <ul>
            <li class="bot-con1-li1">我们已经做到 </li>
            <li>单项支持人数<span class="inde-span1"></span></li>
            <li>单项筹款金额<span class="inde-span2"></span></li>
            <li>累计筹款金额<span class="inde-span3"></span></li>
        </ul>
    </div>
    <div class="bot-con1 bot-con2">
        <ul>
            <li class="bot-con1-li1">发起项目流程 </li>
            <li><span class="inde-span4"></span>发起人创建项目</li>
            <li><span class="inde-span5"></span>项目获得支持</li>
            <li><span class="inde-span6"></span>发起人发放回报</li>
            <li><span class="inde-span7"></span>用户收到回报</li>
        </ul>
    </div>
    <div class="bottom-ggt"><a href=""><img src="images/bottbom_68.jpg" alt=""/></a></div>
    <div class="zc-yqlink">
        <ul>
            <li><a href="">阿里巴巴集团</a></li>
            <li><a href="">淘宝网</a></li>
            <li><a href="">天猫</a></li>
            <li><a href="">聚划算</a></li>
            <li><a href="">全球速卖通</a></li>
            <li><a href="">阿里巴巴国际交易市场</a></li>
            <li><a href="">1688</a></li>
            <li><a href="">阿里妈妈</a></li>
            <li><a href="">阿里旅行</a></li>
            <li><a href="">阿里云计算</a></li>
            <li><a href="">阿里巴巴集团</a></li>
            <li><a href="">淘宝网</a></li>
            <li><a href="">天猫</a></li>
            <li><a href="">聚划算</a></li>
            <li><a href="">全球速卖通</a></li>
            <li><a href="">阿里巴巴国际交易市场</a></li>
            <li><a href="">1688</a></li>
            <li><a href="">阿里妈妈</a></li>
            <li><a href="">阿里云计算</a></li>
        </ul>
    </div>
    <div class="footer-bd">

        <a href=" ">关于淘宝</a>
        <a href=" ">合作伙伴</a>
        <a href=" ">营销中心</a>
        <a href=" ">廉正举报</a>
        <a href=" ">联系客服</a>
        <a href=" ">开放平台</a>
        <a href=" ">诚征英才</a>
        <a href=" ">联系我们</a>
        <a href=" ">网站地图</a>
        <a href=" ">法律声明</a>　　　
        <em>© 2003-2015 Taobao.com 版权所有</em><br>

        <br>
        <span>网络文化经营许可证：<a href=" ">浙网文[2013]0268-027号</a></span>
        <b>|</b>
        <span data-spm-protocol="i">增值电信业务经营许可证：<a href="">浙B2-20080224-1</a></span>
        <b>|</b>
        <span>信息网络传播视听节目许可证：1109364号</span>
        <b>|</b>
        <span>举报电话:0571-81683755</span>
    </div>
</div>
</body>
</html>
