<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Frågesport</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript">

  $(document).ready(function() {

    $("#editQuestionForm").submit(function(event) {
      var question = $("question").val();
      var correctAnswer = $("correctAnswer").val();
      var firstWrongAnswer = $("firstWrongAnswer").val();
      var secondWrongAnswer = $("secondWrongAnswer").val();
      var category = $("category").val();
      var subCategory = $("subCategory").val();
      var json = {"question":question,"correctAnswer":correctAnswer,"firstWrongAnswer":firstWrongAnswer,
            "secondWrongAnswer":secondWrongAnswer,"category":category,"subCategory":subCategory};

      $.ajax({
        url: $("#editQuestionForm").attr("action"),
        data: JSON.stringify(json),
        type : "POST",

        beforeSend: function(xhr) {
          xhr.setRequestHeader("Accept", "application/json");
          xhr.setRequestHeader("Content-Type", "application/json");
        },
      	success: function(data) {
			var response = "";

			response += "<span class="succes">Frågan har skapats: [";
			response += questionModel.question + "]</span>";
			$("#fromResponse").html(response);
		}
      });
      event.preventDefault();
    });
  });
</script>
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
    <div id="editQuestion">
      <h2>Ändra fråga</h2>
      <div id="fromResponse"></div>
         <div id="editQuestionList">
             <form:form id="editQuestionForm" action="${pageContext.request.contextPath}/editQuestion.json" commandName="questionModel">
                 <ul>
                   <li>
                       <label for="question">Fråga:</label>
                       <input name="question" id="question" path="question" value="${question.question}"/>
                   </li>
                   <br>
                   <li>
                     <label for="correctAnswer">Rätt svar:</label>
                     <input name="correctAnswer" id="correctAnswer" path="correctAnswer" value="${question.correctAnswer}"/>
                   </li>
                    <br>
                   <li>
                     <label for="firstWrongAnswer">Fel svar 1:</label>
                     <input name="firstWrongAnswer" id="firstWrongAnswer" path="firstWrongAnswer" value="${question.firstWrongAnswer}"/>
                   </li>
                    <br>
                   <li>
                     <label for="secondWrongAnswer">Fel svar 2:</label>
                     <input name="secondWrongAnswer" id="secondWrongAnswer" path="secondWrongAnswer" value="${question.secondWrongAnswer}"/>
                   </li>
                    <br>

                   <li>
                     <label for="category">Kategori:</label>
                     <input name="category" id="category" path="category" value="${question.category}"/>
                   </li>
                    <br>
                    <li>
                     <label for="subCategory">Underkategori:</label>
                     <input name="subCategory" id="subCategory" path="subCategory" value="${question.subCategory}"/>
                   </li>
                    <br>
                   <li>
                       <input type="submit" value="Edit" id="edit" />
                   </li>
                 </ul>
             </form:form>
         </div>

 <br /><br />
 <a href="index">Tillbaka</a>
    </div>
  </div>

</body>
</html>
