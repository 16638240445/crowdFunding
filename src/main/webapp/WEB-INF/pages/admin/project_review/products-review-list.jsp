<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
				<h1 class="page-header">项目审核</h1>

				<div class="panel panel-default">
					<div class="panel-body">
						<form class="form-inline" action="<%=basePath %>admin/projectsReviewTerm.action" method="post">
							<div class="form-group">
								<input type="text" class="form-control" id="exampleInputName2" name="psName"
									placeholder="项目名称">
							</div>
							<div class="form-group">
								<input type="text" class="form-control" id="exampleInputName2" name="usName"
									placeholder="项目发起人">
							</div>
							<div class="form-group">
								<select class=form-control name="pstName">
									<option value="">项目类型</option>
									<option>教育助学</option>
									<option>爱心环保</option>
									<option>扶贫助困</option>
									<option>公益创业</option>
									<option>公益活动</option>
								</select>
							</div>
							&nbsp;&nbsp;
							<button type="submit" class="btn btn-default btn-primary">查询</button>
						</form>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="panel-title">所有项目列表</div>
					</div>
					<div class="panel-body">
						<div class="table-responsive ">
							<table class="table table-striped table-bordered">
								<thead>
									<tr>
										<th>序号</th>
										<th>项目类型</th>
										<th>项目名称</th>
										<th>筹资金额</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${list}" var="list">
										<tr>
											<td>${list.psId }</td>
											<td><c:if test="${ list.psPstId eq 1 }">教育助学</c:if> <c:if
													test="${ list.psPstId eq 2 }">爱心环保</c:if> <c:if
													test="${ list.psPstId eq 3 }">扶贫助困</c:if> <c:if
													test="${ list.psPstId eq 4 }">公益创业</c:if> <c:if
													test="${ list.psPstId eq 5 }">公益活动</c:if></td>
											<%-- <td>${list.psPstId }</td> --%>
											<td>${list.psName }</td>
											<td>${list.psMoney }</td>
											<td>
											<a href="<%=basePath %>admin/productReviewDetail.action?psId=${list.psId }&psUsId=${list.psUsId }">详情
											&nbsp&nbsp<a href="<%=basePath %>admin/productReviewDetail_1.action?psId=${list.psId }">审核</a>
											</td>
										</tr>
									</c:forEach>


								</tbody>
							</table>
						</div>
						<!-- =================================================== -->
						<div  class="text-left">共有 ${allCount }条记录，第 ${currentPage }/${allPages }页 </div>
						<nav aria-label="Page navigation" class="text-right">
							<jsp:include page="../../../../page1.jsp"/>
						</nav>
						<!-- =================================================== -->
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="<%=basePath %>admin/js/jquery1.12.4.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>admin/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>admin/js/countUp.js"></script>
	<script>
		$(document).ready(function() {

		});
	</script>
</body>
</html>
