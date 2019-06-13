<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<p><a href="AddQues">Ask a Question</a></p>



<table border="3">
		
		
		  <tr><th># of Answers</th><th>Question</th></tr>
		  <c:forEach items="${entries}" var="entry" varStatus="loop">
		  <tr>
		  
		  <td> ${sum[loop.index]}</td>
		    <td> <a href="Details?id=${entry.id}&n=${entry.name}&dt=${entry.details}"> ${entry.name} </a></td>
		  </tr>
		 
		 </c:forEach>
		 
</table>

		





</body>
</html>