<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<center>
<form action="UserServlet" method="post">
<p>username:<input type="text" name="name"></p>
<p><input type="hidden" name="submitFlag" value="userLogin"></p>
<input type="submit" value="submit">
<input type="reset" value="reset">
</form>
</center>
</body>
</html>