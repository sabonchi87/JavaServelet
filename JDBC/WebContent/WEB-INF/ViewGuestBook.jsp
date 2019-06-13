<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GuestBook</title>
</head>
<body>
<h2>GuestBook</h2>
<table border="1">
  <tr><th>Name</th><th>Message</th> <th> Edit</th>  <th> Delete</th></tr>
  <c:forEach items="${entries}" var="entry">
  <tr>
    <td>${entry.name}</td>
    <td>${entry.message}</td>
   <%--  <td><fmt:formatDate value="${entry.date}" type="both" /> --%>
   <td><a href="EditServ?id=${entry.id}">Edit </a></td>
    <td><a href="DeleteServ?id=${entry.id}">Delete </a></td>
  </tr>
  </c:forEach>
</table>
<p><a href="AddCommentServ">Add Comment</a></p>
</body>
</html>