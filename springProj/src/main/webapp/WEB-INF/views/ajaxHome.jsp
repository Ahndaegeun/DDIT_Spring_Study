<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/resources/js/jquery-3.6.0.js"></script>
</head>
<body>

<p><input type="text" id="boardNo" name="boardNo" value="1"></p>
<p><input type="text" id="title" name="title" value="title"></p>
<p><textarea rows="10" cols="10" name="content" id="content">TestContent1111122222233333333</textarea></p>
<p><input type="text" id="writer" name="writer" value="개똥이"></p>
<p><input type="button" id="putBtn" value="send"></p>





<script type="text/javascript">
	const boardNo = document.querySelector('#boardNo').value
	const title = document.querySelector('#title').value
	const content = document.querySelector('#content').value
	const writer = document.querySelector('#writer').value
	const putBtn = document.querySelector('#putBtn')
	
	const obj = {
		no : boardNo,
		tit : title,
		cont : content,
		wri : writer
	}
	
	putBtn.addEventListener('click', () => {
		$.ajax({
			type: "post",
			url: "/board/" + boardNo,
			data: JSON.stringify(obj),
			success: function(res) {
				console.log(res)
			},
			error: function(e) {
				console.log(e)
			},
			contentType: "application/json;charset=utf-8"
		})		
	})
	
</script>
</body>
</html>