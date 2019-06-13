<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DMV Test Question</title>
</head>
<body>


<form action="Check" method="get">

	<p>${Q.description}</p>
	<p><input type="radio"  name="q" VALUE="1">${Q.answerA}</p>
	<p><input type="radio"  name="q" VALUE="2">${Q.answerB}</p>
	<p><input type="radio"  name="q" VALUE="3">${Q.answerC}</p>
	<p>correctAnswer ${Q.correctAnswer}</p>
	
<button>  Next</button>
</form>


<!-- <a href="./Check?index=${index}&amp;c=${Q.correctAnswer}" style="text-decoration:none"> -->
<!-- ?index="${pram.index} -->



</body>
</html>