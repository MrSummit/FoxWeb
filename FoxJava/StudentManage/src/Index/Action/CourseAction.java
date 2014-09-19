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

import com.mysql.fabric.Response;
import com.sun.crypto.provider.RSACipher;

public class CourseAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String course_name,course_begin,course_end;
	String class_id,lesson_begin,lesson_end,teacher;
	String course_date,place,action="";
	ResultSet result;
	CourseModel course;
	PreparedStatement sql;
	HttpSession session;
	CourseDate corDate;
	Connection con;
	PrintWriter out;
    public CourseAction() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession(true);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		out=response.getWriter();
		course=new CourseModel();
		corDate=new CourseDate();
		StringBuffer str=new StringBuffer();
		session.setAttribute("course",course);
		try{
			action=request.getParameter("action");
		//学生查询
		//显示所有课表信息
		String course_id;
		class_id=(String)session.getAttribute("class_id");
		result=corDate.allCourse(class_id);
		//result=corDate.allCourse(class_id);
		course.setResult(result);
		response.sendRedirect("./student/course.jsp");	
		}catch(Exception e){
			
		}
	}

}
