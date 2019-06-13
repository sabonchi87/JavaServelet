<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AddQuestions</title>
</head>
<body>

<br>
<br>

<table border="1"  class="mt-3 table table-bordered table-striped table-hover ">
	
<form action="AddQues"  method="post">

  <tr> <th> Question</th><td> <input type="text"  size="20" name="Questionname"></td> </tr>
  
  
  
  
  <tr><th>  Details </th>  <td><textarea name="details" column="11"></textarea></td> </tr>	  

			<tr>
				<td><button type="submit">Add</button></td>
			</tr>
          
</form>


</table>



</body>
</html>