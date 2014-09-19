<%@include file="head.txt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="Common.*" %>
	<jsp:useBean id="attendance" type="Index.Model.AttendanceModel" scope="session" />
	
	<%
		ResultSet rst=attendance.getResult();
		
	%>

	<div class="main">
	<h2>公告</h2>
	<h3>每次上机系统会自动记录上机时间，下机后不可再次上机</h3>
	<%if(rst!=null) {%>
		<%ResultSet ff=(ResultSet)session.getAttribute("att_class"); %>
		<%if(ff!=null){ %>
		<br>
		<h2>当前进行的课程:</h2>
		<h3>${sessionScope.course_name}<br></h3>
		<h5>课程开始时间:<%=ff.getInt("lesson_begin")/60 %>:<%=ff.getInt("lesson_begin")%60 %></h5>
		<h5>课程结束时间:<%=ff.getInt("lesson_end")/60 %>:<%=ff.getInt("lesson_end")%60 %></h5>
		<%} %>
		<h3>${sessionScope.stateInfo}</h3>
	<%} %>

			<c:if test="${sessionScope.state=='0'}">
			<h3><a href="../attendance?action=begin">上机</a></h3>
			</c:if>	
			<c:if test="${sessionScope.state=='1'}">
			<h3><a href="../attendance?action=end">下机</a></h3>
			</c:if>	
	<jsp:useBean id="student" type="Index.Model.StudentModel" scope="session" />
	<%
		ResultSet f=(ResultSet)session.getAttribute("attenInfo");
	%>
	<br><br>
	<h2>考勤记录</h2>
	<table cellspacing="0" cellpadding="0">
	<td>课程</td><td>周数</td><td>上机时间</td><td>下机机时间</td>
	<td>状态</td>
	</tr>
	<%while(f.next()){ %>
	<tr>
		<td><%=f.getString("course_id") %></td>
		<td><%=f.getString("weak") %></td>
		<%int m=f.getInt("begin"); %>
		<td><%=m/60 %>:<%=m%60 %></td>
		<%m=f.getInt("end"); %>
		<td><%=m/60 %>:<%=m%60 %></td>
		<td><%=f.getString("state") %></td>
	</tr><br>
	<%} %>
	</table>
	</div>
	
<%@include file="footer.txt" %>