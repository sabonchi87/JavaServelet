<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Files</title>
</head>
<body>
<h2>Files</h2>

<p><a href="ADDFolders?id=-1">[ New Folder ]</a></p>


<table border="1">
 
  <c:forEach items="${entries}" var="entry">
  <tr>
   
    <c:choose>
 
		<c:when test="${entry.is_folder}"> 
		      
		       <td> <a href="SubFolders?id=${entry.id}&n=${entry.name}"> ${entry.name} </a></td>
			   
		      
		</c:when>
		
	
	
		      <c:otherwise> 
		  
		      <td> ${entry.name}</td>
			
		     
		     </c:otherwise> 
     
     </c:choose>
  
  
  <td> <a href="DeleFiles?id=${entry.id}">Delete</a></td>
  
  
  </tr>
  </c:forEach>
</table>

</body>
</html>
