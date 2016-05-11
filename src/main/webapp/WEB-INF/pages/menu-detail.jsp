<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Underkategories</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>

<body>
<jsp:include page="page-header.jsp"></jsp:include>

<h1>${menu.category_menu}</h1>

<c:forEach items="${menu.undercategory}" var="undercategory">

	<h1><c:out value="${menu.undercategory}" /></h1>
	<p>${menu.undercategory}</p>

	<table class="table table-hover">
		<thead>
			<tr>
				<th>Välj ämnen</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${undercategories}" var="undercategories.undercategories_name">
			<tr>
				<td>${undercategories.undercategories_name}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
</c:forEach>


<jsp:include page="page-footer.jsp"></jsp:include>
</body>
</html>