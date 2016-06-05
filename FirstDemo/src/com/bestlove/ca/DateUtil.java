package com.bestlove.ca;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

	
	//获取当前日期
	public static Date getCurrentDate(){
		return new Date();
	}
	
	//获取一年以后的日期
	public static Date getNextYearDate(){
		Calendar calendar = new GregorianCalendar();
		long nextTime = calendar.getTimeInMillis() + (365*24*60*60*1000L);
		calendar.setTimeInMillis(nextTime);
		return calendar.getTime();
	}
	
	public static void main(String[] args) {
		System.out.println(getNextYearDate());
		System.out.println(getCurrentDate());
	}
	
}
