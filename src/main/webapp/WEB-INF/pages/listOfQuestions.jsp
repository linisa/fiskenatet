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

<script src="${pageContext.request.contextPath}/js/ListOfQuestionsScript.js"></script>

</head>
<body>
  <jsp:include page="page-header.jsp"></jsp:include>
        <div id="pageclass">
          <div id="questionResponse"></div>
          <table border="1px" cellpadding="0" cellspacing="0">
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
                    <a href="${pageContext.request.contextPath}/deleteQuestion/${questionModel.id}.json">Delete</a>
                  </td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        <a href="index">Tillbaka</a>
        </div>
 <jsp:include page="page-footer.jsp"></jsp:include>
</body>
</html>
