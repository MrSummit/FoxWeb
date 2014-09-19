package Index.Date;
import Base.Date.*;
import Common.TimeCommon;

import java.sql.*;

import javax.servlet.http.HttpSession;

import com.sun.org.apache.xpath.internal.operations.And;
import com.sun.security.auth.NTDomainPrincipal;

public class AttendanceDate {
	ResultSet result;
	String str;
	int begin;
	DateBase date=new DateBase();
	public ResultSet findCourse(){
		date.connect();
		int weaks=TimeCommon.getWeeks();//�ڼ���
		int day=TimeCommon.getOfWeek();//�ܼ�
		int mm=TimeCommon.getMin();//��÷���
		mm=mm+30;
		str="SELECT * FROM course WHERE course_day="+day+" AND course_begin<="
				+weaks+" AND course_end>="
				+weaks+" AND lesson_begin<="
				+mm+" AND lesson_end>="+mm;
		result=date.find(str);
		return result;
		//date.close();
	}
	public void getBegin(int begin)
	{
		this.begin=begin;
	}
	public int addAttendance(ResultSet result,int begin,int end,String number){
		date.connect();
		String tt="";
		int m=0;
		String state="ok";
		int weaks=TimeCommon.getWeeks();//�ڼ���
		int day=TimeCommon.getOfWeek();//�ܼ�
		int mm=TimeCommon.getMin();//��÷���
		try{
		int cbegin=result.getInt("lesson_begin");//�γ̿�ʼʱ��
		int cend=result.getInt("lesson_begin");//�γ̽���ʱ��
		String course_id=result.getString("course_id");//�γ̴���
		//�ж�state���
		if(begin>cbegin){
			state="late";
		}else if(end<cend){
			state="ealarLeve";
		}else {
			state="ok";
		}
		
		tt="INSERT INTO attendance(course_id,number,weak,begin,end,state)VALUES ('"
				+course_id+"','"+number+"',"+weaks+","+begin+","+end+",'"+state+"')";
		 m=date.update(tt);
		 return m;
		
		
		}catch(Exception e){
			
		}
		return m;
	}
	public ResultSet findattence(String user,String cid){
		date.connect();
		int weaks=TimeCommon.getWeeks();//�ڼ���
		str="SELECT * FROM attendance WHERE weak="+weaks+" AND number='"
			+user+"' AND course_id='"+cid+"'";
				
		result=date.find(str);
		return result;
		//date.close();
	}
	public ResultSet findAttendance(String number){
		date.connect();
		str="SELECT * FROM attendance WHERE number='"+number+"'";
		result=date.find(str);
		return result;
	}
}
