package com.zero.quartz;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.log4j.Logger;

import com.utils.SMS;
import com.utils.emails.EmailUtil;

public class JobExecuter {
	private int status = 0;//发送一次短信之后更改状态，之后发送邮件
	Logger logger = Logger.getLogger(getClass());
	
	public void quarterHourMethod() throws Exception{
		HttpClient client = new HttpClient();
		HttpMethod method = new GetMethod("http://www.nbedumall.com/ysyt/");
		try {
			client.executeMethod(method);
			logger.info("visit success");
			if(this.status != 0){
				this.status = 0;
			}
		} catch (IOException e) {
			if(this.status == 0){
				SMS.sendSMS();
				this.status++;
				logger.error("failed sms"+this.status);
			}else{
				logger.error("failed email"+this.status);
//				EmailUtil.sendYSYTErrorEmail();
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		JobExecuter j = new JobExecuter();
		j.quarterHourMethod();
	}
}
