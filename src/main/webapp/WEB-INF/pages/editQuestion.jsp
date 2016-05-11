<%@ include file="taglib.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/default.css">

<title>Frågesport</title>

<script src="${pageContext.request.contextPath}/js/EditQuestionScript.js"></script>

</head>
<body>
<jsp:include page="page-header.jsp"></jsp:include>
    <div id="editQuestion" class="pageclass">
      <h2>Ändra fråga</h2>
      <div id="fromResponse"></div>
         <div id="editQuestionList">
             <form:form id="editQuestionForm" method="POST" action="${pageContext.request.contextPath}/editQuestion/${questionModel.id}.json" commandName="questionModel">
                 <ul>
                   <li>
                       <label for="question">Fråga:</label>
                       <input name="question" id="question" path="question" value="${questionModel.question}"/>
                   </li>
                   <br>
                   <li>
                     <label for="correctAnswer">Rätt svar:</label>
                     <input name="correctAnswer" id="correctAnswer" path="correctAnswer" value="${questionModel.correctAnswer}"/>
                   </li>
                    <br>
                   <li>
                     <label for="firstWrongAnswer">Fel svar 1:</label>
                     <input name="firstWrongAnswer" id="firstWrongAnswer" path="firstWrongAnswer" value="${questionModel.firstWrongAnswer}"/>
                   </li>
                    <br>
                   <li>
                     <label for="secondWrongAnswer">Fel svar 2:</label>
                     <input name="secondWrongAnswer" id="secondWrongAnswer" path="secondWrongAnswer" value="${questionModel.secondWrongAnswer}"/>
                   </li>
                    <br>

                   <li>
                     <label for="category">Kategori:</label>
                     <input name="category" id="category" path="category" value="${questionModel.category}"/>
                   </li>
                    <br>
                    <li>
                     <label for="subCategory">Underkategori:</label>
                     <input name="subCategory" id="subCategory" path="subCategory" value="${questionModel.subCategory}"/>
                   </li>
                    <br>
                   <li>
                       <input type="submit" value="Spara ändringar" id="edit" />
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
