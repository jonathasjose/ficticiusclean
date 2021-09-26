package br.com.ficticiusclean.helper;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static int getYearFromDate(Date date) {
	    
		int result = -1;
	    if (date != null) {
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
	        result = cal.get(Calendar.YEAR);
	    }
	    return result;
	}
}
