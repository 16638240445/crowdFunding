<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" +request.getServerName()+":" +request.getServerPort()
			+path +"/";
%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>无标题文档</title>
<script type="text/javascript" src="<%=basePath %>js/jquery-1.42.min.js"></script>
<link href="<%=basePath %>css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="<%=basePath %>css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="<%=basePath %>css/base.css" rel="stylesheet" type="text/css">
<link href="<%=basePath %>css/reg.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="<%=basePath %>css/headbott.css" type="text/css" />
<link rel="stylesheet" href="<%=basePath %>css/ace.min.css" type="text/css" />
</head>

<body>
	<!-- 头部 -->
<jsp:include page="frontHead.jsp"></jsp:include>
<!-- 头部 -->
	<div class="login-container">

		<div class="space-6"></div>

		<div class="position-relative">
			<div id="signup-box" class="signup-box widget-box no-border">
				<div class="widget-body">
					<div class="widget-main">
						<h4 class="header green lighter bigger">
							<i class="ace-icon fa fa-users blue"></i> 用户注册
						</h4>

						<div class="space-6"></div>
						<p>填写信息:</p>

						<form action="<%= basePath%>user/regist.action" method="post">
							<fieldset>
								<label class="block clearfix"> <span
									class="block input-icon input-icon-left"> <input
										type="text" class="form-control" placeholder="邮箱或手机号码"  name="usEmail"/> <i
										class="ace-icon fa fa-envelope"></i>
								</span>
								</label> <label class="block clearfix"> <span
									class="block input-icon input-icon-left"> <input
										type="text" class="form-control" placeholder="用户名" name="usName" /> <i
										class="ace-icon fa fa-user"></i>
								</span>
								</label> 
								<label class="block clearfix"> <span
									class="block input-icon input-icon-left"> <input
										type="password" class="form-control" placeholder="密码" name="usPassword" /> <i
										class="ace-icon fa fa-lock"></i>
								</span>
								</label> 
								<!-- <label class="block clearfix"> <span
									class="block input-icon input-icon-left"> <input
										type="password" class="form-control" placeholder="确认密码" /> <i
										class="ace-icon fa fa-retweet"></i>
								</span>
								</label> -->
								<!--验证码-->
								<!-- <label class="block clearfix"> <span> <input
										type="text" class="" placeholder="验证码" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<button class="btn btn-default">
											<a>点击获取验证码</a>
										</button>
								</span>
								</label>  -->
								<label class="block"> <input type="checkbox"
									class="ace" /> <span class="lbl"> 接受 <a href="#">用户协议</a>
								</span>
								</label>

								<div class="space-24"></div>
								 <p class="error-message" name="error">${errMsg}</p>
								<div class="clearfix">
									<button type="reset" class="width-30 pull-left btn btn-sm">
										<i class="ace-icon fa fa-refresh"></i> <span
											class="bigger-110">重置</span>
									</button>

									<button type="submit"
										class="width-65 pull-right btn btn-sm btn-success">
										<span class="bigger-110">注册</span> <i
											class="ace-icon fa fa-arrow-right icon-on-right"></i>
									</button>
								</div>
							</fieldset>
						</form>
						<!--第三方-->
						<div class="social-or-login center">
							<span class="bigger-110">第三方登录</span>
						</div>

						<div class="space-6"></div>

						<div class="social-login center">
							<a href="#"> <img src="<%=basePath %>images/weixin.png">
							</a> <a href="#"> <img src="<%=basePath %>images/qq.png">
							</a> <a href="#"> <img src="<%=basePath %>images/sina.png">
							</a>
						</div>
					</div>

					<div class="toolbar center">
						<a href="<%=basePath %>user/login.action" data-target="#login-box"
							class="back-to-login-link"> <i
							class="ace-icon fa fa-arrow-left"></i> 返回登录
						</a>
					</div>
				</div>
				<!-- /.widget-body -->
			</div>
		</div>
	</div>
	</div>
	<div id="bottom">
		<div class="bottom-ggt">
			<a href=""><img src="images/bottbom_68.jpg" alt="" /></a>
		</div>
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

			<a href=" ">关于淘宝</a> <a href=" ">合作伙伴</a> <a href=" ">营销中心</a> <a
				href=" ">廉正举报</a> <a href=" ">联系客服</a> <a href=" ">开放平台</a> <a
				href=" ">诚征英才</a> <a href=" ">联系我们</a> <a href=" ">网站地图</a> <a
				href=" ">法律声明</a> <em>© 2003-2015 Taobao.com 版权所有</em><br> <br>
			<span>网络文化经营许可证：<a href=" ">浙网文[2013]0268-027号</a></span> <b>|</b> <span
				data-spm-protocol="i">增值电信业务经营许可证：<a href="">浙B2-20080224-1</a></span>
			<b>|</b> <span>信息网络传播视听节目许可证：1109364号</span> <b>|</b> <span>举报电话:0571-81683755</span>
		</div>
	</div>
</body>
</html>
