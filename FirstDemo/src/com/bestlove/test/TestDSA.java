package com.bestlove.test;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Hex;

/**
 * 数字签名算法-DSA
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

public class TestDSA {

	public static String src = "我们都有一个家名字叫中国！";
	
	public static void main(String[] args) {
		jdkDSA();
	}
	
	public static void jdkDSA() {
		try {
			//1、生成密钥
			KeyPairGenerator keyPairGenerator = KeyPairGenerator
					.getInstance("DSA");
			keyPairGenerator.initialize(512);
			KeyPair keyPair = keyPairGenerator.generateKeyPair();
			DSAPublicKey dsaPublicKey = (DSAPublicKey) keyPair.getPublic();
			DSAPrivateKey dsaPrivateKey = (DSAPrivateKey) keyPair.getPrivate();
			
			//2、进行签名
			PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(dsaPrivateKey.getEncoded());
			KeyFactory keyFactory = KeyFactory.getInstance("DSA");
			PrivateKey  privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
			Signature signature = Signature.getInstance("SHA1withDSA");
			signature.initSign(privateKey);
			signature.update(src.getBytes());
			byte[] result = signature.sign();
			System.out.println("jdk das sign:" + Hex.encodeHexString(result));
			
			//3、验证签名
			X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(dsaPublicKey.getEncoded());
			keyFactory = KeyFactory.getInstance("DSA");
			PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
			signature = Signature.getInstance("SHA1withDSA");
			signature.initVerify(publicKey);
			signature.update(src.getBytes());
			boolean b =signature.verify(result);
			System.out.println("验证结果：" + b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}
