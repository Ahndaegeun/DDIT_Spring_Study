<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>상품 목록(/guestbook/products.jsp)</title>
</head>
<body>
<jsp:include page="menu.jsp" />
<div class="jumbotron">
	<div class="container">
		<h1 class="display-3">상품 목록</h1>
	</div>
	
	<div class="container">
		<div class="row" align="center">
			<c:forEach items="${list}" var="item">
			<div class="col-md-4">
				<img src="../resources/images/${item.P_FILENAME}" style="width:100%" />
				<h3>${item.P_NAME}</h3>
				<p>${item.P_DESCRIPTION}</p>
				<p>${item.P_UNITPRICE}원</p>
				<p><a href="/product/detail?id=${item.P_ID}"
					class="btn btn-secondary" role="button">상세 정보&raquo;></a>
				</p>
			</div>
			</c:forEach>
		</div>
	</div>
</div>
<jsp:include page="footer.jsp" />
</body>
</html>


