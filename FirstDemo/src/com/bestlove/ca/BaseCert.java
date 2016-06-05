package com.bestlove.ca;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.cert.X509Certificate;

import javax.security.auth.x500.X500Principal;


import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.x509.X509V3CertificateGenerator;


/**
 * 制作Cert
 * @author think
 *
 */

@SuppressWarnings("all")
public class BaseCert {

	static {
		Security.addProvider(new BouncyCastleProvider());
	}
	
	protected static KeyPairGenerator kpg = null;
	
	public BaseCert() {
		
		try {
			//使用RSA非对称加密算法加密
			kpg = KeyPairGenerator.getInstance("RSA");
			//初始化为1024位
			kpg.initialize(1024);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	public X509Certificate generateCert(String user) {
		X509Certificate cert = null;
		try {
			KeyPair keyPair = this.kpg.generateKeyPair();
			//公钥
			PublicKey publicKey = keyPair.getPublic();
			//私钥
			PrivateKey privateKey = keyPair.getPrivate();
			X509V3CertificateGenerator certGen = new X509V3CertificateGenerator();
			//设置序列号
			certGen.setSerialNumber(new BigInteger(String.valueOf(DateUtil.getCurrentDate().getTime())));
			//设置颁发者
			certGen.setIssuerDN(new X500Principal(CAConfig.CA_ROOT_ISSUER));
			//设置有效期
			certGen.setNotBefore(DateUtil.getCurrentDate());
			certGen.setNotAfter(DateUtil.getNextYearDate());
			//设置使用者
			certGen.setSubjectDN(new X500Principal(CAConfig.CA_DEFAULT_SUBJECT + user ));
			//公钥
			certGen.setPublicKey(publicKey);
			//签名算法
			certGen.setSignatureAlgorithm(CAConfig.CA_SHA);
			cert = certGen.generateX509Certificate(privateKey, "BC");
		} catch (Exception e) {
			System.out.println(e.getClass() + e.getMessage());
		}
		return cert;
	}
	
	
}
