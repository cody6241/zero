package com.zero.quartz;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

public class JobExecuter {

	public void quarterHourMethod(){
		HttpClient client = new HttpClient();
		HttpMethod method = new GetMethod("http://edumall.nbsedu.com:8888/ysyt/");
		try {
			client.executeMethod(method);
		} catch (IOException e) {
			System.out.println("error");
		}
	}
	
	public static void main(String[] args){
		JobExecuter j = new JobExecuter();
		j.quarterHourMethod();
	}
}
