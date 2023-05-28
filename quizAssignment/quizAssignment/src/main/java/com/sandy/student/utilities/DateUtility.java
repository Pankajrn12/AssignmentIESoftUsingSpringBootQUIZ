package com.sandy.student.utilities;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateUtility {

	private DateUtility() {
		
	}
	private static String dtpatern = "yyyy-MM-dd HH:mm:ss.SSS";

	public static String dateAsString(Date date, String dtpatern) {
		DateFormat df = new SimpleDateFormat(dtpatern);
		return df.format(date);
	}
	
	public static Date toDate(String date, String patern) {
		DateFormat dateFormat = new SimpleDateFormat(patern);
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			return null;
		}

	}
	
	public static Date getCurrentDate() {
		String dtstr = LocalDateTime.now().format(DateTimeFormatter.ofPattern(dtpatern));
		DateFormat dateFormat = new SimpleDateFormat(dtpatern);
		Date date = null;
		try {
			date = dateFormat.parse(dtstr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	public static boolean isValidDate(final Timestamp timestamp) {
		return timestamp != null;
	}
	
	public static boolean isValidDate(final Date timestamp) {
		return timestamp != null;
	}
	
	public static Date getDateFormatDNew(final Date timestamp) {
		return isValidDate(timestamp) ? new Date(timestamp.getTime()) :null;
	}
	public static Date getDateFormat(final Timestamp timestamp) {
		return isValidDate(timestamp) ? new Date(timestamp.getTime()) :null;
	}
	
	public static Timestamp getTimestampFormat(final Date date) {
		return isValidDate(date) ? new Timestamp(date.getTime()) :null;
	}
	
	public static Timestamp getCurrentTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}
	
	public static Date getDateType(final String inputDate, final String pattern) {
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			return simpleDateFormat.parse(inputDate);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
//	public static Timestamp getTimestamp(final String inputDate) {
//		try {
//			return getTimestampWithFormat(inputDate, "dd/mm/yyy");
//		}catch (Exception e) {
//			// TODO: handle exception
//		}
//		return null;
//	}
	
	public static Timestamp getTimestamp(final Date inputDate) {
		return inputDate != null ? new Timestamp(inputDate.getTime()) :null;
	}

//	public static Timestamp getTimestamp(final String inputDate, final String dateFormat) {
//		try {
//			return getTimestampWithFormat(inputDate, dateFormat);
//		}catch (Exception e) {
//			// TODO: handle exception
//		}
//		return null;
//	}
	
	@SuppressWarnings("unused")
	private static Timestamp getTimestampWithFormat(String inputDate)throws Exception {
		try {
			//"yyyy-MM-dd hh:mm:ss.SSS"
			final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			//final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
			final Date parsedDate = formatter.parse(inputDate);
			return new Timestamp(parsedDate.getTime());
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	//////
	
	public static String getDateYear() {
		return null;
	}
	
	public static Date removeTimeT(Date date) {    
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  
        cal.set(Calendar.HOUR_OF_DAY, 0);  
        cal.set(Calendar.MINUTE, 0);  
        cal.set(Calendar.SECOND, 0);  
        cal.set(Calendar.MILLISECOND, 0);  
        return cal.getTime(); 
    }

	
}
