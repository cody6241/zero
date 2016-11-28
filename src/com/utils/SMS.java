package com.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class SMS {
	
	public static void main(String path[]) throws Exception {
		//创建短信模板的接口
        //URL u=new URL("http://route.showapi.com/28-2?showapi_appid=27644&content=甬上云淘网络故障[name]&title=甬上云淘故障&showapi_sign=ff0f9db42532456f998a7bc2bb6a3020");
		
		//发送短信的接口
		URL u=new URL("http://route.showapi.com/28-1?showapi_appid=27644&mobile=15013612462&content={\"name\":\"cody\"}&tNum=T161122000593&showapi_sign=ff0f9db42532456f998a7bc2bb6a3020");
		
        InputStream in=u.openStream();
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        try {
            byte buf[]=new byte[1024];
            int read = 0;
            while ((read = in.read(buf)) > 0) {
                out.write(buf, 0, read);
            }
        }  finally {
            if (in != null) {
                in.close();
            }
        }
        byte b[]=out.toByteArray( );
        System.out.println(new String(b,"utf-8"));
	}
	
	public static void sendSMS() throws Exception{
		//发送短信的接口
		URL u=new URL("http://route.showapi.com/28-1?showapi_appid=27644&mobile=15013612462&content={\"name\":\"cody\"}&tNum=T161122000593&showapi_sign=ff0f9db42532456f998a7bc2bb6a3020");
		
        InputStream in=u.openStream();
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        try {
            byte buf[]=new byte[1024];
            int read = 0;
            while ((read = in.read(buf)) > 0) {
                out.write(buf, 0, read);
            }
        }  finally {
            if (in != null) {
                in.close();
            }
        }
        byte b[]=out.toByteArray( );
        System.out.println(new String(b,"utf-8"));
	}

}
