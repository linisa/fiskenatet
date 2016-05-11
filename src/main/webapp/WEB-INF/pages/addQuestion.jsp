<%@ include file="taglib.jsp" %>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/default.css">

<title>Frågesport</title>

<script src="${pageContext.request.contextPath}/js/AddQuestionScript.js"></script>

</head>
<body>
<jsp:include page="page-header.jsp"></jsp:include>
    <div id="addQuestion" class="pageclass">
      <h2>Skapa ny fråga</h2>
      <div id="fromResponse"></div>
         <div id="addQuestionList">
             <form:form id="newQuestionForm" action="${pageContext.request.contextPath}/createQuestion.json" commandName="questionModel">
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
                       <input type="submit" value="Save" id="save" />
                   </li>
                 </ul>
             </form:form>
         </div>

 <br /><br />
 <a href="index">Tillbaka</a>
    </div>
<jsp:include page="page-footer.jsp"></jsp:include>
</body>
</html>
