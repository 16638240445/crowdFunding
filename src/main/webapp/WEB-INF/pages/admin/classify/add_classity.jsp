<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>添加项目分类</title>
<link rel="stylesheet" href="<%=basePath%>admin/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=basePath%>admin/css/dashboard.css" />
</head>
<body>
	<div>
		<jsp:include page="../head.jsp" />
	</div>
	<!--左侧导航栏end-->
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1 class="page-header">添加项目分类</h1>

		<div class="panel panel-default"></div>
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="panel-title">添加项目</div>
			</div>
			<div class="panel-body">

				<div class="table-responsive ">
					<form action="<%=basePath%>admin/projectstypeAdd.action"
						method="post">
						<div class="form-group">
							<input type="text" class="form-control" id="type_name"
								name="pstName" placeholder="分类名称">
						</div>

						<div class="form-group">
							<textarea class="form-control" rows="3" name="pstDesc"
								placeholder="分类描述"></textarea>
						</div>
						<div class="pull-right">
						<button type="submit" class="btn btn-default btn-primary ">添加</button>
						&nbsp;&nbsp;
						<button  type="button" class="btn btn-default btn-primary " onclick="javascript:history.go(-1)">返回</button>
						</div>
					</form>
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