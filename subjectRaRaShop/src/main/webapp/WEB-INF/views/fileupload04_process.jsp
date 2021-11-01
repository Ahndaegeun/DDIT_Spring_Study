<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.DiskFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>/guestbook/fileupload04_process.jsp</title>
</head>
<body>
<%
String path 
= "D:\\A_TeachingMaterial\\6.JspSpring\\jspServlet\\WebContent\\images";
DiskFileUpload upload = new DiskFileUpload();
//파일의 최대 크기
upload.setSizeMax(1000000);
//메모리에 저장할 최대 크기
upload.setSizeThreshold(4096);
//업로드될 위치
upload.setRepositoryPath(path);
//요청 파라미터를 upload객체로 전달받음
List items = upload.parseRequest(request);
//요청 파라미터를 Iterator 클래스로 변환
Iterator params = items.iterator();
while(params.hasNext()){
	FileItem item = (FileItem)params.next();
	if(item.isFormField()){	//요청 파라미터가 일반데이터..
		String name = item.getFieldName();
		String value = item.getString("UTF-8");
		out.println(name + " = " + value + "<br />");
	}else{//요청 파라미터가 파일이면..
		//요청파라미터의 이름
		String fileFieldName = item.getFieldName();
		//저장 파일의 이름
		String fileName = item.getName();
		//파일 콘텐츠 유형
		String contentType = item.getContentType();
		//경로의 마지막 역슬러시의 위치를 찾아서 + 1의 위치부터 끝 위치까지 가져오면 파일명만 추출
		fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
		//파일 크기
		long fileSize = item.getSize();
		
		File file = new File(path + "/" + fileName);
		item.write(file);
		
		out.println("-----------------------------------<br>");
		out.println("요청 파라미터 이름 : " + fileFieldName  + "<br>");
		out.println("저장 파일 이름 : " + fileName + "<br>");
		out.println("파일 콘텐츠 타입 : " + contentType + "<br>");
		out.println("파일 크기 : " + fileSize);
	}
}
%>
</body>
</html>






