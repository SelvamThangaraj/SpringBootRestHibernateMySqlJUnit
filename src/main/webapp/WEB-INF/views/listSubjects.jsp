<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Subjects List</title>
</head>

<spring:url value="/" var="contextPath" htmlEscape="true" />

<body>
	<span>Welcome <strong> <c:out value="${userName}" /> </strong></span>
	<br>
	<h2>Subjects List</h2>

	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>DurationInHours</th>
			<th>Book References</th>			
		</tr>

		<c:if test="${empty subList}">
			<tr>
				<td colspan="11" align="center">No record found to display.</td>
			</tr>
		</c:if>

		<c:forEach var="sub" items="${subList}">
			<tr>
				<td>${sub.subjectId}</td>
				<td>${sub.subtitle}</td>
				<td>${sub.durationInHours}</td>				
				<td>${sub.references}</td>				
				<td><a href="${contextPath}subject/update/${sub.subjectId}">Edit</a></td>
				<td><a href="${contextPath}subject/delete/${sub.subjectId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>

	<a href="${contextPath}/subject/showAdd">Add New Subject</a> &nbsp;&nbsp;
	<a href="${contextPath}/logout">Logout</a>
</body>
</html>