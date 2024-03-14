<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Preferenza: <% out.print(session.getAttribute("username")); %></title>
</head>
<body>
	<FORM action="http://localhost:8080/04_ServletJSP/preferenza" method="POST">
		
			<p>nome: <INPUT TYPE="text" NAME="nome" SIZE=50></p>
			<p>Cognome: <INPUT TYPE="text" NAME="cognome" SIZE=50></p>
			<p>Materia: <INPUT TYPE="text" NAME="materia" SIZE=30></p>
			<p><INPUT TYPE="submit"></p>
			<p><INPUT TYPE="reset" NAME="resetbutton" VALUE="Clear data"> </p>
		</FORM>
</body>
</html>