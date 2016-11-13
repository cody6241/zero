package com.regexp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp1 {

	public static void main(String[] args) throws IOException {
		String path = RegExp1.class.getResource("/phone").getFile();
		path = path.substring(1, path.length());
//		System.out.println(path);
		FileInputStream fis = new FileInputStream(path);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		Pattern pattern = Pattern.compile("\\(\\d{3}\\)\\s\\d{3}-\\d{4}");
		String str = "";
		while((str = br.readLine()) != null)
		{
			Matcher matcher = pattern.matcher(str);
			if(matcher.find()){
				System.out.println(str);
			}
		}
		br.close();
	}

}
