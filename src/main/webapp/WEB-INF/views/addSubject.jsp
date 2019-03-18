<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Add Subject</title>
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
		
	<h2>Add Subject</h2>
	<form:form method="POST" action="subject/save" modelAttribute="subject">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<td><form:label path="subjectId">Subject Id:</form:label></td>
				<td><form:input path="subjectId" /> 
				    <form:errors path="subjectId" cssClass="error" />
				</td>
			</tr>
			<tr>
				<td><form:label path="subtitle">Subject Title:</form:label></td>
				<td><form:input path="subtitle" /> <form:errors path="subtitle"
						cssClass="error" /></td>
			</tr>
			
			<tr>				
				<td><form:label path="durationInHours">Duration In Hours:</form:label></td>
				<td><form:input path="durationInHours" />
				 <form:errors path="durationInHours" cssClass="error" />
				</td>
			</tr>
            <tr>				
				<td><form:label path="references">References:</form:label></td>
				<td><form:input path="references" />
				 <form:errors path="references" cssClass="error" />
				</td>
			</tr>			

			<tr height="50">
				<td />
				<td><input type="submit" value="Save" />&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="Reset" /> &nbsp;&nbsp;&nbsp;&nbsp; 
					<a href="${contextPath}/subject/list">Back</a></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
