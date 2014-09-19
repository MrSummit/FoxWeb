<%@include file="head.txt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="Common.*" %>
	<%
		ResultSet rst=(ResultSet)session.getAttribute("allatt");
		%>
	<div class="main">
		<div class="left">
		<h2>考勤记录</h2>
		<table cellspacing="0" cellpadding="0">
				<tr>
					<td>课程编号</td>
					<td>学生学号</td><td>上机时间</td><td>下机时间</td>
					<td>周数</td>
					<td>上机情况</td>
				</tr>
			
			<%while(rst.next()){ %>
				<tr>
					<td><%=rst.getString("course_id") %></td>
					<td><%=rst.getString("number") %></td>
					
					<%String bms=rst.getString("begin");
					String ems=rst.getString("end");
					int bm=Integer.parseInt(bms);
					int em=Integer.parseInt(ems); 
					%>
					<td><%=bm/60%>:<%=bm%60%></td>
					<td><%=em/60%>:<%=em%60%></td>
					<td><%=rst.getString("weak")%></td>
					<td><%=rst.getString("state")%></td>
				</tr>
			
			<%} %>
		</table>
		</div>
		<div class="right">
			
		</div>
	</div>
<%@include file="footer.txt" %>