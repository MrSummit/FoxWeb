<%@include file="head.txt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="Common.*" %>
	<div class="main">
		<br>
		<h2><a href="../admin?action=30">查看所有学生信息</a></h2>
		<br>
		<%ResultSet stu=(ResultSet)session.getAttribute("allstu");
		%>
		<%if(stu!=null) {%>
		<h3>点击学生姓名可查看详细信息</h3>
		<table>
		<tr>
    		<th>学号</th>
    		<th>姓名</th>
    		<th>班级</th>
 		 </tr>
		<%while(stu.next()){ %>
  		<tr>
  			<%String number=stu.getString("number");
				String name=stu.getString("name");
			%>
    		<td><%=number%>
    		</td>
    		<td>
				<form action="../admin">
				
				<input type="hidden" name="number" value="<%=number %>">
				<input type="hidden" value="5" name="action">
				<input type="submit" value="<%=name %>">
				</form>
    		</td>
    		<td><%=stu.getString("class_id") %></td>
  		</tr>	
		<%} }%>
		<c:if test="${sessionScope.stuInfo=='1'}">
			<%ResultSet rst=(ResultSet)session.getAttribute("rst"); %>
			<form action="../admin">
			姓名:  <input type="text" name="name" value="<%=rst.getString("name")%>" required><br>
			学号:  <input type="text" name="number" value="<%=rst.getString("number")%>" required><br>  
			班级:  <input type="text" name="class_id" value="<%=rst.getString("class_id")%>" required><br>
			性别:  <input type="text" name="sex" value="<%=rst.getString("sex")%>" required><br>
			生源地<input type="text" name="orgin" value="<%=rst.getString("orgin")%>" required><br>
			学年  :<input type="text" name="year" value="<%=rst.getString("year")%>" required><br>
			<input type="hidden" name="id" value="<%=rst.getString("id")%>"><br>
			<input type="hidden" name="action" value="6"> 
			<input type="submit" value="修改">
		</form>
		</c:if>
		<br>
		</table>
		<form action="../admin">
			请输入要查询的学生学号
			<input type="text" name="number" required>
			<input type="hidden" value="5" name="action">
			<input type="submit" value="查询">
		</form>
		<br>
		<form action="../admin">
			姓名:  <input type="text" name="name" required><br>
			学号:  <input type="text" name="number" required><br>
			密码:  <input type="text" name="password" required><br>
			班级:  <input type="text" name="class_id" required><br>
			性别:  <input type="text" name="sex" required><br>
			生源地<input type="text" name="orgin" required><br>
			学年  :<input type="text" name="year" required><br>
			<input type="hidden" name="action" value="7"> 
			<input type="submit" value="增加">
		</form>
		<form action="../admin">
			学号 <input type="text" name="number" required><br>
			<input type="hidden" value="20" name="action">
			<input type="submit" value="删除">
		</form>
	</div>	
<%@include file="footer.txt" %>