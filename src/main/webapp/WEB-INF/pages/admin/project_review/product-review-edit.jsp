<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

				<%-- <ul class="nav nav-tabs">
					<li role="presentation" class="active"><a href="<%=basePath %>admin/productsDetail_1.action?psId=${ps.psId }&psUsId=${ps.psUsId }">基本信息</a></li>
					<li role="presentation"><a href="<%=basePath %>admin/productsDetail_2.action?psId=${ps.psId }&psUsId=${ps.psUsId }">项目信息</a></li>
					<li role="presentation"><a href="<%=basePath %>admin/productsDetail_3.action?psId=${ps.psId }&psUsId=${ps.psUsId }">项目评论</a></li>
					<li role="presentation"><a href="<%=basePath %>admin/productsDetail_4.action?psId=${ps.psId }">项目进度</a></li>
					<li role="presentation"><a href="<%=basePath %>admin/productsDetail_5.action?psId=${ps.psId }&psUsId=${ps.psUsId }">项目跟踪</a></li>
				</ul> --%>

				<div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">${ps.psName}项目信息</h3>
						</div>
						<div class="panel-body">
							<p>以下内容仅做示例</p>
							<form action="<%=basePath %>admin/productReviewEdit.action?psId=${ps.psId}" method="post">
								<table class="table table-bordered">
									<tr>
										<th>项目编号</th>
										<td>${ps.psId}</td>
									</tr>
									<tr>
										<th>项目状态</th>
										<td>
										<select name="psType">
												<option value="0">待审核</option>
												<option value="1">待上架</option>
												<option value="2">众筹中</option>
												<option value="3">审核未通过</option>
										</select>
										</td>
									<tr>
										<th>项目开始时间</th>
										<td><input type="text" name="psStarttime" placeholder="请选择日期" id="test1" /></td>
									</tr>
									<tr>
										<th>项目结束时间</th>
										<td><input type="text" name="psEndtime" placeholder="请选择日期"  id="test2"/></td>
									</tr>
									<tr>
										<th>审核人编号</th>
										<td><input type="text" name="psAuditor"  /></td>
									</tr>
									<tr>
										<th>其它</th>
										<td>这只是个示例</td>
									</tr>
								</table>
								<div class="col-lg-offset-2 col-lg-10">
									<button class="btn btn-primary" type="submit">保存</button>
									<button class="btn btn-default" type="reset">重置</button>
								</div>
							</form>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="<%=basePath%>admin/js/jquery1.12.4.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>admin/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>admin/js/countUp.js"></script>
	<script type="text/javascript" src="<%=basePath%>admin/js/laydate/laydate.js"></script> <!-- 改成你的路径 -->
<script  type="text/javascript">
//时间选择器
laydate.render({
  elem: '#test1'
  ,type: 'datetime'
});
//时间选择器
laydate.render({
	  elem: '#test2'
	  ,type: 'datetime'
	});
</script>

</body>

</html>
