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

    $("#newCategoryForm").submit(function(event) {
      var category = $("category").val();
      var underCategoryName = $("underCategoryName").val();
      var json = {"category":category,"underCategoryName":underCategoryName};

      $.ajax({
        url: $("#newCategoryForm").attr("action"),
        data: JSON.stringify(json),
        type : "POST",

        beforeSend: function(xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "application/json");
          },
      	success: function(data) {
			var response = "";

			response += "<span class="succes">kategorin har skapats: [";
			response += underCategoryModel.underCategoryName + "]</span>";
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
    <div id="addQuestion">
      <h2>Skapa ny quiz</h2>
      <div id="fromResponse"></div>
         <div id="addCategoryList">
             <form:form id="newCategoryForm" action="${pageContext.request.contextPath}/createCategory.json" commandName="underCategoryModel">
                 <ul>
                   <li>
                     <label for="category">Kategori:</label>
                   	  <form:select path="category">
                       <form:option value="1">Geografi</form:option>
                       <form:option value="2">Sport</form:option>
                       <form:option value="3">Natur</form:option>
                       <form:option value="4">Film</form:option>
                       <form:option value="5">Musik</form:option>
                       <form:option value="6">Litteratur</form:option>
                     </form:select> 
                   </li>
                    <br>
                    <li>
                     <label for="underCategoryName">Underkategori:</label>
                     <input name="underCategoryName" id="underCategoryName" path="underCategoryName" value="${undercategory.underCategoryName}"/>
                   </li>
                    <br>
                   <li>
                       <input type="submit" value="Save" id="save" />
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
