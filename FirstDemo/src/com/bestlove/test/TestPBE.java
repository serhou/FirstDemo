package com.bestlove.test;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.apache.commons.codec.binary.Base64;

/**
 * PBE (Password Based Encryption)基于口令加密算法
 * 对已有算法的包装MD5和DES等
 * 盐
 * PBEWithMD5AndDES等
 * @author think
 *
 */

public class TestPBE {
	
	public static String src = "一生痴绝处，无梦到徽州";

	public static void main(String[] args) {
		jdkPBE();
	}
	
	public static void jdkPBE() {
		try {
			//初始化盐
			SecureRandom random = new SecureRandom();
			byte[] salt = random.generateSeed(8);

			//口令与密钥
			String password = "bestlove";
			PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray());
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBEWITHMD5andDES");
			Key key = factory.generateSecret(pbeKeySpec);
		
			//加密
			PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(salt, 100);
			Cipher cipher = Cipher.getInstance("PBEWITHMD5andDES");
			cipher.init(Cipher.ENCRYPT_MODE, key, pbeParameterSpec);
			byte[] result = cipher.doFinal(src.getBytes());
			System.out.println("jdk pbe encrypt: " + Base64.encodeBase64String(result));
		
			//解密
			cipher.init(Cipher.DECRYPT_MODE, key, pbeParameterSpec);
			result = cipher.doFinal(result);
			System.out.println("jdk pbe decrypt: " + new String(result));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}
	
}
