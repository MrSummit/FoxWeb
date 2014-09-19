package Index.Date;
import Base.Date.*;
import java.sql.*;
public class CourseDate {
	String number,password;
	String str="";//ЦёБо
	ResultSet result;
	DateBase date=new DateBase();
	public ResultSet allCourse(String class_id){
		date.connect();
		str="SELECT * FROM course WHERE class_id="+class_id
				+" ORDER BY course_begin";
		result=date.find(str);
		return result;
		//date.close();
	}
}