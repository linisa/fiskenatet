<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Frågesport</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="jumotron">
		<div align="middle">
			<img src="bild.jpg" alt="bild" /> <a href="#"><span
				class="glyphicon glyphicon-user"></span> Login</a>
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
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href=""><span
						class="glyphicon glyphicon-cog"></span>
						<ul class="dropdown-menu">
							<li><a
								href="${pageContext.request.contextPath}/createQuestion.html">Skapa</a></li>
							<li><a href="#">Ändra</a></li>
							<li><a href="#">Ta bort</a></li>
						</ul></li>
			</ul>
		</div>
		<div class="">
			<!-- all ny content skapas här -->
			<h1>INDEX SIDAN</h1>
		</div>
	</div>

</body>
</html>