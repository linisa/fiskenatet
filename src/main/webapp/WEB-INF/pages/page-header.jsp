<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="taglib.jsp" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>page header</title>
</head>
<body>
<div class="jumotron">
    	<div align="center">
        <img src="/images/quiz_logo.jpg" alt="Quiz Logo" width="60%"/>
        <a href="#"><span class="glyphicon glyphicon-user"></span> Login</a>
    	</div>
    </div>
	
	<div class="container">
    <div class="nav-tabs">
        <ul class="nav nav-tabs nav-justified">
          <li id="1"><a href="#">Geografi</a></li>
          <li id="2"><a href="#">Sport</a></li>
          <li id="3"><a href="#">Natur</a></li>
          <li id="4"><a href="#">Film</a></li>
          <li id="5"><a href="#">Musik</a></li>
          <li id="6"><a href="#">Litteratur</a></li>
          <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href=""><span class="glyphicon glyphicon-cog"></span></a>
            <ul class="dropdown-menu">
              <li><a href="#">Skapa</a></li>
              <li><a href="#">Ändra</a></li>
              <li><a href="#">Ta bort</a></li>
            </ul>
          </li>
        </ul>
    </div>
</body>
</html>