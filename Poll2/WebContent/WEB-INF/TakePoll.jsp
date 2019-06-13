<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
<style>


</style>
</head>
<body>

<div class="form-group">
	<form  action="TakePoll"  method="post">
	      
	       <p> ${E.name}</p>
		   <p> <input type="radio" name="A1"  value="1">${E.a1} </p>
		   <p>  <input type="radio" name="A2" value="2">${E.a2}</p>
		   <p> <input type="radio" name="A3" value="3">${E.a3} </p>
			 
	 	 	<button>Submit</button>
	 	 
			</form>
</div>
</body>
</html>
			