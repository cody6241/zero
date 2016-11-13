package com.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp2 {

	public static void main(String[] args) {
		String str = "<html><body style=\"display:none\"><div>hello</div><span>hello too</span></body></html>";
		
//		Pattern p = Pattern.compile("<([^>]*)>");//去除所有html标签
//		Pattern p = Pattern.compile("</?body([^>]*)>");//仅去除body标签
		Pattern p = Pattern.compile("style=\"([^\"]+)\"");//找出body标签的style属性
		Matcher m = p.matcher(str);
		
		if(m.find())
		{
			System.out.println(m.group(0));
		}
		
	}

}
