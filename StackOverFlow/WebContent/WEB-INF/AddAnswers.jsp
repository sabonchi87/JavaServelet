<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AddAnswer</title>
</head>
<body>
<table border="1"  class="mt-3 table table-bordered table-striped table-hover ">
	
<form   action="AddAnswer"  method="post">

		  <tr> 
		  <th>Question:</th><td> ${name}</td> 
		  </tr>
		  
		  
		  <tr>
				<td>Comments</td>
				<td><textarea name="answer"></textarea></td>
			</tr>
			
		  <tr><button type="submit"> add</button></tr>
		   
		
         </form>


</table>



</body>
</html>