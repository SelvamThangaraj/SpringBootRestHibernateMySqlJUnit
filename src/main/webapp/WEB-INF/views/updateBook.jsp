<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Update Book</title>
</head>

<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>


<body>
		
	<h2>Add Book</h2>
	<form:form method="POST" action="/SpringBootExample/book/book/update" modelAttribute="book">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<td><form:label path="bookId">Book Id:</form:label></td>
				<td><form:input path="bookId" /> 
				    <form:errors path="bookId" cssClass="error" />
				</td>
			</tr>
			<tr>
				<td><form:label path="title">Book Title:</form:label></td>
				<td><form:input path="title" />
				 <form:errors path="title"
						cssClass="error" /></td>
			</tr>
			
			<tr>				
				<td><form:label path="price">Price:</form:label></td>
				<td><form:input path="price" />
				 <form:errors path="price" cssClass="error" />
				</td>
			</tr>
            <tr>				
				<td><form:label path="volume">Volume:</form:label></td>
				<td><form:input path="volume" />
				 <form:errors path="volume" cssClass="error" />
				</td>
			</tr>
			<tr>				
				<td><form:label path="publishDate">Publish Date (dd-MM-yyyy):</form:label></td>
				<td><form:input path="publishDate" />
				 <form:errors path="publishDate" cssClass="error" />
				</td>
			</tr>
			

			<tr height="50">
				<td />
				<td><input type="submit" value="Edit Save" />&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="Reset" /> &nbsp;&nbsp;&nbsp;&nbsp; 
					<a href="${contextPath}/book/list">Back</a></td>

			</tr>
		</table>
	</form:form>
</body>
</html>
