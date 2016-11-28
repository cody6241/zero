package com.utils.emails;

import javax.mail.*;   

public class MyAuthenticator extends Authenticator{   
    String userName=null;   
    String password=null;   
        
    public MyAuthenticator(){   
    }   
    public MyAuthenticator(String username, String password) {    
        this.userName = username;    
        this.password = password;    
    }    
    protected PasswordAuthentication getPasswordAuthentication(){   
        return new PasswordAuthentication(userName, password);   
    }
    
    
    
    
    public static void main(String[] args){   
        //这个类主要是设置邮件   
     MailSenderInfo mailInfo = new MailSenderInfo();    
     mailInfo.setMailServerHost("smtp.163.com");    
     mailInfo.setMailServerPort("25");    
     mailInfo.setValidate(true);    
     mailInfo.setUserName("tea-88@163.com");    
     mailInfo.setPassword("tea-8836632491");//您的邮箱密码    
     mailInfo.setFromAddress("tea-88@163.com");    
     mailInfo.setToAddress("tea-88@163.com");    
     mailInfo.setSubject("甬上云淘服务故障");    
     mailInfo.setContent("甬上云淘服务访问故障，请速度重启服务");    
        //这个类主要来发送邮件   
     SimpleMailSender sms = new SimpleMailSender();   
         sms.sendTextMail(mailInfo);//发送文体格式    
//         sms.sendHtmlMail(mailInfo);//发送html格式   
   }  
}  