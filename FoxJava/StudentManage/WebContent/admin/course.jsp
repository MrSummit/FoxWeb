<%@include file="head.txt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="Common.*" %>
	<div class="main">
		<h2><a href="../admin?action=8">显示所有课程</a></h2>
		<br>
		<%
		ResultSet rst=(ResultSet)session.getAttribute("courseIn");
		%>
		<%if(rst!=null){ %>
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
	<%}%>	
		
		<c:if test="${sessionScope.course_add=='1'}">
			<br>增加成功!
			<%session.setAttribute("course_add", "0"); %>
		</c:if>
		<form action="../admin">
			请输入要修改的课程编号
			<input type="text" name="course_id" required>
			<input type="hidden" value="18" name="action">
			<input type="submit" value="查询">
		</form>
		<c:if test="${sessionScope.corInfo=='1'}">
			<%ResultSet cor=(ResultSet)session.getAttribute("corRst"); %>
			<form action="../admin">
			<h3>请输入要修改的内容</h3><br>
			<input type="hidden" name="course_id" value="<%=cor.getString("course_id")%>" required>
			课程名字<input type="text" name="course_name" value="<%=cor.getString("course_name")%>" required><br>
			开始 周 <input type="text" name="course_begin" value="<%=cor.getString("course_begin")%>" required><br>
			结束 周 <input type="text" name="course_end" value="<%=cor.getString("course_end")%>" required><br>
			开始时刻<input type="text" name="lesson_begin" value="<%=cor.getString("lesson_end")%>" required><br>
			结束时刻<input type="text" name="lesson_end" value="<%=cor.getString("lesson_end")%>" required><br>
			上课班级<input type="text" name="class_id" value="<%=cor.getString("class_id")%>" required><br>
			上 课周 <input type="text" name="course_day" value="<%=cor.getString("course_day")%>" required><br>
			上课教师<input type="text" name="teacher" value="<%=cor.getString("teacher")%>" required><br>
			上课地点<input type="text" name="place" value="<%=cor.getString("place")%>"><br>
			<input type="hidden" value="19" name="action">
			<input type="submit" value="修改">
		</form>
		</c:if>
		<h2>增加课程</h2>
		<form action="../admin">
			课程名字<input type="text" name="course_name" required><br>
			课程 id <input type="text" name="course_id" required><br>
			开始 周 <input type="text" name="course_begin" required><br>
			结束 周 <input type="text" name="course_end" required><br>
			开始时刻<input type="text" name="lesson_begin" required><br>
			结束时刻<input type="text" name="lesson_end" required><br>
			上课班级<input type="text" name="class_id" required><br>
			上 课周 <input type="text" name="course_day" required><br>
			上课教师<input type="text" name="teacher" required><br>
			上课地点<input type="text" name="place" required><br>
			<input type="hidden" value="9" name="action">
			<input type="submit" value="增加">
		</form>
		<form action="../admin">
			课程编号 <input type="text" name="course_id" required><br>
			<input type="hidden" value="40" name="action">
			<input type="submit" value="删除">
		</form>
	</div>	
<%@include file="footer.txt" %>