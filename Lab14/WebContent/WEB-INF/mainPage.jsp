<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Bracketology</h1>

<form action="TeamServer" method="post">
	
	
			 <c:forEach items="${Team}" var="Teams" varStatus="i" >
					  <p> 
						     <span>Match${i.index+1}: </span> 
						     <span>${Teams.team1}<input type="radio"  name="Match${Teams.id}" value="${Teams.team1}"></span> 
						     <span>${Teams.team2}<input type="radio"  name="Match${Teams.id}" value="${Teams.team2}"></span>
					 </p>
		
			 </c:forEach>
			   
			   
	 <button >Next</button>
</form>








</body>
</html>