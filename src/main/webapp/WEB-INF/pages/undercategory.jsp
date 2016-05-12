<%@ include file="taglib.jsp" %>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/default.css">

<title>Underkategories</title>

</head>

<body>
<jsp:include page="page-header.jsp"></jsp:include>

	<div>
	</div>
    
	<div class="" style="padding: 50px;">
    <div>
        <!-- all ny content skapas här -->
        <h3>Välj underkategori på din Quiz:</h3>
  	    <div class="list-group">
        <c:set var="totalundercategories" value="${fn:length(undercategories)}" />
		  
		  
		  <a href="${pageContext.request.contextPath}/quizPage.html" class="list-group-item active">
		  <c:forEach var="undercategories" items='${undercategories}' varStatus="undercategoriesCounter">
			  <c:if test="${undercategoriesCounter.count == 1}">
			  <c:out value="${undercategories.undercategories_name}"></c:out>			  
			  </c:if>
		  </c:forEach>
		   </a>
		  
		  <c:forEach var="undercategories" items='${undercategories}' varStatus="undercategoriesCounter">
			  <c:if test="${undercategoriesCounter.count > 1}">
			  <c:if test="${undercategories.categories_id == 1}">
			  <a href="${pageContext.request.contextPath}/${undercategories.undercategories_name}.html" class="list-group-item">
			  <c:out value="${undercategories.undercategories_name}">
			  </c:out>	
			  </a>		
			  </c:if>  
			  </c:if>
		  </c:forEach>
		</div>       
    </div>
	<div class="col-sm-2" align="center" >
        <input type="submit" value="Spela" class="btn btn-Lg btn-primary" />
    </div>
    <div>
	<br>
	</div>
	<div>
	<br>
	</div>
</div>
<jsp:include page="page-footer.jsp"></jsp:include>
</body>
</html>