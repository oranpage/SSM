<%@page import="net.wanho.model.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/student/update" method="post">
<input type="text" name="id" value="${student.id}" readonly="readonly">
 用户名：<input type="text" name="name" value="${student.name}">
 年龄：<input type="text" name="age" value="${student.age}">
 <input type="submit" value="修改">
</form>
</body>
</html>