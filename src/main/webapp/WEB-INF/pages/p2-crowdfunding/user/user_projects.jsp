<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<title>Insert title here</title>
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=basePath%>css/dashboard.css" />
</head>
<body>
<table class="table table-striped table-bordered">
								<thead>
									<tr>
										<th>序号</th>
										<th>项目类型</th>
										<th>项目名称</th>
										<th>项目进度</th>
										<th>开始日期</th>
										<th>结束日期</th>
										<th>已筹金额</th>
										<th>发起人</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${list}" var="list">
										<tr>
											<td>${list.psId }</td>
											<td>${list.pst.pstName }</td>
											<td>${list.psName }</td>
											<td><fmt:formatNumber type="number"
													value="${list.psGetmoney/list.psMoney }" pattern="#%0.00" />
											</td>
											<td><fmt:formatDate value="${list.psStarttime }"
													pattern="yyyy-MM-dd HH:mm:ss" /></td>
											<td><fmt:formatDate value="${list.psEndtime }"
													pattern="yyyy-MM-dd HH:mm:ss" /></td>
											<td>${list.psGetmoney }</td>
											<td>${list.us.usName}</td>
											<td>
											<a href="<%=basePath %>admin/productsDetail_1.action?psId=${list.psId }&psUsId=${list.psUsId }">详情
											</td>
										</tr>
									</c:forEach>


								</tbody>
								</table>

</body>
</html>