<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	//한글 처리를 위해 인코딩 유형 설정
	request.setCharacterEncoding("UTF-8");
	//폼 페이지에서 전송된 파라미터 목록을 통해 쿠키로 생성
	Cookie cartId = new Cookie("Shipping_cartId",
			URLEncoder.encode(request.getParameter("cartId"),"UTF-8"));
	Cookie name = new Cookie("Shipping_name",
			URLEncoder.encode(request.getParameter("name"),"UTF-8"));
	Cookie shippingDate = new Cookie("Shipping_shippingDate",
			URLEncoder.encode(request.getParameter("shippingDate"),"UTF-8"));
	Cookie country = new Cookie("Shipping_country",
			URLEncoder.encode(request.getParameter("country"),"UTF-8"));
	Cookie zipCode = new Cookie("Shipping_zipCode",
			URLEncoder.encode(request.getParameter("zipCode"),"UTF-8"));
	Cookie addressName = new Cookie("Shipping_addressName",
			URLEncoder.encode(request.getParameter("addressName"),"UTF-8"));
	//생성한 쿠키의 유효 기간을 24시간으로 설정(초단위)
	cartId.setMaxAge(24 * 60 *60);
	name.setMaxAge(24 * 60 *60);
	zipCode.setMaxAge(24 * 60 *60);
	country.setMaxAge(24 * 60 *60);
	addressName.setMaxAge(24 * 60 *60);
	
	//쿠키 등록
	response.addCookie(cartId);
	response.addCookie(name);
	response.addCookie(shippingDate);
	response.addCookie(country);
	response.addCookie(zipCode);
	response.addCookie(addressName);
	
	response.sendRedirect("orderConfirmation.jsp");
	
	//test : 쿠키객체, name : 쿠키이름, value : 쿠키값
	Cookie test = new Cookie("name","value");
	//쿠키의 생성은 서버에서 생성됨. 따라서, response기본 객체에 저장되어 클라이언트로 리턴됨
	//쿠키 저장소에 해당 쿠키 객체가 저장되고, 클라이언트가 서버에 요청할 때마다 쿠키도 함께 보냄
	response.addCookie(test);
	//쿠키이름
	test.getName();
	//쿠키값
	test.getValue();
	
%>
