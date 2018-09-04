<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul class="pagination">
				<li class="paginate_button previous disabled }">
				
				<c:if test="${currentPage > 1}">
					<a href="${forward }?currentPage=${currentPage - 1}&psName=${psName }&psType=${psType }&pstName=${pstName }&usName=${usName }">上一页</a>
				</c:if>
				<c:if test="${currentPage <= 1}">
					<a href="#">上一页</a>
				</c:if>
				</li>
				
				<c:forEach begin="1" end="${allPages}" step="1" var="pageNum">
				<c:if test="${currentPage eq pageNum}">
					<li class="paginate_button active"><a href="${forward }?currentPage=${pageNum}&psName=${psName }&psType=${psType }&pstName=${pstName }&usName=${usName }">${pageNum}</a></li>
				</c:if>
				
				<c:if test="${currentPage ne pageNum}">
					<li class="paginate_button"><a href="${forward }?currentPage=${pageNum}&psName=${psName }&psType=${psType }&pstName=${pstName }&usName=${usName }">${pageNum}</a></li>
				</c:if>
				</c:forEach>
				
				<li class="paginate_button next disabled">
				
				<c:if test="${currentPage < allPages}">
					<a href="${forward }?currentPage=${currentPage + 1}&psName=${psName }&psType=${psType }&pstName=${pstName }&usName=${usName }">下一页</a>
				</c:if>
				
				<c:if test="${currentPage >= allPages}">
					<a href="#">下一页</a>
				</c:if>
				
				</li>
			</ul>