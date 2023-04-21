package com.expensemanager.expensemanager.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateTimeUtil {
	
	public static String convertDateToString(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return simpleDateFormat.format(date);
	}

	public static Date convertStringToDate(String dateString) throws ParseException {
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyy");
	java.util.Date utilDate = simpleDateFormat. parse((dateString));
	return new Date(utilDate.getTime());
	}
}
