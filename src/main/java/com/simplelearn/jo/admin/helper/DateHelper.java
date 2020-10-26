package com.simplelearn.jo.admin.helper;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateHelper {

	public static Date now() {
		return toUTC(new Date());
	}

	public static Date toUTC(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int offset = TimeZone.getDefault().getOffset(calendar.getTimeInMillis());
		calendar.add(Calendar.MILLISECOND, offset);
		return calendar.getTime();
	}
}