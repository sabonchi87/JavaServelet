<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<form    action="addCommentMvc" method="post">
<lable> Name </lable><input type="text" name="name" ><br>
<lable> MESSAGE </lable><textarea name="message" rows="5" cols="20"></textarea>
<button value="add">ADD</button>
</form>



</body>
</html>