package com.tcs.evaluation.weathermodel.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtils {
	
	public static String getTimeString(){		
		String time;
		String[] timeType = {"AM","PM"};
		
		//Generate a random time 
		int hours = (int)(Math.random()*10000)%12;
		if(hours<10){
			time = "0"+hours+":";
		}
		else{
			time = hours+":";
		}
		int minutes = (int)(Math.random()*10000)%60;
		if(minutes<10){
			time = time+"0"+minutes;
		}
		else{
			time = time+minutes;
		}
		
		//Add AM or PM to time
		int random = (int)(Math.random()*10000)%2;
		time = time+" "+timeType[random];
		
		return time;
	}
	
	public static Date formatDateTime(String year, int month, int date, String time) throws ParseException{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd hh:mm a");				
		Date formattedDate = formatter.parse(year+"-"+month+"-"+date+" "+time);
		return formattedDate;
	}
	
	//Format date into T-Z format
	public static String formatedDateTimeString(Date dateObj){
		String dateInString;
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateObj);
		int month = cal.get(Calendar.MONTH)+1;		
		int date = cal.get(Calendar.DATE);
		int year = cal.get(Calendar.YEAR);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		
		if(month<10 && date<10){
			dateInString = year+"-0"+month+"-0"+date+"T"+hour+":"+minute+"Z";
		}
		else if(month<10){
			dateInString = year+"-0"+month+"-"+date+"T"+hour+":"+minute+"Z";
		}
		else if(date<10){
			dateInString = year+"-"+month+"-0"+date+"T"+hour+":"+minute+"Z";
		}
		else{			
			dateInString = year+"-"+month+"-"+date+"T"+hour+":"+minute+"Z";
		}	
		return dateInString;
	}
}
