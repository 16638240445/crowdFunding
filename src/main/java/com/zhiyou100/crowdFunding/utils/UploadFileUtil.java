package com.zhiyou100.crowdFunding.utils;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/**
 * �����ļ��ı��洦��
 * @author 
 */
public class UploadFileUtil {
	/**
	 * ����Ҫ������ļ�����
	 * @param mime
	 * @return
	 */
	public static String createFileName(String mime) {	// ��Ҫ����һ���ļ�����
		String fileName = UUID.randomUUID() + "." + mime.split("/")[1] ;
		return fileName ;
	}
	/**
	 * �����ļ��ı������
	 * @param srcFile �ϴ���ԭʼ�ļ�����������
	 * @param destFile Ҫ�����Ŀ���ļ�·��
	 * @return ����ɹ�����true�����򷵻�false
	 */
	public static boolean save(InputStream inputStream, File destFile) {
		boolean flag = false ;
		OutputStream output = null ;
		if (!destFile.getParentFile().exists()) {	// ��·��������
			destFile.getParentFile().mkdirs() ;	// ������·��
		}
		try {
			output = new FileOutputStream(destFile) ;
			byte data [] = new byte [2048] ;	// ÿ�����ݵı����С
			int temp = 0 ;	// ����ÿ�εĸ���
			while ((temp = inputStream.read(data)) != -1) {
				output.write(data, 0, temp);
			} 
			flag = true ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				output.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag ;
	}
}
