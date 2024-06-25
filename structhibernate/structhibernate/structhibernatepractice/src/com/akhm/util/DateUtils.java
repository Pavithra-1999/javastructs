package com.akhm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.akhm.exception.MyCustomException;

public class DateUtils {

	// private constructor
	private DateUtils() {

	}

	public static Date convertStringToDate(String inputDate) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			date = sdf.parse(inputDate);

		} catch (ParseException pe) {

			throw new MyCustomException(
					"exception occured in DateUtils class" + inputDate + " exception is " + pe.getMessage());

		}
		return date;

	}
	public static String convertDateToString(Date date )
	{
		String outputDate=null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			outputDate = sdf.format(date);
			
		} 
		catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return outputDate;
		
	}

}
