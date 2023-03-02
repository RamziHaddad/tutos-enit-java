<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>liste</title>
</head>
<body>
${errors}
${username}
<TABLE>
	<tr><td>id</td><td>title</td></tr>
	<c:forEach items="${jobs}" var="j">
		<tr><td>${j.id}</td><td><a href="jobDetails?id=${j.id}">${j.title}</a></td></td><td><a href="jobRemove?id=${j.id}">supprimer</a></td></THEAD>
	</c:forEach>
</TABLE>
</body>
</html>