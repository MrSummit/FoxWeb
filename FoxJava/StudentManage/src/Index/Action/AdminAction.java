package Index.Action;
import Base.Date.DateBase;
import Index.Date.*;
import Index.Model.*;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.catalina.connector.Request;
import org.apache.catalina.deploy.LoginConfig;
import org.apache.jasper.tagplugins.jstl.core.Out;

import com.sun.crypto.provider.RSACipher;

public class AdminAction extends HttpServlet {
	StudentModel student;
	PreparedStatement sql;
	HttpSession session;
	StudentDate stuDate;
	ResultSet result,rs1;
	String user;
	String pass;
	String action="";
	String id;
	Connection con;
	PrintWriter out;
	StringBuffer classInfo;
	AdminDate admin;
	String class_id,class_name;
	
	private static final long serialVersionUID = 1L;

    public AdminAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession(true);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		action=request.getParameter("action");
		session.setAttribute("stuInfo", "-1");
		session.setAttribute("graInfo", "0");
		session.setAttribute("course_add", "0");
		session.setAttribute("corInfo", "-1");
		DateBase date=new DateBase();
		date.connect();
		admin=new AdminDate();
		out=response.getWriter();
		Connection con;
		Statement sql;
		ResultSet rs;
		
		try{	Class.forName("com.mysql.jdbc.Driver");
		}
		catch(Exception e){
			out.print(e);
		}
		if(action.equals("1")){
		try {
			 ResultSet gra=admin.action1();
			session.setAttribute("allgrade", gra);
			response.sendRedirect("./admin/grade.jsp");
		} catch (Exception e) {
			
		}
		}
		else if(action.equals("2")){
			String classid=request.getParameter("class_id");
			rs1=admin.action22(classid);
			result=admin.action2(classid);
			try{
				if(rs1.next()){
					session.setAttribute("graInfo", "1");
					session.setAttribute("rst", result);
					session.setAttribute("rst2", rs1);
				}else{
					session.setAttribute("graInfo", "0");
				}
				response.sendRedirect("./admin/grade.jsp");
			}catch(Exception e){
				
			}
			
			
			//classInfo.append(class_id);
			//session.setAttribute("allstudent", classInfo);
			//response.sendRedirect("./admin/showAllstudent.jsp");
		}else if(action.equals("3")){
			class_id=request.getParameter("class_id");
			class_name=toS(request.getParameter("class_name"));
			String newClass=request.getParameter("new_class_id");
			int m=admin.action3(class_id, class_name);
			if(m!=0){
				response.sendRedirect("./admin/grade.jsp");
			}
			
		}
		else if(action.equals("4")){
			class_id=request.getParameter("class_id");
			class_name=toS(request.getParameter("class_name"));
			int m=admin.action4(class_id, class_name);
			if(m!=0){
				response.sendRedirect("./admin/grade.jsp");
			}
		}else if(action.equals("5")){
			String number=request.getParameter("number");
			ResultSet rst=admin.action5(number);
			try {
				if(rst.next()){
					session.setAttribute("stuInfo", "1");
					session.setAttribute("rst", rst);
				}else{
					session.setAttribute("stuInfo", "0");
				}
				response.sendRedirect("./admin/student.jsp");
			} catch (Exception e) {
				// TODO: handle exception
			}	
		}
		else if(action.equals("6")){
			String user,name,class_id,sex,orgin,year;
			String id=request.getParameter("id");
			user=toS(request.getParameter("number"));
			name=toS(request.getParameter("name"));
			class_id=request.getParameter("class_id");
			sex=toS(request.getParameter("sex"));
			orgin=toS(request.getParameter("orgin"));
			year=request.getParameter("year");
			int m=0;
			//m=admin.action6(user,name,class_id,sex,orgin,year,id);
			String uri="jdbc:mysql://localhost/studentmanage?useUnicode=true&characterEncoding=UTF-8";
			try{
				con=DriverManager.getConnection(uri,"root","");
				Statement sql123=con.createStatement();
				String s="UPDATE student SET number='"+user+"'"+",name='"+name+"',sex='"+sex
						+"',class_id="+class_id+",orgin='"+orgin+"' WHERE id="+id;
				out.println(s);
				sql123=con.createStatement();
				m=sql123.executeUpdate(s);
			}catch(Exception e)
			{
				out.print(e);
			}
			response.sendRedirect("./admin/student.jsp");
			//response.sendRedirect("./admin/student.jsp");
		}else if(action.equals("7")){
			String user,name,class_id,sex,orgin,year;
			String id=request.getParameter("id");
			user=request.getParameter("number");
			name=toS(request.getParameter("name"));
			class_id=toS(request.getParameter("class_id"));
			sex=toS(request.getParameter("sex"));
			orgin=toS(request.getParameter("orgin"));
			year=toS(request.getParameter("year"));
			String password=request.getParameter("password");
			try {
				String uri="jdbc:mysql://localhost/studentmanage?useUnicode=true&characterEncoding=UTF-8";
				con=DriverManager.getConnection(uri,"root","");
				sql=con.createStatement();
				String s="INSERT INTO student(name,number,password,class_id,sex,orgin,year,college,power,entrollmentTime"
						+ ")VALUES ('"
						+name+"','"+user+"','"+password+"',"+class_id+",'"+sex+"','"+orgin+"',"+year+",'computer',1,1346465164)";
				out.println(s);
				int m=sql.executeUpdate(s);
				if(m!=0){
					response.sendRedirect("./admin/student.jsp");
				}
			} catch (Exception e) {
				out.print(e);
			}
			
			int f=admin.action7(user, name, class_id, sex, orgin, year);
			out.print(f);
		}else if(action.equals("8")){
			CourseModel course=new CourseModel();
			session.setAttribute("course",course);
			result=admin.action8();
			//result=corDate.allCourse(class_id);
			session.setAttribute("courseIn", result);
			response.sendRedirect("./admin/course.jsp");	
		}else if(action.equals("18")){
			CourseModel course=new CourseModel();
			session.setAttribute("course",course);
			String cid=request.getParameter("course_id");
			result=admin.action18(cid);
			try {
				if(result.next()){
					session.setAttribute("corInfo", "1");
					session.setAttribute("corRst", result);
				}else{
					session.setAttribute("corInfo", "0");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}	
			//out.println(cid);
			//out.println(result);
			//out.println(cid);
			//result=corDate.allCourse(class_id);
			response.sendRedirect("./admin/course.jsp");	
		}
		else if(action.equals("9")){
			//date.connect();
			
			try{
				String uri="jdbc:mysql://localhost/studentmanage?useUnicode=true&characterEncoding=UTF-8";
				con=DriverManager.getConnection(uri,"root","");
				sql=con.createStatement();
			String course_id,course_begin,course_end,lesson_begin,lesson_end,course_day,place,teacher,course_name;
			course_id=request.getParameter("course_id");
			course_begin=toS(request.getParameter("course_begin"));
			course_end=toS(request.getParameter("course_end"));
			lesson_begin=toS(request.getParameter("lesson_begin"));
			lesson_end=toS(request.getParameter("lesson_end"));
			course_day=toS(request.getParameter("course_day"));
			course_name=toS(request.getParameter("course_name"));
			place=toS(request.getParameter("place"));
			teacher=toS(request.getParameter("teacher"));
			class_id=toS(request.getParameter("class_id"));
			String s="INSERT INTO course(course_name,course_id,class_id,course_begin,course_end,lesson_begin,lesson_end,course_day,teacher,place)VALUES ('"
					+course_name+"','"
					+course_id+"',"+class_id+","+course_begin+","+course_end+","+lesson_begin+","+lesson_end+","+course_day+",'"
					+teacher+"','"+place+"')";
			int m=sql.executeUpdate(s);
			if(m!=0){
				session.setAttribute("course_add", "1");
			}else{
				session.setAttribute("course_add", "0");
			}
			response.sendRedirect("./admin/course.jsp");
			
			} catch (Exception e) {
				out.print(e);
			}
			
		}else if(action.equals("19")){
			//date.connect();
			
			try{
				String uri="jdbc:mysql://localhost/studentmanage?useUnicode=true&characterEncoding=UTF-8";
				con=DriverManager.getConnection(uri,"root","");
				sql=con.createStatement();
			String course_id,course_begin,course_end,lesson_begin,lesson_end,course_day,place,teacher,course_name;
			course_id=request.getParameter("course_id");
			course_begin=toS(request.getParameter("course_begin"));
			course_end=toS(request.getParameter("course_end"));
			lesson_begin=toS(request.getParameter("lesson_begin"));
			lesson_end=toS(request.getParameter("lesson_end"));
			course_day=toS(request.getParameter("course_day"));
			course_name=toS(request.getParameter("course_name"));
			place=toS(request.getParameter("place"));
			teacher=toS(request.getParameter("teacher"));
			class_id=toS(request.getParameter("class_id"));
			String st="UPDATE course SET course_name='"+course_name+"',class_id="+
					class_id+",course_begin="+course_begin+",course_end="+course_end+",lesson_begin="+lesson_begin+
					",lesson_end="+lesson_end+",lesson_end="+course_day+",teacher='"+teacher+"',place='"+place+"' WHERE course_id='"
					+course_id+"'";
			
			int m=sql.executeUpdate(st);
			
			out.println(m);
			if(m!=0){
				session.setAttribute("course_add", "1");
			}else{
				session.setAttribute("course_add", "0");
			}
			response.sendRedirect("./admin/course.jsp");
			
			} catch (Exception e) {
				out.print(e);
			}
			
		}
		else if(action.equals("20")){
			user=request.getParameter("number");
			admin.action20(user);
			response.sendRedirect("./admin/student.jsp");
		}else if(action.equals("15")){
			user=request.getParameter("class_id");
			admin.action15(user);
			response.sendRedirect("./admin/grade.jsp");
		}else if(action.equals("30")){
			try {
				 ResultSet stu=admin.action30();
				 session.setAttribute("allstu", stu);
				 out.print(stu);
				 response.sendRedirect("./admin/student.jsp");
			} catch (Exception e) {
				
			}
		}
		else if(action.equals("33")){
			try {
				 ResultSet stu=admin.action33();
				 session.setAttribute("allatt", stu);
			} catch (Exception e) {
				
			}
			 response.sendRedirect("./admin/attendance.jsp");
		}else if(action.equals("40")){
			try{
				String cid=request.getParameter("course_id");
				admin.action40(cid);
				response.sendRedirect("./admin/course.jsp");
			}catch(Exception e){
				
			}
			}
		}
		
	


	public String toS(String s){
		String str;
		try{
			str = new String(s.getBytes("ISO-8859-1"),"utf-8");
		}
		catch(Exception e){str="";}
		return str;
	}
}