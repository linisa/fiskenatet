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
	<div class="col-sm-2">
        <input type="submit" value="Spela" class="btn btn-Lg btn-primary" />
    </div>
    <div>
	<br>
	</div>
	<div>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>${categories.categories_name}</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${categories}" var="menu">
				<tr>
					<td>
						<a href="<spring:url value="/menu/${categories.categories_id}.html" />">
						${categories.categories_name}
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</div>
<jsp:include page="page-footer.jsp"></jsp:include>
</body>
</html>