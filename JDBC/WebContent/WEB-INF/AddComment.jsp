<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Comment</title>
</head>
<body>
<h2>GuestBook - Add Comment</h2>


<form action="AddCommentServ" method="post">
<table>
  <tr>
    <td>Name</td>
    <td>
      <input type="text" name="name" />
    </td>
  </tr>
  <tr>
    <td>Message</td>
    <td>
      <textarea name="message" rows="5" cols="60"></textarea>
    </td>
  </tr>
  <tr>
    <td>
      <input type="submit" name="add" value="Add Comment" />
    </td>
    <td></td>
  </tr>
</table>
</form>
</body>
</html>