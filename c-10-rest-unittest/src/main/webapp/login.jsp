<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<%@ page isELIgnored="false" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>login</title>
</head>
<body>
${errors}
<form action="login" method="post">
username:	<input type="text" name="username"/><br/>
password:	<input type="password" name="password"/><br/>
<input type="submit" name="login"/>
</form>
</body>
</html>