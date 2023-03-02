<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>details</title>
</head>
<body>
<c:choose>
	<c:when test="${not empty errors}">
		${errors}
	</c:when>
	<c:otherwise>
		id : ${job.id}<br/>
		titre : ${job.title}<br/>
		min s : ${job.minSalary}<br/>
		mas s : ${job.maxSalary}<br/>
		<a href="jobRemove?id=${job.id}">supprimer</a>
	</c:otherwise>
</c:choose>

</body>
</html>