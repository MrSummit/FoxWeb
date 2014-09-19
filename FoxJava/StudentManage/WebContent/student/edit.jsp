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
		<div class="left">
			<form action="../student">
				学 号 :<input type="text" value="<%=rst.getString(2)%>" name="number"></br>
				姓 名 :<input type="text" value="<%=rst.getString(3)%>" name="name"></br>
				性 别 :<input type="text" value="<%=rst.getString(4)%>" name="sex"></br>
				班 级 :<input type="text" value="<%=rst.getString(6)%>" name=
				"grade"></br>
				学 院 :<input type="text" value="<%=rst.getString(7)%>" name="college"></br>
				生源地:<input type="text" value="<%=rst.getString(10)%>" name="origin"></br>
				<input type="hidden" value="edit" name="action"><br/>
				<input type="submit" value="修改">
			</form>
		</div>
		<div class="right">
		</div>
	</div>
<%@include file="footer.txt" %>