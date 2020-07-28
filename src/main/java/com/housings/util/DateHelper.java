package com.housings.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {

	/**
	 * yyyy-MM-dd HH:mm:ss
	 * 获取当前格式化时间
	 * @return
	 */
	public static String getNowFormatDate(){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sf.format(new Date());
	}

	public static String formatDate(Date date, String format) {
		if (date != null) {
			SimpleDateFormat sf = new SimpleDateFormat(format);
			return sf.format(date);
		}
		
		return null;
	}
	
	public static Date parseDate(String dateStr, String format) throws ParseException {
		if (!StringHelper.isEmptyStr(dateStr)) {
			SimpleDateFormat sf = new SimpleDateFormat(format);
			return sf.parse(dateStr);
		}
		
		return null;
	}
	public static void main(String[] args) {
		try {
			Date parseDate = parseDate("10.01.2019", "dd.mm.yyyy");
			System.out.println(parseDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public static String formatDateString(String dateStr, String currentFormat, String newFormat) throws ParseException {
		Date date = DateHelper.parseDate(dateStr, currentFormat);
		String formattedDateStr = DateHelper.formatDate(date, newFormat);
		
		return formattedDateStr;
	}
	
	public static int compareDate(Date date1, Date date2) {
		if (date1.getTime() > date2.getTime()) {
			return 1;
		} else if (date1.getTime() < date2.getTime()) {
			return -1;
		} else {
			return 0;
		}
	}
	
	public static Date addHourOnDate(Date date, int hour){
		try{
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.HOUR, hour);
			date = c.getTime();
		}catch (Exception e) {
		    e.printStackTrace();
		}
		return date;
	}
	
	public static Date addMinuteOnDate(Date date, int minute){
		try{
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.MINUTE, minute);
			date = c.getTime();
		}catch (Exception e) {
		    e.printStackTrace();
		}
		return date;
	}
	
	public static Date getNoonOfDay() {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.set(Calendar.HOUR_OF_DAY, 12);
		cal.set(Calendar.MINUTE, cal.getMinimum(Calendar.MINUTE));
		cal.set(Calendar.SECOND, cal.getMinimum(Calendar.SECOND));
		cal.set(Calendar.MILLISECOND, cal.getMinimum(Calendar.MILLISECOND));
		
		return cal.getTime();
	}
	
	public static int gapDate(Date start, Date end) {
		
		if (start == null) {
			start = new Date();
		}
		
		SimpleDateFormat format = new SimpleDateFormat("DD");
		return Integer.parseInt(format.format(end)) - Integer.parseInt(format.format(start));
	}
	
	public static long date2Millisecond(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
		long milliseconds = 0;
		try {
			milliseconds = format.parse(date).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return milliseconds;
	}
	
	public static String millisecond2Date(long milliseconds) {
		Date date = new Date(milliseconds);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return  format.format(date);
	}
	
}
