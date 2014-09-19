package Index.Date;
import Base.Date.*;
import Common.TimeCommon;
import Index.Model.StudentModel;

import java.sql.*;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.sun.security.auth.NTDomainPrincipal;

public class AdminDate {
	
	PreparedStatement sql;
	String number,password;
	String s;
	ResultSet result,rs1,rs2,rs3;
	StringBuffer str;
	String class_id,calss_name;
	int class_size;
	DateBase date=new DateBase();
	Connection con;
	public ResultSet action1(){
		date.connect();
		try{
			s="SELECT * FROM grade ORDER BY class_id";
			result=date.find(s);
			}catch(Exception e){
				
			}	
		return result;
	}
	public ResultSet action22(String class_id){
		date.connect();
		try{
			String str="SELECT * FROM grade WHERE class_id="+class_id; 
			result=date.find(str);
			}catch(Exception e){
				
			}	
		return result;
	}
	public ResultSet action2(String class_id){
		date.connect();
		String string="";
		try{
			s="SELECT * FROM student WHERE class_id="+class_id;
			String str="SELECT * FROM grade WHERE class_id="+class_id; 
			result=date.find(s);
			}catch(Exception e){
				
			}	
		return result;
	}
	public int action3(String class_id,String class_name){
		int m=0;
		date.connect();
		String string="";
		try{
			s="UPDATE grade SET name='"+class_name
					+"' WHERE class_id="+class_id;
			m=date.update(s);
			}catch(Exception e){
				
			}	
		return m;
	}
	public int action4(String class_id,String class_name){
		int m=0;
		date.connect();
		String string="";
		try{
			s="INSERT INTO grade(name,class_id,class_size) VALUES('"
				+class_name+"',"+class_id+",0)";
			m=date.update(s);
			}catch(Exception e){
				
			}	
		
		return m;
	}
	public ResultSet action5(String number){
		date.connect();
		String string="";
		try{
			s="SELECT * FROM student WHERE number='"+number+"'";
			result=date.find(s);
			}catch(Exception e){
				
			}	
		return result;
	}
	
	
	public int action6(String number,String name,String classid,String sex,String orgin,String year,String id){
		int m=0;
		try{
			String uri="jdbc:mysql://localhost/studentmanage?useUnicode=true&characterEncoding=UTF-8";
			con=DriverManager.getConnection(uri,"root","");
			Statement sql=con.createStatement();
			String s="UPDATE student SET number='"+number+"'"+",name='"+name+"',sex='"+sex
					+"',class_id='"+class_id+"',orgin='"+orgin+"' WHERE id="+id;
			sql=con.createStatement();
			sql.executeUpdate(s);
			}catch(Exception e){
				
			}	
		return m;
	}
	public int action7(String number,String name,String classid,String sex,String orgin,String year){

		int m=0;
		date.connect();
		String string="";
		try{
			s="INSERT INTO student(name,number,class_id,sex,orgin,year,entrollmentTime)VALUES ('"
					+name+"','"+number+"',"+classid+",'"+sex+"','"+orgin+"',"+year+")";
			m=date.update(s);
			}catch(Exception e){
				
			}	
		
		return m;
	}
	public ResultSet action8(){
		ResultSet result;
		date.connect();
		s="SELECT * FROM course ORDER BY course_begin";
		result=date.find(s);
		return result;
	}
	public ResultSet action18(String course_id){
		ResultSet result;
		date.connect();
		String s="SELECT * FROM course WHERE course_id='"+course_id+"'";
		result=date.find(s);
		return result;
	}
	//É¾³ýÑ§Éú
	public void action20(String number){
		String sf="DELETE FROM student WHERE number='"+number+"'";
		date.connect();
		date.update(sf);
	}
	//É¾³ý°à¼¶
	public void action15(String class_id){
		String cf="DELETE FROM student WHERE class_id="+class_id;
		String sf="DELETE FROM grade WHERE class_id='"+class_id+"'";
		date.connect();
		date.update(sf);
	}
	public void action40(String course_id){
		String sf="DELETE FROM course WHERE course_id='"+course_id+"'";
		date.connect();
		date.update(sf);
	}
	public ResultSet action30(){
		date.connect();
		try{
			s="SELECT * FROM student ORDER BY class_id,number";
			result=date.find(s);
			}catch(Exception e){
				
			}	
		return result;
	}
	public ResultSet action33(){
		date.connect();
		try{
			s="SELECT * FROM attendance ORDER BY weak,begin,end";
			result=date.find(s);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
}


