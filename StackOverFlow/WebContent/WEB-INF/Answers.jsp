<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>	Answers</title>
</head>
<body>



<p><a href="MainPage">Back to Questions |</a><span> </span> <a href="AddAnswer">Answers</a> </p>
<table border="1"  class="mt-3 table table-bordered table-striped table-hover ">
	

		  <tr> <th>Question:</th><td>${name} </td> </tr>
		  
		  <tr> <th>Details: </th><td>${dt} </td> </tr>
		  
		  
	
		  <c:forEach items="${details}"  var="A"  varStatus="loop" >
		  
		   <tr>
		 <th>Answers #${loop.index+1}: </th><td>${A.name}</td>
		  </tr>
  		</c:forEach> 
         



</table>




</body>
</html>