<%@page import="jdbc.JdbcUtil"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	String productId = request.getParameter("id");
//Database 테이블로 update
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	 
	try{
		
		conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:ddit");
		String sql = "SELECT * FROM PRODUCT WHERE P_ID = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, productId);
		rs = pstmt.executeQuery();
		
		//id에 해당하는 상품이 있을때에만 delete 처리
		if(rs.next()){
			sql = "DELETE FROM PRODUCT WHERE P_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,productId );
			pstmt.executeUpdate();
		}else{//id에 해당하는 상품이 없을 때..
			response.sendRedirect("exceptionNoProductId.jsp");
		}
	}catch(SQLException e ){
		System.out.print("error");
		out.print(e.getMessage());
	}finally{
		JdbcUtil.close(rs);
		JdbcUtil.close(pstmt);
		JdbcUtil.close(conn);
	}
	response.sendRedirect("editProduct.jsp?edit=delete");	
%>





