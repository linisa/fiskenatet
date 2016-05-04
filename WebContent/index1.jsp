<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<h3>Quiz Game</h3>

	The time on the server is
	<%=new java.util.Date()%>
	<br>
	<br> Converting string to
	<%=new String("uppercase").toUpperCase()%>
	<br>
	<br> Is 75 less than 69?
	<%=75 < 69%>
	<br>
	<br>
	<%
		for (int i = 1; i <= 5; i++) {
			out.println("<br> Lets count: " + i);
		}
	%>
	<br>
	<br>

	<%!String makeItLower(String data) {
		return data.toLowerCase();
	}%>
	Lower case "Hello World":
	<%=makeItLower("Hello World")%>
</body>
</html>