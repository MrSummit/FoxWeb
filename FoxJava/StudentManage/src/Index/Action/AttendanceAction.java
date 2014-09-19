package Index.Action;

import Base.Date.DateBase;
import Common.TimeCommon;
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


public class AttendanceAction extends HttpServlet {
	PreparedStatement sql;
	AttendanceModel attendance=new AttendanceModel();
	HttpSession session;
	StudentDate stuDate;
	ResultSet result;
	PrintWriter out;
	AttendanceDate aten=new AttendanceDate();
	String action="",user="",power="";
	int state=0;//��¼ѧ���ϻ�״̬
	private static final long serialVersionUID = 1L;
    public AttendanceAction() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out=response.getWriter();
		session=request.getSession(true);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		stuDate=new StudentDate();
		user=(String)session.getAttribute("user");
		result=stuDate.findAttendance(user);
		session.setAttribute("attenInfo", result);
		power=(String)session.getAttribute("power");
		action=request.getParameter("action");
		session.setAttribute("stateInfo", "");
		session.setAttribute("state", "-1");
		out=response.getWriter();
		session.setAttribute("attendance",attendance);
		//���ҿγ�
		result=aten.findCourse();
		attendance.setResult(result);
		ResultSet rs1;
		try{
			if(result.next()){
				session.setAttribute("course_name", result.getString("course_name"));
				session.setAttribute("att_class", result);
				String cid=result.getString("course_id");
				rs1=aten.findattence(user,cid);
				if(rs1.next()){
					session.setAttribute("stateInfo", "���Ѿ��������");
					response.sendRedirect("./student/attendance.jsp");
				}else{
					session.setAttribute("state", "0");
				}
			//ѧ���������Ϣ
				int endTime;
				if(power.equals("1")){
					if(action==null)
						action="";
					if(action.equals("begin")){
							int beginTime;
							beginTime=TimeCommon.getMin();
							session.setAttribute("beginTime", beginTime);
							aten.getBegin(beginTime);
							session.setAttribute("state", "1");
							session.setAttribute("stateInfo", "�ϻ��ɹ�");
							response.sendRedirect("./student/attendance.jsp");	
					}
					if(action.equals("end")){
							endTime=TimeCommon.getMin();
							int beginTime=(int)session.getAttribute("beginTime");
							int m=aten.addAttendance(result, beginTime,endTime, user);
							session.setAttribute("state", "-1");
							if(m!=0){
								session.setAttribute("stateInfo", "�»��ɹ�");
							}else{
								session.setAttribute("stateInfo", "�»�ʧ��");
							}
							
							response.sendRedirect("./student/attendance.jsp");	
					}
				}
				
			}else {
				session.setAttribute("stateInfo", "��ǰû�пγ�");
			}	
			response.sendRedirect("./student/attendance.jsp");
		}catch(Exception e){
			}
		}
		
	}

		//ѧ������ĳ���״��
		/*try{
			if(result.next()){	
				if(power.equals("1")){
					if(action==null)
						action="";
					if(action.equals("begin")){
							
							session.setAttribute("state", "1");
							session.setAttribute("stateInfo", "�ϻ��ɹ�");
							response.sendRedirect("./student/attendance.jsp");	
					}
					if(action.equals("end")){
							session.setAttribute("state", "-1");
							session.setAttribute("stateInfo", "�»��ɹ�");
							response.sendRedirect("./student/attendance.jsp");	
					}
				}
				response.sendRedirect("./student/attendance.jsp");
			}	
		}catch(Exception e){
			}
		}*/
		/*result=aten.findCourse();
		attendance.setResult(result);
		try{
			response.sendRedirect("./student/attendance.jsp");
		}catch(Exception e){
		
		
	}*/




