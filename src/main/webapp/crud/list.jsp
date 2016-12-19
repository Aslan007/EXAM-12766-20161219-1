<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list.jsp</title>
</head>
<body>
<center><h2><a href="/Exam-12766-20161219-1/index.jsp">index</a></h2></center>
<center><h1>list</h1>
<table border="1">
       <tr>
           <td>film_id</td>
           <td>title</td>
           <td>description</td>
           <td>language</td>
           <td>delete?</td>
       </tr>
       <c:forEach items="${filmList }" var="f">  
           <tr>
               <td>${f.filmId }</td>
               <td>${f.title }</td>
               <td>${f.description }</td>
               <td>${f.language }</td>
               <td><a href="/Exam-12766-20161219-1/UserServlet?submitFlag=toDelete&film_id=${f.filmId }" onclick="javaScript:alert('您确定要删除吗？')">delete</a></td>
               <td><a href="/Exam-12766-20161219-1/UserServlet?submitFlag=toUpdate&film_id=${f.filmId }">edit</a></td>
           </tr>
           </c:forEach>
   </table>
</center>
</body>
</html>