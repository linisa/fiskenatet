<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Frï¿½gesport</title>
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
    <div id="addQuestion">
      <h2>Skapa ny fråga</h2>
         <div id="addQuestionList">
             <form:form method="post" action="questions">
                 <ul>
                   <li>
                       <label for="questionString">Fråga:</label>
                       <input name="questionString" id="questionString" value="${question.question}"/>
                   </li>
                   <br>
                   <li>
                     <label for="correctAnswer">Rätt svar:</label>
                     <input name="correctAnswer" id="correctAnswer" value="${question.correctAnswer}"/>
                   </li>
                    <br>
                   <li>
                     <label for="firstWrongAnswer">Fel svar 1:</label>
                     <input name="firstWrongAnswer" id="firstWrongAnswer" value="${question.firstWrongAnswer}"/>
                   </li>
                    <br>
                   <li>
                     <label for="secondWrongAnswer">Fel svar 2:</label>
                     <input name="secondWrongAnswer" id="secondWrongAnswer" value="${question.secondWrongAnswer}"/>
                   </li>
                    <br>
                    
                   <li>
                     <label for="category">Kategori:</label>
                     <input name="category" id="category" value="${question.category}"/>
                   </li>
                    <br>
                    <li>
                     <label for="subCategory">Underkategori:</label>
                     <input name="subCategory" id="subCategory" value="${question.subCategory}"/>
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
