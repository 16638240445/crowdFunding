<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>众筹管理后台</title>
<link rel="stylesheet" href="<%=basePath%>admin/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=basePath%>admin/css/dashboard.css" />
</head>
<body>
	<div>
		<jsp:include page="../head.jsp" />
	</div>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">${ps.psName}项目</h1>

				<ul class="nav nav-tabs">
					<li role="presentation" class="active"><a
						href="<%=basePath %>admin/productsDetail_1.action?psId=${ps.psId }&psUsId=${ps.psUsId }">基本信息</a></li>
					<li role="presentation"><a
						href="<%=basePath %>admin/productsDetail_2.action?psId=${ps.psId }&psUsId=${ps.psUsId }">项目信息</a></li>
					<li role="presentation"><a
						href="<%=basePath %>admin/productsDetail_3.action?psId=${ps.psId }&psUsId=${ps.psUsId }">项目评论</a></li>
					<li role="presentation"><a
						href="<%=basePath %>admin/productsDetail_4.action?psId=${ps.psId }">项目进度</a></li>
					<li role="presentation"><a
						href="<%=basePath %>admin/productsDetail_5.action?psId=${ps.psId }&psUsId=${ps.psUsId }">项目跟踪</a></li>
				</ul>

				<div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">申请人信息</h3>
						</div>
						<div class="panel-body">
							<p>以下内容仅做示例</p>
							<table class="table table-bordered">

								<tr>
									<th>申请人</th>
									<td>${user.usName}</td>
								</tr>
								<tr>
									<th>申请人身份证</th>
									<td>${user.usIdcard}</td>
								</tr>
								<tr>
									<th>申请人地址</th>
									<td>${user.usAddress}</td>
								</tr>
								<tr>
									<th>客服联系人</th>
									<td>${ps.psCustName}</td>
								</tr>
								<tr>
									<th>客服联系电话</th>
									<td>${ps.psCustPhone}</td>
								</tr>
								<tr>
									<th>其它</th>
									<td>这只是个示例</td>
								</tr>
							</table>
							<div class="buttons" align="center">
								<a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="<%=basePath%>admin/js/jquery1.12.4.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>admin/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>admin/js/countUp.js"></script>
	<script>
		$(document).ready(function() {

		});
	</script>
</body>
</html>
