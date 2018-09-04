<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="<%=basePath%>js/jquery-1.42.min.js"></script>
<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>css/base.css" rel="stylesheet" type="text/css">
<link href="<%=basePath%>css/index2.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>css/reg.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="<%=basePath%>css/headbott.css"
	type="text/css" />
<link rel="stylesheet" href="<%=basePath%>css/ace.min.css"
	type="text/css" />
</head>
<script>
	window.onload = function() {
		var obtn = document.getElementById('btn'); //登录按钮
		var obox = document.getElementById('box');
		var obg = document.getElementById('bg');
		obtn.onclick = function() {

			obox.style.display = "block";
			obg.style.display = "block";
			// 用这个效果在IE6显示不全，因为body。html。document高度不全，那么就要，html，body{ width：100%； height100%；最只要是height；
			//不满足要求上网找特特效}
		}
	}
</script>
<body>
<!-- 头部 -->
<jsp:include page="frontHead.jsp"></jsp:include>
<!-- 头部 -->
	<script>
		var d_var = $(".search .search-txt").val();
		$(".search .search-txt").focus(function() {
			if ($(this).val() == d_var) {
				$(this).val("");
			}
		});

		$(".search .search-txt").blur(function() {
			if ($(this).val() == "") {
				$(this).val("找项目");
			}
		});
	</script>
	<div class="login-container">

		<div class="space-6"></div>

		<div class="position-relative">
			<div id="login-box" class="login-box visible widget-box no-border">
				<div class="widget-body">
					<div class="widget-main">
						<h4 class="header blue lighter bigger">
							<i class="ace-icon fa fa-coffee green"></i> 用户登陆
						</h4>

						<div class="space-6"></div>

						<form action="<%=basePath%>user/userAdmin.action" method="post">
							<fieldset>
								<label class="block clearfix"> <span
									class="block input-icon input-icon-left"> <i
										class="ace-icon fa fa-user"></i> <input type="text"
										class="form-control" id="username" name="username" placeholder="邮箱或手机号码" />

								</span>
								</label> <label class="block clearfix"> <span
									class="block input-icon input-icon-left"> <i
										class="ace-icon fa fa-lock"></i> <input type="password"
										name="password" id="password" class="form-control" placeholder="请输入密码" />

								</span>
								</label>
								  <!-- 验证码 -->
        							<div class="code">
									验证码：<input type="text" value="" placeholder="请输入验证码（不区分大小写）" class="input-val" />
									<canvas id="canvas" width="100" height="43"></canvas>
									</div>
        							<!-- 验证码 -->

								<div class="space"></div>

								<div class="clearfix">
									<label class="inline"> <input type="checkbox"
										class="ace" /> <span class="lbl"> 记住</span>
									</label>

									<button type="button" id="btn"
										class="width-35 pull-right btn btn-sm btn-primary">
										<i class="ace-icon fa fa-key"></i> <span class="bigger-110">登录</span>
									</button>
								</div>

								<div class="space-4"></div>
							</fieldset>
						</form>

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
					<!-- /.widget-main -->
					<div class="toolbar clearfix">
						<div>
							<a href="#" data-target="#forgot-box"
								class="forgot-password-link"> <i
								class="ace-icon fa fa-arrow-left"></i> 忘记密码
							</a>
						</div>

						<div>
							<a href="reg.html" data-target="#signup-box"
								class="user-signup-link"> 注册 <i
								class="ace-icon fa fa-arrow-right"></i>
							</a>
						</div>
					</div>
				</div>
				<!-- /.widget-body -->
			</div>
			<!-- /.login-box -->

			<!-- /.position-relative -->
		</div>
	</div>
	<!-- /.col -->
	<div id="bottom">
		<div class="bottom-ggt">
			<a href=""><img src="<%=basePath %>images/bottbom_68.jpg" alt="" /></a>
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
<script type="text/javascript" src="<%=basePath %>js/jquery.min.js"></script>
<style type="text/css">
	*{
		margin:0;
		padding: 0;
		box-sizing: border-box;
	}
	html{
		width: 100%;
		height: 100%;
		font-size: 16px;
	}
	body{
		width: 100%;
		height: 100%;
		-moz-user-select: none; /*火狐*/ /*禁止用户在页面选择文字*/
		-webkit-user-select: none; /*webkit浏览器*/
		-ms-user-select: none; /*IE10*/
		-khtml-user-select: none; /*早期浏览器*/
		user-select: none;
	}
	.code{
		width: 400px;
		margin:0 auto;
	}
	.input-val{
		width: 150px;
		background: #ffffff;
		height: 2.8rem;
		padding: 0 2%;
		border-radius: 5px;
		border: none;
		border: 1px solid rgba(0,0,0,.2);
		font-size: 5px;
	}
	#canvas{
		/* float:right; */
		display: inline-block;
		border:1px solid #fff;
		background: white;
		border-radius: 5px;
		cursor: pointer;
	}
