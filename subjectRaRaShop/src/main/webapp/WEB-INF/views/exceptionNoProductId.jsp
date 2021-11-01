<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="false" %>
<!-- 에러 페이지에 해당하는 JSP 페이지는 page 디렉티브의 isErrorPage 속성의 값을 true로 지정해야 함 -->
<!DOCTYPE html>
<html>
<head>
<title>상품 아이디 오류</title>
</head>
<body>
<jsp:include page="menu.jsp" />

	<div class="jumbotron">
		<div class="container">
			<h2 class="alert alert-danger">해당 상품이 존재하지 않습니다.</h2>
		</div>
	</div>
	<div class="container">
		<p><%=request.getRequestURL()%>?<%=request.getQueryString()%></p>
		<p><a href="products.jsp" class="btn btn-secondary">상품 목록 &raquo;</a>
	</div>

<jsp:include page="footer.jsp" />
</body>
</html>