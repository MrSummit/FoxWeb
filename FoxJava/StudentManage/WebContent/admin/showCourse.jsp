<%@include file="head.txt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="Common.*" %>
<jsp:useBean id="course" type="Index.Model.CourseModel" scope="session" />
	
	<%
		ResultSet rst=course.getResult();
	%>
	<div class="main">
		<div class="left">
		本学期的课程为:
		<table cellspacing="0" cellpadding="0">
				<tr>
					<td>课程编号</td>
					<td>课程名称</td><td>开始周</td><td>结束周</td>
					<td>上课时间</td>
					<td>课程开始</td><td>课程结束</td>
					<td>教师</td><td>地点</td>
				</tr>
			
			<%while(rst.next()){ %>
				<tr>
					<td><%=rst.getString("course_id") %></td>
					<td><%=rst.getString("course_name") %></td>
					<td>第<%=rst.getString("course_begin") %>周</td>
					<td>第<%=rst.getString("course_end") %>周</td>
					<td>周<%=rst.getString("course_day")%></td>
					<%String bms=rst.getString("lesson_begin");
					String ems=rst.getString("lesson_end");
					int bm=Integer.parseInt(bms);
					int em=Integer.parseInt(ems); 
					%>
					<td><%=bm/60%>:<%=bm%60%></td>
					<td><%=em/60%>:<%=em%60%></td>
					<td><%=rst.getString("teacher") %></td>
					<td><%=rst.getString("place") %></td>
				</tr>
			
			<%} %>
		</table>
		</div>
		<div class="right">
			
		</div>
	</div>
<%@include file="footer.txt" %>