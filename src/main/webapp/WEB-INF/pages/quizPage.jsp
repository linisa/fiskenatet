<%@ include file="taglib.jsp" %>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/default.css">

<title>Frågesport</title>

<script src="${pageContext.request.contextPath}/js/Timer.js"></script>

</head>
<body>
<jsp:include page="page-header.jsp"></jsp:include>
	<div class="pageclass">
	<div>
      <p>Tid kvar: </p>
      <span id="remainingTime"></span>
    </div>
    <div>
        <form method="POST">

            <c:forEach items="${questions}" var="questionModel" varStatus="counter">
              <div class="quizSection">
                <h3><c:out value="${questionModel.question}"></c:out></h3>
                	<input type="radio" name="answer${counter.index}" value="${ questionModel.randomPosition[0]}" ><label>${questionModel.randomPosition[0]}</label><br>
                	<input type="radio" name="answer${counter.index}" value="${ questionModel.randomPosition[1]}" ><label>${questionModel.randomPosition[1]}</label><br>
                	<input type="radio" name="answer${counter.index}" value="${ questionModel.randomPosition[2]}" ><label>${questionModel.randomPosition[2]}</label><br>
              </div>
            </c:forEach>
            <input id="submit" type="submit" value="Rätta">
        </form>
    </div>
    </div>
<jsp:include page="page-footer.jsp"></jsp:include>
</body>
</html>
