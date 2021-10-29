<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>HOME</h1>

<h2>controller response practice</h2>
1.return void<br>
<a href="/goHome0101">요청 경로와 동일한 뷰1</a> <br>
<a href="/goHome0102">요청 경로와 동일한 뷰2</a>
<hr>
2. return String<br>
<a href="/goHome0201">반환값이 뷰를 가리킴1</a><br>
반환값이 goHome0202이고, 요청이 /sub/goHome0202<br>
<a href="/sub/goHome0202">반환값이 뷰를 가리킴2</a> 
<hr>
3. 반환값이 redirect:로 시작하면 리다이렉트 방식으로 처리<br>
<a href="goHome0204">리다이렉트 방식1</a>
</body>
</html>