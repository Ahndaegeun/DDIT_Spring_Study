<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>LIST</h3>

<a href="/board/get?register">Register</a>

<form method="get" action="/get">
	<button type="submit" name="modify">수정</button>
	<button type="submit" name="remove">삭제</button>
	<button type="submit" name="list">목록</button>
</form>
</body>
</html>