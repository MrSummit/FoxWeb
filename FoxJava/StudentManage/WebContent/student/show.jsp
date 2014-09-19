<%@include file="head.txt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="Common.*" %>
	<jsp:useBean id="student" type="Index.Model.StudentModel" scope="session" />
	<%
		ResultSet rst=student.getResult();
	%>
	<div class="main">
		
			学 号 :<%=rst.getString(2)%></br>		
			姓 名 :<%=rst.getString(3)%></br>
			性 别 :<%=rst.getString(4)%></br>
			班 级 :<%=rst.getString(6)%></br>
			学 院 :<%=rst.getString(7)%></br>
			入学年份:<%=TimeCommon.toTime(rst.getString(8),"yyyy年MM月dd日")%></br>
			生源地:<%=rst.getString(10)%></br>
			<form action="../student">
				<input type="submit" value="修改密码">
				<input type="text" name="password" required>
				<input type="hidden" value="123" name="action">
				<input type="hidden" value="<%=rst.getString(1)%>" name="userId">
			</form>
	</div>
<%@include file="footer.txt" %>