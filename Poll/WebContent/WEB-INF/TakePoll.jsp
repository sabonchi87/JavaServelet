<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="Takepoll" method="post">
<p> ${c.name}  </p>
<p> <input type="radio" name="ch1" value="1">${c.choice1} </p>
<p> <input type="radio" name="ch2" value="2">${c.choice2} </p>

<p> <input type="radio" name="ch3" value="3">${c.choice3} </p>

<p> <button> add</button> </p>
</form>
</body>
</html>