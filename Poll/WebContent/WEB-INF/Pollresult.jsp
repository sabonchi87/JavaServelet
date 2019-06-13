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

 <c:forEach items="${result}" var="entry">

<p> ${ent.choice1}  <span>   ${entry.a}   </span> </p>
<p> ${ent.choice2}  <span>    ${entry.b}  </span></p>

<p>${ent.choice3}  <span>    ${entry.c}  </span></p>

</c:forEach>

</body>
</html>