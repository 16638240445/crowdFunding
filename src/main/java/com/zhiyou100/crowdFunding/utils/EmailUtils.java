package com.zhiyou100.crowdFunding.utils;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.zhiyou100.crowdFunding.vo.User;

public class EmailUtils {
private static final String FROM = "1107798500@qq.com";
	
	public static void sendAccountActivateEmail(User user) {
		
		Session session = getSession();
		
		MimeMessage message = new MimeMessage(session);  
		
		try {
			message.setSubject("����һ�⼤���˺ŵ��ʼ�");
			message.setSentDate(new Date());
			//setFrom ��ʾ���ĸ����䷢���ʼ�
			message.setFrom(new InternetAddress(FROM));
			/**
			 * RecipientType.TO||BCC||CC
			 *     TO��ʾ��Ҫ������
			 *     BCC��ʾ���ܳ�����
			 *     CC��ʾ������
			 * InternetAddress  �����ߵ������ַ
			 */
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getUsEmail()));
			/*message.setContent("<a target='_BLANK' href='"+GenerateLinkUtils.generateActivateLink(user)+"'>"+user.getUsername()+"����/Ůʿ���ã����������Ӽ����˺�"+GenerateLinkUtils.generateActivateLink(user)
			+"</a>","text/html;charset=utf-8");*/
			message.setContent(user.getUsName()+"����/Ůʿ���ã����������Ӽ����˺�"+GenerateLinkUtils.generateActivateLink(user)
			,"text/html;charset=utf-8");
			Transport.send(message);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	public static Session getSession() {
		
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");//ָ�����͵����������Э��
		props.setProperty("mail.smtp.host","smtp.qq.com");//ָ��SMTP������
		props.setProperty("mail.smtp.port", "25");  //smtp�Ƿ����ʼ�������,�˿���25
		props.setProperty("mail.smtp.auth","true");//ָ���Ƿ���ҪSMTP��֤
		
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication(FROM, "wbmnqmwoxnwxjjgi");
			}
		});
		return session;
	}

}
