package com.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Encipher {
	static char[] hex = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'}; 

    
    public static String doMD5Encipher(String str){
    	String ret = "";
    	try {
    		MessageDigest md5 = MessageDigest.getInstance("MD5");//申明使用MD5算法
    		md5.update(str.getBytes());//
    		ret = byte2str(md5.digest());
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return ret;
    }
    
    public static void main(String[] args) throws NoSuchAlgorithmException{
    	doMD5Encipher("");
    }
    
    /**
     * 将字节数组转换成十六进制字符串
     * @param bytes
     * @return
     */
    private static String byte2str(byte []bytes){
        int len = bytes.length;   
        StringBuffer result = new StringBuffer();    
        for (int i = 0; i < len; i++) {   
            byte byte0 = bytes[i];   
            result.append(hex[byte0 >>> 4 & 0xf]);   
            result.append(hex[byte0 & 0xf]);   
        }
        return result.toString();
    }
}
