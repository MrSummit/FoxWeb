package Base.Date;
import java.sql.*;
public class DateBase {
	String databaseName="studentmanage";
	String tableName="";
	String user="root";
	String pswd="";
	StringBuffer queryResult=new StringBuffer();
	Connection con;
	Statement sql;
	ResultSet rs;
	int k;
	public DateBase(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(Exception e){
		}
	}
	public void setTableName(String s){
		tableName=s.trim();
	}
	public String getTableName(){
		return tableName;
	}
	public Statement connect(){
		try{
			String uri="jdbc:mysql://localhost/studentmanage?useUnicode=true&characterEncoding=UTF-8";
			con=DriverManager.getConnection(uri,user,pswd);
			sql=con.createStatement();
		}
		catch(SQLException e){
		}
		return sql;
	}
	public  Connection getCon(){
		return con;
	}
	public ResultSet find(String s){
		try{
			rs=sql.executeQuery(s); 
		}
		catch(SQLException e1){
		}
		return rs;
	}
	public int  update(String s){
		int i=0;
		try{
			i=sql.executeUpdate(s);
		}
		catch(SQLException e1){
			i=0;
		}
		return i;
	}
	public void close(){
		try{
			con.close();
		}
		catch(SQLException e1){
		}
		
	}
}
