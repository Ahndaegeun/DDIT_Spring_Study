<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>상품 상세 정보</title>
<script type="text/javascript">
	//장바구니에 등록하기 위한 핸들러 함수
	function addToCart(){
		if(confirm("상품을 장바구니에 추가하시겠습니까?")){
			//폼 문의 action 속성 값을 실행
			document.addForm.submit();
		}else{
			document.addForm.reset();
		}
	}
</script>
</head>
<body>
<jsp:include page="menu.jsp" />
<div class="jumbotron">
	<div class="container">
		<h1 class="display-3">상품 정보</h1>
	</div>
	
	<div class="container">
		<div class="row">
			<div class="col-md-5">
				<img src='../resources/images/${item.P_FILENAME}' style="width:100%;" />
			</div>
			<div class="col-md-6">
				<h3>${item.P_NAME}</h3>
				<p>${item.P_DESCRIPTION}</p>
				<p><b>상품 코드 : </b><span class="badge badge-danger">${item.P_ID}</span></p>
				<p><b>제조사 : </b>${item.P_MANUFACTURER}</p>
				<p><b>분류 : </b>${item.P_CATEGORY}</p>
				<p><b>재고 수 : </b> <fmt:formatNumber value="${item.P_UNITSINSTOCK}" pattern="#,###" /></p>
				<h4><fmt:formatNumber value="${item.P_UNITPRICE}" pattern="#,###" />원</h4>
				
				<p>
					<form name="addForm" action="/product/addCart?id=${item.P_ID}" method="post">
						<a href="#" class="btn btn-info" onclick="addToCart()">상품 주문 &raquo;</a>
						<a href="/product/showCart" class="btn btn-warning">장바구니 &raquo;</a>
						<a href="/product/list" class="btn btn-secondary">상품 목록 &raquo;</a>
					</form>
				</p>
			</div>
		</div>
	</div>
</div>
<jsp:include page="footer.jsp" />
</body>
</html>




