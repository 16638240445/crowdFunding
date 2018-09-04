package com.zhiyou100.crowdFunding.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.jmx.snmp.Timestamp;

/**
 * 处理日期以的工具类
 */
public class DateUtils {

	/**
	 * 将yyyy-MM-dd形式的字符串转换为java.util.Date类
	 * 
	 * @param date日期格式
	 * @param String
	 *            日期的字符串形式
	 * @throws ParseException
	 */
	public static Date getStringDate(String str) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(str);
	}

	/**
	 * 将java.util.Date类转换为yyyy-MM-dd形式的字符串
	 * 
	 * @param date日期格式
	 * @param String
	 *            日期的字符串形式
	 */
	public static String getDateString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}

	/**
	 * 将yyyy-MM-dd 形式的字符串转换为java.util.Date类
	 * 
	 * @param date日期格式
	 * @param String
	 *            日期的字符串形式
	 * @throws ParseException
	 */
	public static Date StringtoDate(String str) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.parse(str);
	}

	/**
	 * 将yyyy-MM-dd HH:mm:ss形式的字符串转换为java.util.Date类
	 * 
	 * @param date日期格式
	 * @param String
	 *            日期的字符串形式
	 * @throws ParseException
	 */
	public static String DatetoString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		return sdf.format(date);
	}

	public static Date sqlDatetoUtilDate(Timestamp ts) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		return sdf.parse(sdf.format(new java.sql.Date(ts.getDateTime())));
	}

}
