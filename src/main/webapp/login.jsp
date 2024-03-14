<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

		<FORM action="http://localhost:8080/04_ServletJSP/login" method="GET">
		
			<p>Email: <INPUT TYPE="text" NAME="username" SIZE=50></p>
			<p>Password: <INPUT TYPE="password" NAME="password" SIZE=30></p>
			<p><INPUT TYPE="submit"></p>
			<p><INPUT TYPE="reset" NAME="resetbutton" VALUE="Clear data"> </p>
		</FORM>
		
<%
out.print((String)session.getAttribute("username"));
%>

</body>
</html>