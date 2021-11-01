<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>/guestbook/fileupload03.jsp</title>
</head>
<body>
<!-- 
Commons-fileUpload 패키지는 서버의 메모리상에서 파일 처리가 가능하도록 지원함
-->
<form action="fileupload03_process.jsp" method="post" enctype="multipart/form-data">
	<p>	파 일 : <input type="file" name="filename">
	<p>	<input type="submit" value="파일 올리기">
</form>

</body>
</html>





