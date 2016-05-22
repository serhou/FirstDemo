package com.bestlove.test;


import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;

/**
 * 消息摘要算法-MAC
 * 
 * 也叫HMAC算法：含有密钥的散列函数算法
 * 
 * MD系列
 * 
 * SHA系列
 * 
 * @author think
 *
 */

public class TestHMAC {

	public static String src = "愿用家财万贯，买个太阳不下山";
	
	public static void main(String[] args) {
		jdkHmacMD5();
		bcHmacMD5();
	}
	
	public static void jdkHmacMD5() {
		try {
			//初始化KeyGenerator
			KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
			//产生密钥
			SecretKey secretKey = keyGenerator.generateKey();
			//获得密钥
			byte[] key = secretKey.getEncoded();
			
			//这里使用和bcHmacMD5()方法相同的结果
//			key = Hex.decodeHex(new char[]{'a','a','a','a'});
			
			//还原密钥
			SecretKey restoreSecretKey = new SecretKeySpec(key, "HmacMD5");
			//实例化MAC
			Mac mac = Mac.getInstance(restoreSecretKey.getAlgorithm());
			//初始化Mac
			mac.init(restoreSecretKey);
			//执行摘要
			byte[] hmacMD5Bytes = mac.doFinal(src.getBytes());
			System.out.println("jdk hmacMD5 : " + Hex.encodeHexString(hmacMD5Bytes));
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static void bcHmacMD5() {
		HMac hMac = new HMac(new MD5Digest());
		hMac.init(new KeyParameter(org.bouncycastle.util.encoders.Hex.decode("aaaa")));
		hMac.update(src.getBytes(), 0, src.getBytes().length);
		byte[] hmacMD5Bytes = new byte[hMac.getMacSize()];
		hMac.doFinal(hmacMD5Bytes, 0);
		//与前面结果不同，因为初始化的内容不同
		System.out.println("bc hmacMD5 : " + org.bouncycastle.util.encoders.Hex.toHexString(hmacMD5Bytes));
	}
	
	
}
