package com.zhiyou100.crowdFunding.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.zhiyou100.crowdFunding.vo.User;

public class GenerateLinkUtils {
	private static final String CHECK_CODE = "checkCode";
	 
	public static String generateActivateLink(User user) {
		
		return "http://192.168.4.201:8080/crowdFunding/user/activate.action?id="+user.getUsId()+"&"+CHECK_CODE+"="+generateCheckcode(user);
	}
 
	/**
	 * ����У���룬�û���+UUIDΨһ��ʶ����Ϊ��ȫ�����Ǽ��ܷ���
	 * @param user
	 * @return
	 */
	private static String generateCheckcode(User user) {
		String userName = user.getUsName();
		String randomCode = user.getUsCode();
		return md5(userName+":"+randomCode);
	}
 
	private static String md5(String string) {
		MessageDigest md = null;
		
		try {
			md = MessageDigest.getInstance("md5");//����ʵ��ָ��ժҪ�㷨�� MessageDigest ����
			md.update(string.getBytes());//ʹ��ָ���� byte �������ժҪ�� 
			byte[] md5Bytes = md.digest();//ͨ��ִ���������֮������ղ�����ɹ�ϣ���㡣�ڵ��ô˷���֮��ժҪ�����á�
			return bytes2Hex(md5Bytes);//����ϢժҪ
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			System.out.println("md5���������");
		}
		return null;
	}
 
	
	//������ת�ַ���
	private static String bytes2Hex(byte[] byteArray) {
		
		StringBuffer strBuf = new StringBuffer();
		
		for (int i = 0; i < byteArray.length; i++) {
			if(byteArray[i] >= 0 && byteArray[i] < 16) {
				strBuf.append("0");
			}
			strBuf.append(Integer.toHexString(byteArray[i] & 0xFF));
		}
		return strBuf.toString();
	}
 
	public static boolean verifyCheckcode(User user, String checkCode) {
		
		boolean flag = generateCheckcode(user).equals(checkCode);
		
		return flag;
	}
	
	/**
	 * ���䣺
	 * Ϊ����ʾһ��byte�͵ĵ��ֽ�ʮ������(��λʮ�����Ʊ�ʾ)�ı��룬��ʹ�ã�
	 * Integer.toHexString((byteVar & 0x000000FF) | 0xFFFFFF00).substring(6);
	 * byteVar & 0x000000FF�������ǣ����byteVar �Ǹ�����������ǰ��24���㣬����byte���Ͳ���Ӱ�졣
	 * (...) | 0xFFFFFF00�������ǣ����byteVar ������������ǰ24λΪһ��
	 * ����toHexString���һ��С�ڵ���15��byte���͵�ʮ������ʱ�������ڶ�λΪ���Ҳ��ᱻ������
	 * ��������ͨ��substring�������н�ȡ�����λ���ɡ� 
	 */

}
