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
import org.apache.el.lang.ELSupport;
import org.apache.jasper.tagplugins.jstl.core.Out;

import com.sun.crypto.provider.RSACipher;

public class StudentAction extends HttpServlet {
	StudentModel student;
	PreparedStatement sql;
	HttpSession session;
	StudentDate stuDate;
	ResultSet result;
	String user;
	String pass;
	String name,sex;
	String class_id,entrollmentTime,orgin,college,number;
	String year,late,leaveEarly,trunt,state,power,action="";
	String id;
	Connection con;
	private static final long serialVersionUID = 1L;

    public StudentAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		student=new StudentModel();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		session=request.getSession(true);
		stuDate=new StudentDate();
		session.setAttribute("student", student);
		user=request.getParameter("user");
		number=request.getParameter("number");
		pass=request.getParameter("pass");
		name=request.getParameter("name");
		sex=request.getParameter("sex");
		class_id=request.getParameter("class_id");
		college=request.getParameter("college");
		orgin=request.getParameter("origin");
		action=request.getParameter("action");
		DateBase date=new DateBase();
		try{
			 if(action.equals("123")){
				String password=request.getParameter("password");
				String userId=request.getParameter("userId");
				String s="UPDATE student SET password='"+password+"' WHERE id="+userId;
				date.connect();
				PrintWriter out=response.getWriter();
				try {
					out.println(s);
					int m=date.update(s);
					out.println(m);
				} catch (Exception e) {
					out.print(e);
				}
				response.sendRedirect("./index.jsp");
			}
				String m=student.getNumber();
				result=stuDate.findAttendance(m);
				//session.setAttribute("attenInfo", result);
			
		}catch(Exception e){
			
		}
	
		
	}
	
	
	
}
