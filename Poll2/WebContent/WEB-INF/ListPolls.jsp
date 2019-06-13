<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Polls</title>
</head>
<body>
<h2>List Polls</h2>

<p><a href="CreatePoll">Create a Poll</a></p>

<table border="2">
  <tr><th>Polls</th> <th> </th></tr>
  <c:forEach items="${entries}" var="entry">

  <tr>
    <td>${entry.name}</td>
    
   <td><a href="TakePoll?id=${entry.id}"> Take the Poll </a> <span> |</span> <a href="result?id=${entry.id}">Results</a></td>
  </tr>
  </c:forEach>
</table>

</body>
</html>
