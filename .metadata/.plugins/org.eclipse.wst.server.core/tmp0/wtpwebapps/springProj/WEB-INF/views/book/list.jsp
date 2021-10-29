<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table tr * {
		padding: 10px 20px;
	}
</style>
</head>
<body>
<table border="1">
<tr>
	<th>제목</th>
	<th>카테고리</th>
	<th>가격</th>
</tr>
<c:forEach items="${list}" var="item">
<tr>
	<td><a href="/detail?bookId=${item.BOOK_ID}">${item.TITLE}</a></td>
	<td>${item.CATEGORY}</td>
	<td>${item.PRICE}</td>
</tr>
</c:forEach>
</table>
<a href="/create">등록</a>
<form>
	<input type="text" name="keyword" value="${keyword}">
	<input type="submit" value="검색">
</form>
</body>
</html>