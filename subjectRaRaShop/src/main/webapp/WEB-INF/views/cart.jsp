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
				<td align="left"><a href="./deleteCart.jsp?cartId=<%=cartId%>"
				  class="btn btn-danger">삭제하기</a></td>
				<td align="right"><a href="./shippingInfo.jsp?cartId=<%=cartId%>"
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
			<%
			int sum = 0;
			//장바구니인 cartlist에 등록된 모든 상품을 가져옴.
			ArrayList<Product> cartList 
			= (ArrayList<Product>)session.getAttribute("cartlist");
			//cartlist에 저장된 상품 목록이 없으면 장바구니 cartlist를 생성
			if(cartList==null){
				cartList = new ArrayList<Product>();
			}
			//cartlist에 등록된 모든 상품을 하나씩 가져외 출력
			for(int i=0;i<cartList.size();i++){
				Product product = cartList.get(i);
				//금액 = 상품의 가격 * 수량
				int total = product.getUnitPrice() * product.getQuantity();
				sum = sum + total;
			%>
			<tr>
				<td><%=product.getProductId()%> - <%=product.getPname()%></td>
				<td><%=product.getUnitPrice()%></td>
				<td><%=product.getQuantity()%></td>
				<td><%=total%></td>
				<td><a href="./removeCart.jsp?id=<%=product.getProductId()%>" 
						class="badge badge-danger">삭제</a></td>
			</tr>
			<%
			}//end for
			%>
			<tr>
				<th></th><th></th><th>총액</th><th><%=sum%></th><th></th>
			</tr>
		</table>
		<a href="./products.jsp" class="btn btn-secondary">&laquo; 쇼핑 계속하기</a>
	</div>
	<hr />
</div>


<jsp:include page="footer.jsp" />
</body>
</html>


