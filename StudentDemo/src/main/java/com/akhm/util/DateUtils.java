package com.akhm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.akhm.exception.StudentCustomException;

public class DateUtils {
	private DateUtils() {
	
    }
	public static Date convertStringToDate(String stringDate,String dateFormat ){
		Date utilDate=null;
		try {
			SimpleDateFormat sdf=new SimpleDateFormat(dateFormat);
			utilDate=sdf.parse(stringDate);
		} catch (ParseException pe) {
			throw new StudentCustomException("ParseException raised in dateutils convert string to date method"+stringDate);
		}
		return utilDate;
	}
}
