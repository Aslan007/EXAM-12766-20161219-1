<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add</title>
</head>
<body>
<form action="/Exam-12766-20161219-1/UserServlet" method="post">
<center>
<table border="1" >
       <tr>
           <td>title</td>
           <td>description</td>
           <td>language</td>
       </tr>
       <tr>
       <td><input type="text"name ="title"></td>
       <td><input type="text"name ="description"></td>
       <td><select name="language" id="language" >
    				<option value="1">English</option>
					<option value="2">Italian</option>
					<option value="3">Japanese</option>
					<option value="4">Mandarin</option>
					<option value="5">French</option>
					<option value="6">German</option>
    </select></td>
    </tr>
</table>


<input type="submit" value="submit">
<input type="reset" value="reset">
<input type="hidden" name="submitFlag" value="add">
</center>

</form>

</body>
</html>