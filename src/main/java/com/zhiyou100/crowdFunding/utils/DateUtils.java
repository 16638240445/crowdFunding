package com.zhiyou100.crowdFunding.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.jmx.snmp.Timestamp;

/**
 * ���������ԵĹ�����
 */
public class DateUtils {

	/**
	 * ��yyyy-MM-dd��ʽ���ַ���ת��Ϊjava.util.Date��
	 * 
	 * @param date���ڸ�ʽ
	 * @param String
	 *            ���ڵ��ַ�����ʽ
	 * @throws ParseException
	 */
	public static Date getStringDate(String str) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(str);
	}

	/**
	 * ��java.util.Date��ת��Ϊyyyy-MM-dd��ʽ���ַ���
	 * 
	 * @param date���ڸ�ʽ
	 * @param String
	 *            ���ڵ��ַ�����ʽ
	 */
	public static String getDateString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}

	/**
	 * ��yyyy-MM-dd ��ʽ���ַ���ת��Ϊjava.util.Date��
	 * 
	 * @param date���ڸ�ʽ
	 * @param String
	 *            ���ڵ��ַ�����ʽ
	 * @throws ParseException
	 */
	public static Date StringtoDate(String str) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.parse(str);
	}

	/**
	 * ��yyyy-MM-dd HH:mm:ss��ʽ���ַ���ת��Ϊjava.util.Date��
	 * 
	 * @param date���ڸ�ʽ
	 * @param String
	 *            ���ڵ��ַ�����ʽ
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
