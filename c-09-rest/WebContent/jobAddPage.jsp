<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>login</title>
</head>
<body>
${errors}
<form action="jobAdd" method="GET">
titre:	<input type="text" name="title"/><br/>
min salary:	<input type="text" name="minSalary"/><br/>
max salary:	<input type="text" name="maxSalary"/><br/>
<input type="submit" name="login"/>
</form>
</body>
</html>