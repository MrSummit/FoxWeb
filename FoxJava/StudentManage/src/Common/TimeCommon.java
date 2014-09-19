package Common;

import java.text.SimpleDateFormat;
import java.util.*;
public class TimeCommon {
	public static String toTime(String s,String s1) {
		SimpleDateFormat format=new SimpleDateFormat(	 
				s1 );
		Long time=Long.parseLong(s);
		String entro = format.format(time);
		return entro;
	}
	//获得当前时间为一年内的第几周
	public static int  getWeeks(){
		Calendar c=Calendar.getInstance();
		c.setTime(new Date());
		int i=c.get(Calendar.WEEK_OF_YEAR)-7;
		return i;
	}
	//获得当前时间为星期几
	public static int getOfWeek(){
		Calendar c=Calendar.getInstance();
		c.setTime(new Date());
		int i=c.get(Calendar.DAY_OF_WEEK)-1;
		return i;
	}
	//获得当前小时和分钟并转换为分钟
	public static int getMin(){
		Calendar c=Calendar.getInstance();
		c.setTime(new Date());
		int i;
		i=c.get(Calendar.HOUR_OF_DAY)*60+c.get(Calendar.MINUTE);  
		return i;
	}
}
