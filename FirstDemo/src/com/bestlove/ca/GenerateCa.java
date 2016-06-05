package com.bestlove.ca;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;

/**
 * 导出Cert
 * @author think
 *
 */

public class GenerateCa {

	private static String certPath = "D:/best.cer";
	
	public static void main(String[] args) {
		BaseCert baseCert = new BaseCert();
		X509Certificate certificate = baseCert.generateCert("BEST");
		System.out.println(certificate.toString());
		
		//导出cer证书
		FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream(certPath);
			fileOutputStream.write(certificate.getEncoded());
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (CertificateEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
