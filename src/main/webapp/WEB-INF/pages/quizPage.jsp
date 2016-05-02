<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Frågesport</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>



</head>
<body>
  <div class="jumbotron">
    <div align="middle">
        <img src="bild.jpg" alt="bild"/>
        <a href="#"><span class="glyphicon glyphicon-user"></span> Login</a>
    </div>
  </div>
  <div class="container">
    <div class="nav-tabs">
        <ul class="nav nav-tabs nav-justified">
          <li><a href="#">Geografi</a></li>
          <li><a href="#">Sport</a></li>
          <li><a href="#">Natur</a></li>
          <li><a href="#">Film</a></li>
          <li><a href="#">Musik</a></li>
          <li><a href="#">Litteratur</a></li>
          <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href=""><span class="glyphicon glyphicon-cog"></span>
            <ul class="dropdown-menu">
              <li><a href="#">Skapa</a></li>
              <li><a href="#">Ändra</a></li>
              <li><a href="#">Ta bort</a></li>
            </ul>
          </li>
        </ul>
    </div>
    <div class="">
        <form:form method="POST" >

            <c:forEach items="${questions}" var="questionModel">
              <div>
              <h3>Fråga :</h3>
              <!--  <c:set var="randomAnswerArray"> ${  list.toArray(questionModel.getShuffledAnswers())} </c:set> -->
                <h3><c:out value="${questionModel.question}"></c:out></h3>
                <form:radiobutton path="${questionModel.userAnswer}" value="randomAnswerArray[0]" label="randomAnswerArray[0]" />
                <form:radiobutton path="${questionModel.userAnswer}" value="randomAnswerArray[1]" label="randomAnswerArray[1]" />
                <form:radiobutton path="${questionModel.userAnswer}" value="randomAnswerArray[2]" label="randomAnswerArray[2]" />

                <form:radiobutton path="#" value="#" label="Svar 1" />
                <form:radiobutton path="#" value="#" label="Svar 2" />
                <form:radiobutton path="#" value="#" label="Svar 3" />

              </div>
            </c:forEach>


        </form:form>
    </div>
  </div>

</body>
</html>
