package com.bestlove.test;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Hex;

/**
 * 数字签名算法-ECDSA
 * 
 * 数字签名——带有密钥（公钥、私钥）的消息摘要算法
 * 
 * 验证数据完整性、认证数据来源、抗否认
 * 
 * OSI参考模型
 * 
 * 私钥签名、公钥验证
 * 
 * @author think
 *
 */

public class TestECDSA {

	public static String src = "人在江湖，身不由己";
	
	public static void main(String[] args) {
		jdkECDSA();
	}
	
	public static void jdkECDSA() {
		try {
			//1、初始化密钥
			KeyPairGenerator keyPairGenerator = KeyPairGenerator
					.getInstance("EC");
			keyPairGenerator.initialize(256);
			KeyPair keyPair = keyPairGenerator.generateKeyPair();
			ECPublicKey ecPublicKey = (ECPublicKey) keyPair.getPublic();
			ECPrivateKey ecPrivateKey = (ECPrivateKey) keyPair.getPrivate();
			
			//2、执行签名
			PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(ecPrivateKey.getEncoded());
			KeyFactory keyFactory = KeyFactory.getInstance("EC");
			PrivateKey privateKey =  keyFactory.generatePrivate(pkcs8EncodedKeySpec);
			Signature signature = Signature.getInstance("SHA1withECDSA");
			signature.initSign(privateKey);
			signature.update(src.getBytes());
			byte[] result = signature.sign();
			System.out.println("jdk ecdsa sign : " + Hex.encodeHexString(result));
			
			//3、验证签名
			X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(ecPublicKey.getEncoded());
			keyFactory = KeyFactory.getInstance("EC");
			PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
			signature = Signature.getInstance("SHA1withECDSA");
			signature.initVerify(publicKey);
			signature.update(src.getBytes());
			boolean b = signature.verify(result);
			System.out.println("jdk ecdsa verify :" + b);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
