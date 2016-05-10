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
	<div>
	<br>
	</div>
    <div class="undercategory">
        <!-- all ny content skapas här -->
        <h3>Välj ämnen!</h3>
        <div class="list-group">
		  <a href="#" class="list-group-item active">Aqui
		    <c:forEach 
		    var="undercategories"
		    items="${undercategories}">
		    ${undercategories.undercategory_menu_name}
  			</c:forEach>
		  </a>
		  <a href="#" class="list-group-item">
		  
  			</a>
		  <a href="#" class="list-group-item">
			<c:forEach 
		    items="${undercategories}"  
		    var="undercategories">
		    ${undercategories.undercategories_name}
  			</c:forEach>
			</a>
		  <a href="#" class="list-group-item">Amerika</a>
		  <a href="#" class="list-group-item">Afrika</a>
		  <a href="#" class="list-group-item">Asien</a>
		  <a href="#" class="list-group-item">Oceanien</a>
		  <a href="#" class="list-group-item">Världen</a>
		</div>       
    </div>
	<div class="col-sm-2">
        <input type="submit" value="Spela" class="btn btn-Lg btn-primary" />
    </div>
    <div>
	<br>
	</div>
	<div>
	<br>
	</div>

<jsp:include page="page-footer.jsp"></jsp:include>
</body>
</html>