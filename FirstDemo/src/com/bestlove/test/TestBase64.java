package com.bestlove.test;

import org.apache.commons.codec.binary.Base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 加密解密
 * 
 * 科克霍夫原则：(现代密码学设计的基本原则)
 * 数据的安全基于密钥而不是算法保密。即系统的安全取决于密钥，对密钥保密，对算法公开。
 * 
 * Base64：基于64个字符的编码算法，可以充当加解密算法，但是不是真正的加解密算法
 * 
 * 应用场景：email、密钥、证书文件
 * 
 * 产生：邮件的历史问题，传递原始数据问题
 * 
 * @author think
 *
 */

public class TestBase64 {

	public static String src = "流金岁月人去楼空";
	
	public static void main(String[] args) {
		jdkBase64();
		ccBase64();
		bcBase64();
	}
	
	public static void jdkBase64() {
		try {
			BASE64Encoder encoder = new BASE64Encoder();
			String encode = encoder.encode(src.getBytes());
			System.out.println("jdk encode: " + encode);

			BASE64Decoder decoder = new BASE64Decoder();
			System.out.println("jdk decode: " + new String(decoder.decodeBuffer(encode)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void ccBase64() {
		byte[] encodeBytes = Base64.encodeBase64(src.getBytes());
		System.out.println("cc encode: " + new String(encodeBytes));
		
		byte[] decodeBytes = Base64.decodeBase64(encodeBytes);
		System.out.println("cc decode: " + new String(decodeBytes));
	}
	
	public static void bcBase64() {
		byte[] encodeBytes = org.bouncycastle.util.encoders.Base64.encode(src.getBytes());
		System.out.println("bc encode: " + new String(encodeBytes));
		
		byte[] decodeBytes = Base64.decodeBase64(encodeBytes);
		System.out.println("bc decode: " + new String(decodeBytes));

	}
	
	
}
