<%@ include file="taglib.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/default.css">

<title>Frågesport</title>

</head>
<body>
<jsp:include page="page-header.jsp"></jsp:include>
	
		<div class="pageclass">
			<h2>Du hade ${correctAndTotalAnswers[0]} av ${correctAndTotalAnswers[1]} möjliga!</h2>
		</div>
<jsp:include page="page-footer.jsp"></jsp:include>
</body>
</html>
