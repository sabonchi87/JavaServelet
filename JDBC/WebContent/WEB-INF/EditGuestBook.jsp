<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
<style>

form
{
width:30%;
border:2px;
margin:10%;
background-color:Lightgray;
} 
.lb{
 dispaly:inline-block;
 width:10px;
 margin-left:1em;
  margin-right:1.3em;
 }
 input{
 margin-left:4em
 } 
</style>
</head>
<body>

<div class="form-group">
	<form  action="EditServ"  method="post">
	      
		     <label class="lb"> id   :</label> <input  readonly type='text'   value="${c.id}"                 ><br>
			 <label class="lb"> Name:</label> <input    type='text'           value="${c.name}"              name="name"><br>
			 <label class="lb"> message:</label> <input    type='text'    value="${c.message}"       name="message"><br>
			 
	 	   <button class="btn btn-default"> Add</button>
	 	 
			</form>

</div>
</body>
</html>

