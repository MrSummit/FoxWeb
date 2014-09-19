<%@include file="head.txt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="Common.*" %>

	<div class="main">
		<br>
		<h2><a href="../admin?action=1">查看所有班级信息</a></h2><br>
		<%ResultSet gra=(ResultSet)session.getAttribute("allgrade");
		%>
		<%if(gra!=null) {%>
		<h3>点击可查看详细信息</h3>
		<%while(gra.next()){ %>
			<form action="../admin">
			<%String cid=gra.getString("class_id");
			String cname=gra.getString("name");
			%>
			<input type="hidden" name="class_id" value="<%=cid %>">
			<input type="hidden" value="2" name="action">
			<input type="submit" value="<%=cname %>">
		</form>
		<%} }%>
		<c:if test="${sessionScope.graInfo=='1'}">
			<%ResultSet rst=(ResultSet)session.getAttribute("rst");
			ResultSet rs1=(ResultSet)session.getAttribute("rst2");
			%>
			班级编号:<%=rs1.getString("class_id")%><br>
			班级:<%=rs1.getString("name") %>
			<table>
				
				<tr><td>学号</td><td>姓名</td></tr>
				<%while(rst.next()){%>
					<tr><td><%=rst.getString("number")%></td><td><%=rst.getString("name")%></td></tr>
				<%}%>
				<%session.setAttribute("graInfo", "0"); %>
			</table>
			
		</c:if>
		<form action="../admin">
			原班级编号<input type="text" name="class_id" required><br>
			班级名称 <input type="text" name="class_name" required><br>
			班级编号 <input type="text" name="new_class_id" required><br>
			<input type="hidden" value="3" name="action">
			<input type="submit" value="修改"><br>
		</form><br>
		<form action="../admin">
			班级名称 <input type="text" name="class_name" required><br>
			班级编号 <input type="text" name="class_id" required><br>
			<input type="hidden" value="4" name="action">
			<input type="submit" value="增加"><br>
		</form><br>
		<form action="../admin">
			班级编号 <input type="text" name="class_id" required><br>
			<input type="hidden" value="15" name="action">
			<input type="submit" value="删除">
		</form>
	</div>	
<%@include file="footer.txt" %>