<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>edit</title>
</head>
<body>
<form action="/Exam-12766-20161219-1/UserServlet" method="post">
<center>
<table border="1" >
       <tr>
       		<td>film_id</td>
           <td>title</td>
           <td>description</td>
           <td>language</td>
       </tr>
       <tr>
       <td><input type="text" name="film_id" value="${film.filmId }"></td>
       <td ><input type="text"name ="title" value="${film.title }" style="width: 200px"></td>
       <td ><input type="text"name ="description" value="${film.description }" style="width: 550px"></td>
       
       <td><select name="language" id="language" >
    				<option value="1" <c:if test="${film.language== 'English'} ">selected="selected"</c:if>>English</option>
    				
					<option value="2" <c:if test="${film.language == 'Italian'}">selected="selected"</c:if>>Italian</option>
					<option value="3" <c:if test="${film.language == 'Japanese'}">selected="selected"</c:if>>Japanese</option>
					<option value="4" <c:if test="${film.language == 'Mandarin'}">selected="selected"</c:if>>Mandarin</option>
					<option value="5" <c:if test="${film.language == 'French'}">selected="selected"</c:if>>French</option>
					<option value="6" <c:if test="${film.language == 'German'}">selected="selected"</c:if>>German</option>
					
    </select></td>
    </tr>
</table>

<input type="submit" value="submit">
<input type="reset" value="reset">
<input type="hidden" name="submitFlag" value="update">

</center>

</form>

</body>
</html>