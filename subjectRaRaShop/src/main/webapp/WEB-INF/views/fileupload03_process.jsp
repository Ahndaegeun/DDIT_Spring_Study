<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html; charset=utf-8"%>
<%@page import="org.apache.commons.fileupload.*"%>
<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<%!
private String getFolder(){
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
	String str = sdf.format(date);
	return str.replace("-", File.separator);
}
%>
<html>
<head>
<title>File Upload</title>
</head>
<body>
	<%
		String fileUploadPath 
		= "D:\\A_TeachingMaterial\\6.JspSpring\\jspServlet\\WebContent\\images";
		//파일 업로드를 위해 DiskFileUpload 클래스를 생성
		DiskFileUpload upload = new DiskFileUpload();
		//폼 페이지에서 전송된 요청 파라미터를 전달받도록 DiskFileUplad 객체 타입의 parseRequest() 작성
		List items = upload.parseRequest(request);
		//폼 페이지에서 전송된 요청 파라미터를 Iterator 클래스로 변환
		Iterator params = items.iterator();
		//폼 페이지에서 전송된 요청 파라미터가 없을 때까지 반복하도록 Iterator 객체 타입의 hasNext() 메소드 작성
		
		//날짜 폴더 생성 시작----------------
		File uploadPath = new File(fileUploadPath, getFolder());
		
		if(uploadPath.exists() == false){
			uploadPath.mkdirs();
		}
		//날짜 폴더 생성 끝----------------
		while (params.hasNext()) {
			FileItem fileItem = (FileItem) params.next();
			//폼 페이지에서 전송된 요청 파라미터가 파일이면
			if (!fileItem.isFormField()) {
				String fileName = fileItem.getName();
				fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
				
				//파일명 중복처리 시작----------------------------
				//유일한 128bit 랜덤 값을 구함
				UUID uuid = UUID.randomUUID();
				fileName = uuid.toString() + "_" + fileName;
				out.println("upload path : " + uploadPath + fileName);
				//파일명 중복처리 끝----------------------------
				//before : File file = new File(fileUploadPath + "/" + fileName);
				File file = new File(uploadPath, fileName);
				// 서버의 파일 저장 경로에 업로드 파일을 저장
				fileItem.write(file);
			}
		}
	%>
</body>
</html>