</style>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">

$(function(){
	var show_num = [];
	draw(show_num);

	$("#canvas").on('click',function(){
		draw(show_num);
	})
	
	$(".btn").on('click',function(){
		var val = $(".input-val").val().toLowerCase();
		var num = show_num.join("");
		var username=$('#username').val();
		var password=$('#password').val();
		if(val==''){
			alert('请输入验证码！');
		}else if(val == num){
			/*  */
			$.ajax({
				type:"post",
				url:"<%=basePath %>user/userAdmin.action",
				dataType:"json",
				data: {"username":username,"password":password},
				success: function(data){
						alert("登录成功");
						window.location.href="<%=basePath %>user/index.action";
				},
				error:function(){
					alert("账号密码错误！");
				}
			});
			/* alert('提交成功！'); */
			$(".input-val").val('');
			draw(show_num);
			/*  */
		}else{
			alert('验证码错误！请重新输入！');
			$(".input-val").val('');
			draw(show_num);
		}
	})
})

function draw(show_num) {
	var canvas_width=$('#canvas').width();
	var canvas_height=$('#canvas').height();
	var canvas = document.getElementById("canvas");//获取到canvas的对象，演员
	var context = canvas.getContext("2d");//获取到canvas画图的环境，演员表演的舞台
	canvas.width = canvas_width;
	canvas.height = canvas_height;
	var sCode = "A,B,C,E,F,G,H,J,K,L,M,N,P,Q,R,S,T,W,X,Y,Z,1,2,3,4,5,6,7,8,9,0";
	var aCode = sCode.split(",");
	var aLength = aCode.length;//获取到数组的长度
	
	for (var i = 0; i <= 3; i++) {
		var j = Math.floor(Math.random() * aLength);//获取到随机的索引值
		var deg = Math.random() * 30 * Math.PI / 180;	 //产生0~30之间的随机弧度
		var txt = aCode[j];//得到随机的一个内容
		show_num[i] = txt.toLowerCase();
		var x = 10 + i * 20;//文字在canvas上的x坐标
		var y = 20 + Math.random() * 8;//文字在canvas上的y坐标
		context.font = "bold 23px 微软雅黑";

		context.translate(x, y);
		context.rotate(deg);

		context.fillStyle = randomColor();
		context.fillText(txt, 0, 0);

		context.rotate(-deg);
		context.translate(-x, -y);
	}
	for (var i = 0; i <= 5; i++) { //验证码上显示线条
		context.strokeStyle = randomColor();
		context.beginPath();
		context.moveTo(Math.random() * canvas_width, Math.random() * canvas_height);
		context.lineTo(Math.random() * canvas_width, Math.random() * canvas_height);
		context.stroke();
	}
	for (var i = 0; i <= 30; i++) { //验证码上显示小点
		context.strokeStyle = randomColor();
		context.beginPath();
		var x = Math.random() * canvas_width;
		var y = Math.random() * canvas_height;
		context.moveTo(x, y);
		context.lineTo(x + 1, y + 1);
		context.stroke();
	}
}

function randomColor() {//得到随机的颜色值
	var r = Math.floor(Math.random() * 256);
	var g = Math.floor(Math.random() * 256);
	var b = Math.floor(Math.random() * 256);
	return "rgb(" + r + "," + g + "," + b + ")";
}
</script>
</html>
