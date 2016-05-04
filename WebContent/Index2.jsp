<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>Quiz</title>
	<link rel="icon" type="image/png" href="/quizrepo/WebContent/images/favicon.ico"/>
	<link rel="stylesheet" href="/quizrepo/WebContent/css/quizCss.css" type="text/css"/>
</head>
	<body>
		WELCOME!<br>
		<!--  Let´s do a for loop for 10 items -->
		<%
			for(int i = 1; i<=10; i++){
				out.print(i + "<br>");
			}
		%>
		<div id="navigation">
			<h1>Om Quiz och Admin</h1>
		</div>
		<div class="container">
		::before
			<div class="row">
			::before
			<div id="categories">
				<ul>
					<li><a href="">Sport</a></li>
					<li><a href="">Musik</a></li>
					<li><a href="">Film</a></li>
					<li><a href="">Litteratur</a></li>
					<li><a href="">Geografi</a></li>
					<li><a href="">Natur</a></li>
					::after
				</ul>
				::after
			</div>
			</div>
		</div>
	</body>
</html>