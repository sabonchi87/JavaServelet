<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ViewSurvey</title>
</head>
<body>
<p><a href="ListSurveys">Survey Builder</a> &gt;${entry.name} </p>

<p><a href="AddQuestion">Add Question</a> </p>


<!-- ${ques.description} -->
<c:forEach items="${questions}" var="ques" varStatus="stat" >
	<p><label>${stat.index}</label>${ques.description }  </p>

	<c:forEach items="${ques.choices}" var="choice">
		  
		   <li> <input type="radio">${choice} </li>
		
		
		
		
		
		</c:forEach>




</c:forEach>
</body>
</html>