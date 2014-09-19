package Index.Model;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
public class CourseModel {
	String course_name,course_begin,course_end;
	String class_id,lesson_begin,lesson_end,teacher;
	String course_date,place,action="";
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
	public String getCourse_name(){
		return course_name;
	}
	public void setCourse_name(String course_name){
		this.course_name=toS(course_name);
	}
	
	public String getCourse_begin(){
		return course_begin;
	}
	public void setCourse_begin(String course_begin){
		this.course_begin=toS(course_begin);
	}
	public String getCourse_end(){
		return course_end;
	}
	public void setCourse_end(String course_end){
		this.course_end=toS(course_end);
	}
	public String getLesson_begin(){
		return lesson_begin;
	}
	public void setLesson_begin(String lesson_begin){
		this.lesson_begin=toS(lesson_begin);
	}
	public String getClass_id(){
		return class_id;
	}
	public void setClass_id(String class_id){
		this.class_id=toS(class_id);
	}
	public String getLesson_end(){
		return lesson_end;
	}
	public void setLesson_end(String lesson_end){
		this.lesson_end=toS(lesson_end);
	}
	public String getTeacher(){
		return teacher;
	}
	public void setTeacher(String teacher){
		this.teacher=toS(teacher);
	}
	public String getPlace(){
		return place;
	}
	public void setPlace(String place){
		this.place=toS(place);
	}
	public String getCourse_date(){
		return course_date;
	}
	public void setCourse_date(String course_date){
		this.course_date=toS(course_date);
	}
}