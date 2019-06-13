<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DisplayQuestion</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


</head>
<body>

<br>
<br>

<p> <a href="CreatePollServ">Create a Poll</a></p>

<table border="1" class="table table-bordered table-striped table-hover">
	<tr> <th>Polls</th>  <th></th>   </tr>


    <c:forEach items="${entries}" var="entry" varStatus="loop"> 
       
		   <tr>  
		   <td>  <c:out value="${entry.name}">   </c:out> </td>
		   <td><a href="Takepoll?id=${entry.id}">Take the Poll</a>  <span>||</span><a href="Pollresult?id=${entry.id}">Results</a></td>  
		   </tr>
		

   </c:forEach>
</table>



 





</body>
</html>