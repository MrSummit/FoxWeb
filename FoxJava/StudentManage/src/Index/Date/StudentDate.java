package Index.Date;
import Base.Date.*;
import java.sql.*;
public class StudentDate {
	String number,password;
	String str="";//ЦёБо
	ResultSet result;
	DateBase date=new DateBase();
	public ResultSet cheak(String user,String ps){
		date.connect();
		str="SELECT * FROM student WHERE number='"+user+"'AND password='"
			+ps+"'";
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
