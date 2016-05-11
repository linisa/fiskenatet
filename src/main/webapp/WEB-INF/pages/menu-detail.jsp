<%@ include file="taglib.jsp" %>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/default.css">

<title>Undercategories</title>

</head>

<body>
<jsp:include page="page-header.jsp"></jsp:include>
<div class="pageclass">
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
</div>

<jsp:include page="page-footer.jsp"></jsp:include>
</body>
</html>