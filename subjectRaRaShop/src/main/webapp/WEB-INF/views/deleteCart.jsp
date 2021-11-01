<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
//요청 파라미터 cartId를 전송받음
String id = request.getParameter("cartId");
//전송된 cartId가 없으면..
if(id==null||id.trim().equals("")){
	response.sendRedirect("cart.jsp");
}

//cartId가 있다면.. session(장바구니도 담겨져 있음(cartlist))이 있다면
//session을 비움(장바구니도 비워짐)
session.invalidate();

response.sendRedirect("cart.jsp");
%>
