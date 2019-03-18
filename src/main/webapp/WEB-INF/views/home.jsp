<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Spring Web MVC Assignment</title>
</head>
<body>
	<h1>Welcome to Spring Web MVC App!</h1>
	<p> Current Time: ${serverTime} </p>
	<p> <a href="/SpringBootExample/subject/showAdd">Add Subject</a>
	<p> <a href="/SpringBootExample/book/showbook">Add Book</a>
</body>
</html>
