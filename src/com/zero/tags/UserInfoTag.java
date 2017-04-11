package com.zero.tags;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.zero.domain.User;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

@Component
@Scope("prototype")
public class UserInfoTag implements TemplateMethodModelEx {

	@Override
	public Object exec(List arg0) throws TemplateModelException {
		User user = new User();
		String name = new String("小明");
		user.setUserName(name);
		return user;
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException{
		String str = "张三" ;  
		byte[] jiema= str.getBytes("utf-8") ; //解码  
		String   bianma = new String(jiema,"UTF-8");//编码 如果上面的解码不对 可能出现问题 
	}

}
