<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
a {
	text-decoration: none;
	padding: 1em;
}

table {
	border: 1px solid black;
	cellpadding: 3;
	width: 400px;
	margin: 30px;
}

tr, td {
	border: 1px solid black;
}
</style>
<meta charset="UTF-8">
<title>Main page</title>
</head>
<body>


	<h2>ECST Faculty</h2>
	<p>
		<a href="AddDepartment.jsp">Add Department</a> | <a
			href="AddFaculty.jsp">Add Faculty</a>
	</p>

	<table border="1" cellpadding="2">
		<tr>
			<th>Department</th>
			<th>Name</th>
		</tr>

		
		<c:forEach items="${dep}" var="dep">
			<tr>
				<td rowspan="${dep.size}">     ${dep.name}           </td>
				
	
					<c:forEach items="${dep.faculty}" var="faculty" varStatus="stat">
	
						<td>
							<c:choose>
								<c:when test="${faculty.ischair}"> ( ${faculty.name})</c:when>
							
							
							    <c:when test="${ not faculty.ischair}"> ${faculty.name}</c:when>
							
							
							</c:choose>
						
					
						
				   </td>
						
					
					
		 </tr>
			</c:forEach>
					
	
			</c:forEach>
		


	</table>




</body>
</html>