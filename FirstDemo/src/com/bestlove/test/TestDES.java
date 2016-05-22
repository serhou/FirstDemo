package com.bestlove.test;


import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * 对称加密解密算法-DES
 * @author think
 *
 */

public class TestDES {

	public static String src = "苍天可老，海水可干";
	
	public static void main(String[] args) {
		
		jdkDES();
		bcDES();
		
	}
	
	public static void jdkDES() {
		try {
			//生成key
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
			keyGenerator.init(56);
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] byteKey = secretKey.getEncoded();
			
			//转换Key
			DESKeySpec desKeySpec = new DESKeySpec(byteKey);
			SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
			Key convertSecretKey = factory.generateSecret(desKeySpec);
		
			//加密
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
			byte[] result = cipher.doFinal(src.getBytes());
			System.out.println("jdk des encrypt: " + Hex.encodeHexString(result));
			
			//解密
			cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
			result = cipher.doFinal(result);
			System.out.println("jdk des decrypt: " + new String(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void bcDES() {
		try {
			
			Security.addProvider(new BouncyCastleProvider());
			
			//生成key
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DES", "BC");
			keyGenerator.init(56);
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] byteKey = secretKey.getEncoded();
			
			//转换Key
			DESKeySpec desKeySpec = new DESKeySpec(byteKey);
			SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
			Key convertSecretKey = factory.generateSecret(desKeySpec);
		
			//加密
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
			byte[] result = cipher.doFinal(src.getBytes());
			System.out.println("bc des encrypt: " + Hex.encodeHexString(result));
			
			//解密
			cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
			result = cipher.doFinal(result);
			System.out.println("bc des decrypt: " + new String(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
