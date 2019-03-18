<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Books List</title>
</head>

<spring:url value="/" var="contextPath" htmlEscape="true" />

<body>
	<span>Welcome <strong> <c:out value="${userName}" /> </strong></span>
	<br>
	<h2>Books List</h2>

	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Price</th>
			<th>Volume</th>
			<th>Publish Date</th>			
		</tr>

		<c:if test="${empty bookList}">
			<tr>
				<td colspan="11" align="center">No record found to display.</td>
			</tr>
		</c:if>

		<c:forEach var="book" items="${bookList}">
			<tr>
				<td>${book.bookId}</td>
				<td>${book.title}</td>
				<td>${book.price}</td>				
				<td>${book.volume}</td>
				<td>${book.publishDate}</td>				
				<td><a href="${contextPath}book/update/${book.bookId}">Edit</a></td>
				<td><a href="${contextPath}book/delete/${book.bookId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>

	<a href="${contextPath}/book/showbook">Add new Book</a> &nbsp;&nbsp;
	<a href="${contextPath}/logout">Logout</a>
</body>
</html>