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



<table border="1" >

<form    action="AddFacultyServ"   method="post" >

			<tr>
			 <th> Department</th>  
			<th> 
			  <select name="department" size="1" >
			  
			       <c:forEach items="${dep}" var="dep">
			        	<option>${dep.name}</option>
			        
			    	</c:forEach>
			  </select>
			    </th>
			    </tr>
			
			<tr> 
					<td><label>Name:</label></td>   
					<td><input type="text" name="name"></td>
			</tr>
					
			<tr> 
					<td><label>Chairperson</label>:</label></td>   
					<td><input type="checkbox" name="chair" value="true"></td>   
			</tr>
			
			<tr> <td colspan="2"> <button type="submit">Add</button> </tr>
	</form>
</table>











</body>
</html>