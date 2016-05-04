<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp" %>   

<h1>${menu.category_menu}</h1>

<c:forEach items="${menu.undercategory} var="undercategory">

	<h1>${menu.undercategory}</h1>
	<p>${menu.undercategory}</p>

	<table class="table table-hover">
		<thead>
			<tr>
				<th>Materia</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${menu.undercategory_menu}" var items="item">
			<tr>
				<td>${item.undercategory}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
</c:forEach>
