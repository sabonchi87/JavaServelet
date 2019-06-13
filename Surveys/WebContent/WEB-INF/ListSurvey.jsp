<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ListSurvey.jsp"</title>
</head>
<body>

<p> <a href="CreateSurvey">Create Survey</a>  </p>


<ul>

		<c:forEach items="${surveys}" var="surveys">
		  
		   <li> <a href="ViewSurvey?id=${surveys.id}"> ${surveys.name}</a> <input type="hidden" name="${surveys.id}"><span>
</span></li>
		   
		
		
		
		
		
		</c:forEach>
</ul>

</body>
</html>