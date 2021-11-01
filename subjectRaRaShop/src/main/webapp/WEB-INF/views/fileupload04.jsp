<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>/guestbook/fileupload04.jsp</title>
</head>
<body>
<form name="fileForm" method="post" enctype="multipart/form-data" 
	action="fileupload04_process.jsp">
	<p>이름 : <input type="text" name="name" /></p>
	<p>제목 : <input type="text" name="subject" /></p>
	<p>파일 : <input type="file" name="filename" /></p>
	<p><input type="submit" value="파일올리기" /></p>	
</form>
</body>
</html>