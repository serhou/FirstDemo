package com.bestlove.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Utils {

	/**
	 * 根据日期字符串和日期类型返回日期对象
	 *
	 * @param dateStr
	 * @param pattern2
	 * @return
	 *
	 * @version 1.0
	 * @since 1.0
	 */
	public static java.util.Date getDateFromStringDate(String dateStr,
			String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		java.util.Date obj = null;
		try {
			obj = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
}
