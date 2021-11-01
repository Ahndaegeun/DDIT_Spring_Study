<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>상품편집(/guestbook/editProduct.jsp)</title>
<script type="text/javascript">
	function deleteConfirm(id){
		if(confirm("해당 상품을 삭제합니다!")==true){
			location.href="/product/deletePro?id="+id;
		}else{
			return;
		}
	}
</script>
</head>
<body>
<jsp:include page="menu.jsp" />
<div class="jumbotron">
	<div class="container">
		<h1 class="display-3">상품 편집</h1>
	</div>
</div>

<div class="container">
	<div class="row" align="center">
		<c:forEach items="${list}" var="item">
		<div class="col-md-4">
			<img src="../resources/images/${item.P_FILENAME}" style="width:100%;" />
			<h3>${item.P_NAME}</h3>
			<p>${item.P_DESCRIPTION}</p>
			<p>${item.P_UNITPRICE}원</p>
			<p>
				<c:if test="${edit=='update'}">
					<a href="/product/modifyView?id=${item.P_ID}" 
						class="btn btn-success" role="button">수정 &raquo;</a>
				</c:if>
				<c:if test="${edit=='delete'}">
					<a href="#" onclick="deleteConfirm('${item.P_ID}')" 
						class="btn btn-danger" role="button">삭제 &raquo;</a>
				</c:if>
			</p>
		</div>
		</c:forEach>
	</div>
</div>


<jsp:include page="footer.jsp" />
</body>
</html>



