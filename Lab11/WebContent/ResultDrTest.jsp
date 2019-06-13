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
<table border="1">

<tr><td> Question</td> <td>CorrectAnswer </td> <td>YourAnswer </td> </tr>
<c:forEach   var="i" begin="0" end="9">
<tr>
<td>${i}</td>  
<td> ${corAnswer[i]}</td>
 <td> ${TrackAns[i]} </td>
  </tr>


            </c:forEach>

</table>
	<p><span>score</span> ${score}<span>/10</span></p><br>
	
	<p><a href="DrivingTestBrowser">start over</a></p>
	
</body>
</html>