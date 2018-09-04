<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" 
						+ request.getServerPort() + path + "/";
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="<%=basePath %>admin/js/jquery-1.42.min.js"></script>
    <link href="<%=basePath %>admin/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="<%=basePath %>admin/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="<%=basePath %>admin/css/style.css" rel="stylesheet" type="text/css">
    <title>Title</title>
</head>
<body>
<div class="container">
    <form class="login-form" action="" method="post">
        <h2 class="text-center">登陆管理系统</h2>
        <div class="login-wrap">
            <!-- icon_lock_alt -->
            <p class="login-img"><i class="icon_lock_alt"></i></p>
            <div class="input-group">
                <span class="input-group-addon"><i class="ace-icon fa fa-user"></i></span>
                <input type="text" id="adminAccountName" name="adminAccountName" class="form-control" placeholder="用户名" autofocus required>
            </div>
            <div class="input-group" style="font-size:100px!important;">
                <span class="input-group-addon"><i class="ace-icon fa fa-lock"></i></span>
                <input type="password" id="adminPassword" name="adminPassword" class="form-control" placeholder="密码" autofocus required>
            </div>
        <!-- 验证码 -->
        <div class="code">
		验证码：<input type="text" value="" placeholder="请输入验证码（不区分大小写）" class="input-val" />
		<canvas id="canvas" width="100" height="43"></canvas>
		</div>
        <!-- 验证码 -->
            <label class="checkbox" style="margin-left: 20px">
                <input type="checkbox" value="remember-me">记住我
                <span class="pull-right"> <a href="#">忘记密码?</a></span>
            </label>
            <p class="error-message" name="error">${errMsg}</p>
            <button id="btn" class="btn btn-primary btn-lg btn-block" type="button">登陆</button>
        </div>
    </form>
</div>
</body> 
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
		var adminAccountName = $('#adminAccountName').val();
		var adminPassword = $('#adminPassword').val();
		if(val==''){
			alert('请输入验证码！');
		}else if(val == num){
			/*  */
			$.ajax({
				type:"post",
				url:"<%=basePath %>/admin/index.action",
				dataType:"json",
				data: {"adminAccountName":adminAccountName,"adminPassword":adminPassword},
				success: function(data){
						alert("登录成功");
						window.location.href="<%=basePath %>admin/products.action";
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
		var deg = Math.random() * 30 * Math.PI / 180;//产生0~30之间的随机弧度
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