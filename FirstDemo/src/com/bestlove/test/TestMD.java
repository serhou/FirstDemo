package com.bestlove.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD4Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * MD 算法实现
 * @author think
 *
 */

public class TestMD {

	public static String src = "我这人平生最怕麻烦，但麻烦却总是找上我！";
	
	public static void main(String[] args) {
		jdkMD5();
		jdkMD2();
		ccMD5();
		ccMD2();
		bcMD5();
		bcMD4();
	}
	
	public static void jdkMD5() {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] md5Bytes = md.digest(src.getBytes());
			System.out.println("jdk MD5: "+Hex.encodeHexString(md5Bytes));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	public static void jdkMD2() {
		try {
			MessageDigest md = MessageDigest.getInstance("MD2");
			byte[] md2Bytes = md.digest(src.getBytes());
			System.out.println("jdk MD2: "+Hex.encodeHexString(md2Bytes));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	public static void ccMD5() {
		//基于JDK的封装简化操作
		System.out.println("CC MD5: "+DigestUtils.md5Hex(src.getBytes()));
	}
	
	public static void ccMD2() {
		System.out.println("CC MD2: "+DigestUtils.md2Hex(src.getBytes()));
	}
	
	public static void bcMD5() {
		Digest digest = new MD5Digest();
		digest.update(src.getBytes(), 0, src.getBytes().length);
		byte[] md5Bytes = new byte[digest.getDigestSize()];
		digest.doFinal(md5Bytes, 0);
		System.out.println("BC MD5: " + org.bouncycastle.util.encoders.Hex.toHexString(md5Bytes));
	}
	
	public static void bcMD4() {
		System.out.println("--------第一种MD4--------");
		try {
			Security.addProvider(new BouncyCastleProvider());
			MessageDigest md = MessageDigest.getInstance("MD4");
			byte[] md4bytes = md.digest(src.getBytes());
			System.out.println("BC MD4: " + Hex.encodeHexString(md4bytes));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("--------第二种MD4--------");
		Digest digest = new MD4Digest();
		digest.update(src.getBytes(), 0, src.getBytes().length);
		byte[] md4Bytes = new byte[digest.getDigestSize()];
		digest.doFinal(md4Bytes, 0);
		System.out.println("BC MD4: " + org.bouncycastle.util.encoders.Hex.toHexString(md4Bytes));
	}
}
