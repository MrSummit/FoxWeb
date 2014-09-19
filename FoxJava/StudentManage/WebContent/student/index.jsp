<%@include file="head.txt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="Common.*" %>
	<div class="main">
	<jsp:useBean id="student" type="Index.Model.StudentModel" scope="session" />
			欢迎你，${sessionScope.user}
	</div>	
<%@include file="footer.txt" %>