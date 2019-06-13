<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>


<title>Sub Display</title>
</head>
<body>

<p><a href="ADD?id=${subId}">[New Folder] </a> </p>

<table border="1" >
	

	 <c:forEach items="${entries2}" var="entry">
	
	  <tr>
	    <td> <a href="subFolder?id=${entry.id}">${entry.name} </a></td>
	    <td><a href="Delete?id=${entry.id}"> Delete</a></td>
	  </tr>
	  </c:forEach>
	 
 

</table>



</body>
</html>