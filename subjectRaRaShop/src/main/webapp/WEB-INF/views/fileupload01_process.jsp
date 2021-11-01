<%@page import="java.io.File"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
//파일 최대크기 : 5MB
//DefaultFileRenamePolicy : 서버에 동일 파일이 있으면 전송된 파일명 뒤에 숫자를 덧붙여
//					중복되지 않도록 함
MultipartRequest multi = 
		new MultipartRequest(request,
				"D:\\A_TeachingMaterial\\6.JspSpring\\jspServlet\\WebContent\\images",
				5 * 1024 * 1024,
				"UTF-8",
				new DefaultFileRenamePolicy()
				);
//폼 페이지에서 전송된 요청 파라미터를 받음
Enumeration params = multi.getParameterNames();
while(params.hasMoreElements()){
	//요청 파라미터 이름
	String name = (String)params.nextElement();
	String value = multi.getParameter(name);
	out.println(name + " = " + value + "<br />");
}
out.print("---------------------<br />");
//요청 파라미터 중 파일을 전달받도록 MultipartRequest 
//객체 타입의 getFileNames()메소드 사용
Enumeration files = multi.getFileNames();
while(files.hasMoreElements()){
	//name : input type="file" name="filename"의 filename
	String name = (String)files.nextElement();
	//저장 파일 이름
	String filename = multi.getFilesystemName(name);
	//실제 파일 이름
	String original = multi.getOriginalFileName(name);
	//파일 콘텐츠 타입
	String type = multi.getContentType(name);
	//파일 객체
	File file = multi.getFile(name);
	out.println("요청 파라미터 이름 : " + name + "<br />");
	out.println("저장 파일 이름 : " + filename + "<br />");
	out.println("실제 파일 이름 : " + original + "<br />");
	out.println("파일 콘텐츠 타입 : " + type + "<br />");
	if(file != null){
		out.println("파일 크기 : " + file.length());
		out.println("<br />");
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<title>/guestbook/fileupload01_process.jsp</title>
</head>
<body>

</body>
</html>