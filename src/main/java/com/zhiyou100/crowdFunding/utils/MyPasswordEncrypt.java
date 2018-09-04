package com.zhiyou100.crowdFunding.utils;

public class MyPasswordEncrypt {
	private static final String SALT="E10ADC3949BA59ABBE56E057F20F883E%!!";
	/**
	 * 提供有密码的加密处理操作
	 * @param password
	 * @return 加密后的String
	 */
	public static String encryptPassword(String password) {
		return new MD5Code().getMD5ofStr(password+"{{"+SALT+"}}");
	}
	
	public static void main(String[] args) {
		System.out.println(MyPasswordEncrypt.encryptPassword("a123456"));
	}
}
