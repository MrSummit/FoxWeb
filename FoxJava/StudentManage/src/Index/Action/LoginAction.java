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

import com.sun.crypto.provider.RSACipher;

public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PreparedStatement sql;
	HttpSession session;
	StudentDate stuDate;
	ResultSet result;
	String user;
	String pass;
	String id;
	Connection con;
	String name;
	int power;
	StudentModel student=new StudentModel();
    public LoginAction() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession(true);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		stuDate=new StudentDate();
		user=request.getParameter("user");
		pass=request.getParameter("pass");
		String jiaose=request.getParameter("jiaose");
		DateBase date=new DateBase();
		date.connect();
		if(jiaose.equals("2")){
		String	str="SELECT * FROM user WHERE user='"+user+"'AND password='"
				+pass+"'";
			result=date.find(str);
			boolean m=false;
			try{
				m=result.next();
			if(m==true){
				
				power=result.getInt("power");
				session.setAttribute("adminName", result.getString("name"));
				session.setAttribute("user", user);
				session.setAttribute("power", power);
				if(power==3)
					response.sendRedirect("./admin/index.jsp");
				else if(power==2){
					response.sendRedirect("./teacher/index.jsp");
				}
			}else{
				session.setAttribute("user",null);
				session.setAttribute("info","用户不存在或密码错误");
				response.sendRedirect("index.jsp");
			}
			}catch(Exception e){
				
			}
		}else if(jiaose.equals("1")){
			
			StudentDate stuDate=new StudentDate();
			session.setAttribute("student", student);
			try{
					//学生登录验证
					boolean m=login(user,pass);
					if(m==true){
						response.sendRedirect("./student/index.jsp");
					}else{
						response.sendRedirect("index.jsp");
					}
			}catch(Exception e)
			{
				
			}
		}
	}
	public boolean login(String user,String pass){
		boolean m=false;
		try{
		result=stuDate.cheak(user, pass);
		student.setResult(result);
		student.setNumber(user);
		m=result.next();
		if(m==true){
			String class_id=result.getString(6);
			id=result.getString(1);
			session.setAttribute("user", user);
			session.setAttribute("power", "1");
			session.setAttribute("class_id", class_id);
			session.setAttribute("state", "-1");
		}else{
			session.setAttribute("user",null);
			session.setAttribute("info","用户不存在或密码错误");
		}
		}catch(Exception e){
			
		}	
		return m;
	}
}
