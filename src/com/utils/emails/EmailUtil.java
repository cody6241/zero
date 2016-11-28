package com.utils.emails;

public class EmailUtil {

	public static void sendYSYTErrorEmail(){
	     MailSenderInfo mailInfo = new MailSenderInfo();    
	     mailInfo.setMailServerHost("smtp.163.com");    
	     mailInfo.setMailServerPort("25");    
	     mailInfo.setValidate(true);    
	     mailInfo.setUserName("tea-88@163.com");    
	     mailInfo.setPassword("tea-8836632491");//您的邮箱密码    
	     mailInfo.setFromAddress("tea-88@163.com");    
	     mailInfo.setToAddress("zhengyang02@whty.com.cn");    
	     mailInfo.setSubject("甬上云淘服务故障");    
	     mailInfo.setContent("甬上云淘服务访问故障，请速度重启服务");    
	}
}
