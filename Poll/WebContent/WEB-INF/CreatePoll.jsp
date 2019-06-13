<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>

<form  action="CreatePollServ" method="post">
		<tr><td>Question: </td>  <td> <input type="text" name="q">  </td></tr>
		
		<tr> <td>Answer 1: </td>  <td> <input type="text" name="ch1"></td></tr>
		
		<tr> <td>Answer 2: </td>  <td> <input type="text" name="ch2"></td></tr>
		<tr> <td>Answer 3: </td>  <td> <input type="text" name="ch3"></td></tr>
					<tr> <td> <button> create</button> </td></tr>
</form>


</table>




</body>
</html>