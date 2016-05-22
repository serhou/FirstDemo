package com.bestlove.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

/**
 * 消息摘要算法-SHA
 * @author think
 *
 */


public class TestSHA {

	public static String src = "青春少年时样样红，你是主人翁";
	
	public static void main(String[] args) {
		jdkSHA1();
		bcSHA1();
		bcSHA224();
		bcSHA224_2();
		ccSHA1();
	}

	public static void jdkSHA1() {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA");
			md.update(src.getBytes());
			byte[] sha1byte = md.digest();
			System.out.println("jdk sha1 : " + Hex.toHexString(sha1byte));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	public static void bcSHA1() {
		Digest digest = new SHA1Digest();
		digest.update(src.getBytes(), 0, src.getBytes().length);
		byte[] sha1bytes = new byte[digest.getDigestSize()];
		digest.doFinal(sha1bytes, 0);
		System.out.println("bc sha1 : " + Hex.toHexString(sha1bytes));
	}
	
	public static void bcSHA224() {
		Digest digest = new SHA224Digest();
		digest.update(src.getBytes(), 0, src.getBytes().length);
		byte[] sha224Bytes = new byte[digest.getDigestSize()];
		digest.doFinal(sha224Bytes, 0);
		System.out.println("bc sha224_1 : " + Hex.toHexString(sha224Bytes));
	}
	
	public static void bcSHA224_2() {
		try {
			Security.addProvider(new BouncyCastleProvider());
			MessageDigest md = MessageDigest.getInstance("SHA224");
			md.update(src.getBytes());
			byte[] sha224byte = md.digest();
			System.out.println("bc sha224_2 : " + Hex.toHexString(sha224byte));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void ccSHA1() {
		System.out.println("cc sha1_1 : " + DigestUtils.sha1Hex(src.getBytes()));
		System.out.println("cc sha1_2 : " + DigestUtils.sha1Hex(src));
	}
	
}
