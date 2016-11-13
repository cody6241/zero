package com.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp2 {

	public static void main(String[] args) {
		String str = "<html><body style=\"display:none\"><div>hello</div><span>hello too</span></body></html>";
		
//		Pattern p = Pattern.compile("<([^>]*)>");//ȥ������html��ǩ
//		Pattern p = Pattern.compile("</?body([^>]*)>");//��ȥ��body��ǩ
		Pattern p = Pattern.compile("style=\"([^\"]+)\"");//�ҳ�body��ǩ��style����
		Matcher m = p.matcher(str);
		
		if(m.find())
		{
			System.out.println(m.group(0));
		}
		
	}

}
