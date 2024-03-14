<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
</head>
<body>
<h1>Errore<h1>
<p><%= exception.getMessage() %></p>
<a href="http://localhost:8080/04_ServletJSP/index.html">Torna al LogIn</a>
</body>
</html>