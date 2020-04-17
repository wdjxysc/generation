package com.whty.edu.brain.ig.framework.util;

import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
/**
 * @ClassName: MailUtil
 * @Description:TODO 邮件发送工具类
 * @author: generation
 * @date: 2020年04月17日 09:28:335
 * @Copyright: generation
 * 修改代码中的账号密码来实现发送邮件
 */
public class MailUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(MailUtil.class);
	/**
	 * 邮箱账号
	 */
	private final static String sender_code = "100000@qq.com";
	/**
	 * 邮箱密码
	 */
	private final static String sender_password = "abcdefghijklmn";
	
	/**
	 * 邮箱服务
	 */
	private final static String email_host = "smtp.qq.com";
	
	/**
	 * 超时时间
	 */
	private final static Integer time_out = 5000;
	/**
	* @Title: send  
	* TODO 发送邮件
	* @param receive 接收人
	* @param title 标题
	* @param content 正文
	* @throws
	 */
	@Async
	public static void send(String receive, String title, String content) {
		logger.info("开始给" + receive + "发送邮件");
		// 创建邮件发送服务器
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(email_host);
		mailSender.setUsername(sender_code);
		mailSender.setPassword(sender_password);
		// 加认证机制
		Properties javaMailProperties = new Properties();
		javaMailProperties.put("mail.smtp.auth", true);
		javaMailProperties.put("mail.smtp.starttls.enable", true);
		javaMailProperties.put("mail.smtp.timeout", time_out);
		mailSender.setJavaMailProperties(javaMailProperties);
		// 创建邮件内容
		try {
			MimeMessage mailMessage = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true, "GBK"); 
			messageHelper.setTo(receive);
			messageHelper.setFrom(sender_code);
			messageHelper.setSubject("【应用名】" + title); 
			StringBuilder html = new StringBuilder();
			html.append("<html><meta http-equiv=content-type content='text/html; charset=gbk'><head></head>");
			html.append("<style>table td {border:1px solid #b5aeae;}</style><body>");
			html.append(content);
			html.append("</body></html>");
			messageHelper.setText(html.toString(), true);
			mailSender.send(mailMessage);
			logger.info("邮件发送完成");	
		} catch (Exception e) {
			logger.error("邮件发送异常", e);
			e.printStackTrace();
		}
	}
}
