package Index.Model;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
public class StudentModel {
	String number,name,sex,password;
	String class_id,entrollmentTime,orgin,college;
	String year,late,leaveEarly,trunt,state,power,action="";
	ResultSet result;
	public String toS(String s){
		String str;
		try{
		str = new String(s.getBytes("ISO-8859-1"),"utf-8");
		}
		catch(Exception e){str="";}
		return str;
	}
	public ResultSet getResult(){
		return result;
	}
	public void setResult(ResultSet result){
		this.result=result;
	}
	public String getAction(){
		return action;
	}
	public void setAction(String action){
		this.action=action;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=toS(name);
	}
	public String getNumber(){
		return number;
	}
	public void setNumber(String number){
		this.number=toS(number);
	}
	public String getSex(){
		return sex;
	}
	public void setSex(String sex){
		this.sex=toS(sex);
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password=toS(password);
	}
	public String getEntrollmentTime(){
		SimpleDateFormat format=new SimpleDateFormat(	 
				"yyyy-MM-dd HH:mm" );
		Long time=Long.parseLong(entrollmentTime);
		String entro = format.format(time); 
		return entro;
	}
	public void setEntrollmentTime(String entrollmentTime){
		

		this.entrollmentTime=toS(entrollmentTime);
	}
	public String getClass_id(){
		return class_id;
	}
	public void setClass_id(String class_id){
		this.class_id=toS(class_id);
	}
	public String getOrgin(){
		return orgin;
	}
	public void setOrgin(String orgin){
		this.orgin=toS(orgin);
	}
	public String getCollege(){
		return college;
	}
	public void setCollege(String college){
		this.college=toS(college);
	}
	public String getPower(){
		return power;
	}
	public void setPower(String power){
		this.power=toS(power);
	}
	public String getLate(){
		return late;
	}
	public void setLate(String late){
		this.late=toS(late);
	}
	public String getYear(){
		return year;
	}
	public void setYear(String year){
		this.year=toS(year);
	}
	public String getLeaveEarly(){
		return leaveEarly;
	}
	public void setLeaveEarly(String leaveEarly){
		this.leaveEarly=toS(leaveEarly);
	}
	public String getTrunt(){
		return trunt;
	}
	public void settTunt(String trunt){
		this.trunt=toS(trunt);
	}
	public String getState(){
		return state;
	}
	public void setState(String state){
		this.state=toS(state);
	}
}