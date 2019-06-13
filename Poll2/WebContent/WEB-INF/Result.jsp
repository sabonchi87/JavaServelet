<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
<style>


</style>
</head>
<body>

<div class="form-group">
	
	 <c:forEach  items="${Result}" var="entry" varStatus="loop">    
	       <p> ${E1.name} </p>
		   <p> ${E1.a1} :${entry.a1}</p>
		   <p>  ${E1.a2}:${entry.a2}</p>
		   <p> ${E1.a3} : ${entry.a3}</p>
			 
	 	 	
	 	 
		
		</c:forEach>
</div>
</body>
</html>
		