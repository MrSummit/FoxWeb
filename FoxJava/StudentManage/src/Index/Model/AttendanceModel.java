package Index.Model;

import java.sql.ResultSet;

public class AttendanceModel {
	String action="";
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
}
