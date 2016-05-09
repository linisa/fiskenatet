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
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">

  $(document).ready(function() {

    var deleteQuestion = $("a:contains('Delete')");

    $(deleteQuestion).click(function(event) {

      $.ajax({
        url: $(event.target).attr("href"),
        type: "DELETE",

        beforeSend: function(xhr){
          xhr.setRequestHeader("Accept", "application/json");
          xhr.setRequestHeader("Content-Type", "application/json");
        },

        success: function(question){
          var response = "";
          var rowToDelete = $(event.target).closest("tr");

          rowToDelete.remove();
          response += "<span class="success">Question was deleted: [";"]</span>";

          $("#questionResponse").html(response);
        }
      });
    //  event.preventDefault();
    });

  });
</script>
</head>
<body>
  <div class="jumotron">
      <div align="middle">
          <img src="bild.jpg" alt="bild"/>
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
            <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" href=""><span class="glyphicon glyphicon-cog"></span>
              <ul class="dropdown-menu">
                <li><a href="${pageContext.request.contextPath}/createQuestion.html">Skapa</a></li>
                <li><a href="#">Ändra</a></li>
                <li><a href="#">Ta bort</a></li>
              </ul>
            </li>
          </ul>
      </div>
        <div id="container">
          <div id="questionResponse"></div>
          <table border="1px" cellpadding="1" cellspacing="1">
            <thead>
              <tr>
                <th>Fråga</th><th>Kategori</th><th>Underkategori</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="questionModel" items="${listOfQuestions}">
                <tr>
                  <td>${questionModel.question}</td>
                  <td>${questionModel.category}</td>
                  <td>${questionModel.subCategory}</td>
                  <td>
                    <a href="${pageContext.request.contextPath}/editQuestion/${questionModel.id}">Edit</a><br/>
                    <a href="${pageContext.request.contextPath}/deleteQuestion/${questionModel.id}">Delete</a>
                  </td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
        <a href="index">Tillbaka</a>
    </div>
</body>
</html>
