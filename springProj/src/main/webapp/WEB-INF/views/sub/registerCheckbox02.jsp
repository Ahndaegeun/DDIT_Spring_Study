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
<form action="/board/registerCheckbox" method="post">
	<label>ID : <input type="text" name="memId" value="a001"></label><br>
	<label>Name : <input type="text" name="memName" value="김은대"></label><br>
	<label>PostCode : <input type="text" name="addressVO.postCode" value="11111"></label><br>
	<label>Location : <input type="text" name="addressVO.location" value="서울 강남구"></label>
	
	
	<h2>Hobby List</h2>
	<label><input type="checkbox" name="hobbyList" value="Sports">Sports</label>
	<label><input type="checkbox" name="hobbyList" value="Music">Music</label>
	<label><input type="checkbox" name="hobbyList" value="Movie">Movie</label><br>
	
	<hr>
	
	<input id="btnAdd" type="button" value="+">&nbsp;
	<input id="btnDel" type="button" value="-">
	<div id="divCard">
	<p class="zero">
		카드 1 - 번호 : <input type="text" name="cardList[0].no" value=""><br>	
		카드 1 - 유효연월 : <input type="text" name="cardList[0].validMonth" value=""><br>
	</p>	
	</div>	
	
	<input type="submit" value="submit">
</form>	
	
<script type="text/javascript" src="/resources/js/jquery-3.6.0.js"></script>
<script type="text/javascript">
$(function() {
	let cnt = 1
	$('#btnAdd').on('click', function() {
		cnt++
		const clone = `<p class="zero">
				카드 ` + cnt + ` - 번호 : <input type="text" name="cardList[` + cnt + `].no" value=""><br>
				카드 ` + cnt + ` - 유효연월 : <input type="text" name="cardList[` + cnt + `].validMonth" value=""><br>
			</p>`
		$('#divCard').append($(clone))
	})
	
	$('#btnDel').on('click', function() {
		$('.zero').last().remove()
		cnt--
	})
	
})
</script>
</body>
</html>