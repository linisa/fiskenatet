<%@ include file="taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>page header</title>
</head>
<body>
	<div class="jumbotron container-fluid">
		<div id="login">
			 <a href="#"><span class="glyphicon glyphicon-user"></span> Login</a>
		</div>
	</div>
	 <div class="container">
    <div class="nav-tabs">
        <ul class="nav nav-tabs nav-justified">
          <li><a href="${pageContext.request.contextPath}/quizPage.html">Geografi</a></li>
          <li><a href="#">Sport</a></li>
          <li><a href="#">Natur</a></li>
          <li><a href="#">Film</a></li>
          <li><a href="#">Musik</a></li>
          <li><a href="#">Litteratur</a></li>
          <li class="dropdown" id="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-cog"></span></a>
            <ul class="dropdown-menu">
              <li><a href="${pageContext.request.contextPath}/createCategory.html">Skapa</a></li>
              <li><a href="${pageContext.request.contextPath}/listOfQuestions.html">Ändra/Ta bort</a></li>
            </ul>
        </ul>
    </div>
    </div>
	<br>
	<br>
</body>
</html>