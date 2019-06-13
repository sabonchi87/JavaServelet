<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Qurestion</title>
</head>
<body>
<p><a href="">Survey Builder</a> &gt;${entry.name}  &gt;${entry.name}Add Question</p>

<form action="AddQuestion"  method="post">
		<p> <label> Question:</label>  <input type="text" name="ques"> </p>
		
		<br>
		<p> Choices</p>
		
		<input type="text" name="choice1">
		
		<input type="text" name="choice2"> <br>
		<input type="text" name="choice3"><br>
		<input type="text" name="choice4"><br>
		<input type="text" name="choice5"><br>
		<input type="text" name="choice6"><br>
		<input type="text" name="choice7"><br>
		<input type="text" name="choice8"><br>
		<input type="text" name="choice9"><br>
		<input type="text" name="choice10"><br>
		
		<button> AddQuestion</button>
</form>

</body>
</html>