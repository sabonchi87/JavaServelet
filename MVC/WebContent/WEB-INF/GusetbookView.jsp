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

<table border="2">
<tr> <td>Id </td> <td> Name</td> <td> Message</td></tr>

<c:forEach items="${entry}" var="entry">


<tr><td>${entry.id}</td> 
<td>${entry.name}</td>
<td>${entry.message}</td>  </tr>
</c:forEach>
</table>
<p><a href="addCommentMvc">addComment</a> </p><br>
</body>
</html>