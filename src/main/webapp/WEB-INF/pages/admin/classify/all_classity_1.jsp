<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Title</title>
<link rel="stylesheet" href="<%=basePath%>admin/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=basePath%>admin/css/dashboard.css" />
<%-- <link rel="stylesheet" href="<%=basePath%>admin/css/dialog.css" /> --%>
</head>

<body>
	<div>
		<jsp:include page="../head.jsp" />
	</div>
	<!--左侧导航栏end-->
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1 class="page-header">众筹项目分类</h1>

		<div class="panel panel-default"></div>
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="panel-title">
					项目分类列表 <a class="btn btn-primary"
						href="<%=basePath%>admin/classify/add_classity.jsp">添加</a>
				</div>
			</div>
			<div class="panel-body">

				<div class="table-responsive ">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>序号</th>
								<th>分类名称</th>
								<th>分类描述</th>
								<th>添加时间</th>
								<th>分类状态</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="list">
								<tr>
									<td>${list.pstId}</td>
									<td>${list.pstName}</td>
									<td>${list.pstDesc}</td>
									<td><fmt:formatDate value="${list.pstStardate}"
											pattern="yyyy-MM-dd HH:mm:ss" /></td>
									<td><c:if test="${list.pstType eq 0}">可用</c:if> <c:if
											test="${list.pstType eq 1}">禁用</c:if></td>
									<td><a href="#" data-toggle="modal" data-target="#myModal"
										onclick="getTable(${list.pstId},'${list.pstName}','${list.pstDesc}','<fmt:formatDate value="${list.pstStardate}" pattern="yyyy-MM-dd HH:mm:ss"/>','${list.pstType}')">详情/修改</a>
										| <a href="#" onclick="getdel(${list.pstId})">删除</a>
										</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!--模态框-->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">分类详情</h4>
							</div>
							<div class="modal-body">
								<div class="form">
									<form class="form-validate form-horizontal" id="feedback_form"
										action="<%=basePath%>admin/projectstypeUpdate.action"
										method="post">
										<div class="form-group ">
											<label for="p_id" class="control-label col-lg-2">序号<span
												class="required"> *</span></label>
											<div class="col-lg-10">
												<input class="form-control" id="p_id" type="text" readonly
													name="pstId" />
											</div>
										</div>

										<div class="form-group ">
											<label for="p_name" class="control-label col-lg-2">分类名称<span
												class="required"> *</span></label>
											<div class="col-lg-10">
												<input class="form-control" id="p_name" type="text"
													name="pstName" />
											</div>
										</div>
										<div class="form-group ">
											<label for="p_des" class="control-label col-lg-2">分类描述<span
												class="required"> *</span></label>
											<div class="col-lg-10">
												<input class="form-control" id="p_des" type="text"
													name="pstDesc" />
											</div>
										</div>
										<div class="form-group ">
											<label for="p_time" class="control-label col-lg-2">添加时间<span
												class="required"> *</span></label>
											<div class="col-lg-10">
												<input class="form-control" id="p_time" type="text"
													name="pstStardate" />
											</div>
										</div>

										<div class="form-group ">
											<label for="p_status" class="control-label col-lg-2">分类状态<span
												class="required"> *</span></label>
											<div class="col-lg-10">
												<select class="form-control m-bot15" id="p_status"
													name="pstType">
													<option value="0">可用</option>
													<option value="1">禁用</option>
												</select>
											</div>
										</div>
										<div class="form-group" style="text-align: right;">
											<div class="col-lg-offset-2 col-lg-10">
												<button class="btn btn-primary" type="submit">保存</button>
												<button class="btn btn-default" type="reset">重置</button>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="text-left">共有 ${allCount }条记录，第 ${currentPage }/${allPages }页
				</div>
				<nav aria-label="Page navigation" class="text-right">
					<jsp:include page="../../../../../page.jsp" />
				</nav>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="<%=basePath%>admin/js/jquery1.12.4.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>admin/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>admin/js/countUp.js"></script>
	<script type="text/javascript" src="<%=basePath%>admin/js/dialog.js"></script>
	<script>
		function getTable(p_id, p_name, p_des, p_time, p_status) {
			document.getElementById("p_id").value = p_id;
			document.getElementById("p_name").value = p_name;
			document.getElementById("p_des").value = p_des;
			document.getElementById("p_time").value = p_time;
			document.getElementById("p_status").value = p_status;
		}
	 	function getdel(id) {
			javascript: $('body').dailog({
				type : 'danger',
				title : '错误.',
				discription : '您确定要删除ID为' + id + '的数据吗?'
			}, function(ret) {
				if (ret.index === 0) {
					window.location.href = "<%=basePath%>admin/projectstypeDel.action?pstId=" + id;
				}
				;
			})
		} 
	</script>

</body>
</html>