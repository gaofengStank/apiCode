package com.jeesite.modules.tab.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private static SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd");

	private static SimpleDateFormat dateFormat2 = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	
	private static SimpleDateFormat dateFormat21 = new SimpleDateFormat(
			"MM-dd");
	
	

	private static SimpleDateFormat dateFormat3 = new SimpleDateFormat(
			"yyyy-MM");

	private static SimpleDateFormat dateFormatByDate = new SimpleDateFormat(
			"dd");

	private static SimpleDateFormat dateFormatByDate4 = new SimpleDateFormat(
			"yyyyMMddHHmmss");

	private static SimpleDateFormat yearDateFormat = new SimpleDateFormat(
			"yyyy");
	
	private static  SimpleDateFormat miusDateFormat =  new SimpleDateFormat("MMddHHmmss");

	public static String parseDateFormatByDate(Date date) throws Exception {
		return dateFormatByDate.format(date);
	}
	
	private static  SimpleDateFormat  hhFormat = new SimpleDateFormat("mm");

	public static Date parseDate(String date) {
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {

			return new Date();
		}

	}

	public static String dateFormat21Parse(Date date) {
		return dateFormat21.format(date);
	}
	
	public static Date dateFormat21Parse(String date) {
		try {
			return dateFormat21.parse(date);
		} catch (ParseException e) {

			return new Date();
		}

	}

	public static String parseDate(Date date) {
		return dateFormat.format(date);
	}

	public static Date parseDate2(String date) {
		try {
			return dateFormat2.parse(date);
		} catch (ParseException e) {
			return new Date();
		}
	}

	public static String parseDate2(Date date) {
		return dateFormat2.format(date);
	}

	public static Date parseDate3(String date) {
		try {
			return dateFormat3.parse(date);
		} catch (ParseException e) {
			return new Date();
		}
	}

	public static String parseDate3(Date date) {
		return dateFormat3.format(date);
	}

	public static String dateFormatByDate4(Date date) {
		return dateFormatByDate4.format(date);
	}
	
	public static Date dateFormatByDate4(String date) {
		try {
			return dateFormatByDate4.parse(date);
		} catch (ParseException e) {
			return new Date();

 		}
	}

	public static Date parseYearDateFormat(String date) {
		try {
			return yearDateFormat.parse(date);
		} catch (ParseException e) {
			return new Date();
		}

	}

	public static String parseYearDateFormat(Date date) {
		return yearDateFormat.format(date);
	}

	public static String parseDateMius(Date date) {
 		return miusDateFormat.format(date);
	}
	
	
	public static String parsehhFormatYearDateFormat(Date date) {
		return hhFormat.format(date);
	}

	 
	
}
