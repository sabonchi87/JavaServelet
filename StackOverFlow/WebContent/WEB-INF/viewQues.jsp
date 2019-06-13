<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>StackOverFlow</title>
</head>
<body>

<p> <a href="AskQues">AskQues</a></p>

<h2>StackoverFlow</h2>
<table border="1">
  <tr><th>#ofAnswers</th><th>Questions</th></tr>
  <c:forEach items="${questions}" var="entry" varStatus="loop">
  <tr>
  <td> <c:out value="${Ans[loop.index]}">   </c:out></td>
    <td> <a href="editQuesServ?id=${entry.id}&n=${entry.name}&dt=${entry.detail}"> ${entry.name}</a></td>
  

  </tr>
  </c:forEach>
</table>
<p><a href="AddComment"></a></p>
</body>
</html>
</html>