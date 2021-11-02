<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>장바구니</title>
</head>
<body>
<jsp:include page="menu.jsp" />
<div class="jumbotron">
	<div class="container">
		<h1 class="display-3">장바구니</h1>
	</div>
</div>
<div class="container">
	<div class="row">
		<table width="100%;">
			<tr>
				<td align="left"><a href="/product/deleteAllCart"
				  class="btn btn-danger">삭제하기</a></td>
				<td align="right"><a href="/product/shipping"
				  class="btn btn-success">주문하기</a></td>
			</tr>
		</table>
	</div>
	<div style="padding-top:50px;">
		<table class="table table-hover">
			<tr>
				<th>상품</th>
				<th>가격</th>
				<th>수량</th>
				<th>소계</th>
				<th>비고</th>
			</tr>
			<c:set var="sum" value="0" />
			<c:forEach items="${sessionScope.itemList}" var="item">
			<tr>
				<td>${item.P_ID} - ${item.P_NAME}</td>
				<td>${item.P_UNITPRICE}</td>
				<td>${item.quantity}</td>
				<td>${item.P_UNITPRICE * item.quantity}</td>
				<td><a href="./removeCart?id=${item.P_ID}" 
						class="badge badge-danger">삭제</a></td>
			</tr>
			<c:set var="sum" value="${sum + item.P_UNITPRICE * item.quantity}"/>
			</c:forEach>
			<tr>
				<th></th><th></th><th>총액</th><th>${sum}</th><th></th>
			</tr>
		</table>
		<a href="./products.jsp" class="btn btn-secondary">&laquo; 쇼핑 계속하기</a>
	</div>
	<hr />
</div>


<jsp:include page="footer.jsp" />
</body>
</html>


