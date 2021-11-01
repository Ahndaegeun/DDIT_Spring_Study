<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
<script src="/js/jquery-3.6.0.js"></script>
<script src="/js/jquery-ui.js"></script>
<link rel="stylesheet" href="/css/jquery-ui.css" />
<title>배송 정보</title>
<script type="text/javascript">
	$(function(){
		$("#datepicker").datepicker({dateFormat:'yy/mm/dd'});
	});
	
	function openHomeSearch(){
		//다음 우편번호 검색
		new daum.Postcode({
			oncomplete:function(data){
				$("[name='zipCode']").val(data.zonecode);
				$("[name='addressName']").val(data.address);
			}
		}).open();
	}
</script>
</head>
<body>
<jsp:include page="menu.jsp" />
<div class="jumbotron">
	<div class="container">
		<h1 class="display-3">배송 정보</h1>
	</div>
</div>
<div class="container">
	<form action="./processShippingInfo.jsp" class="form-horizontal"
		method="post">
		<input type="hidden" name="cartId" 
			value="<%=request.getParameter("cartId") %>" />
		<div class="form-group row">
			<label class="col-sm-2">성명</label>
			<div class="col-sm-3">
				<input name="name" type="text" class="form-control" required />
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2">배송일</label>
			<div class="col-sm-3">
				<input name="shippingDate" id="datepicker" type="text" 
					class="form-control" required />(yyyy-mm-dd)
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2">국가명</label>
			<div class="col-sm-3">
				<input name="country" type="text" 
					class="form-control" required />
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2">우편번호</label>
			<div class="col-sm-3">
				<input name="zipCode" type="text" 
					class="form-control" required />
				<input type="button" class="btn btn-primary" value="검색" 
					onclick="openHomeSearch();" />
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2">주소</label>
			<div class="col-sm-5">
				<input name="addressName" type="text" 
					class="form-control" required />
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-offset-2 col-sm-10">
				<a href="./cart.jsp?cartId=<%=request.getParameter("cartId")%>"
				 class="btn btn-secondary" role="button">이전</a>
				<input type="submit" class="btn btn-primary" value="등록" />
				<a href="./checkOutCancelld.jsp" class="btn btn-secondary"
					role="button">취소</a>
			</label>
		</div>
	</form>
</div>


<jsp:include page="footer.jsp" />
</body>
</html>





