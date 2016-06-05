package com.bestlove.ca;


/**
 * 配置接口
 * @author think
 *
 */

public interface CAConfig {

	String CA_C = "CN";
	String CA_ST = "BJ";
	String CA_L = "BJ";
	String CA_O = "SICCA";
	
	String CA_ROOT_ISSUER = "C=CN,ST=BJ,L=BJ,O=SICCA,OU=SC,CN=SICCA";
	
	String CA_DEFAULT_SUBJECT = "C=CN,ST=BJ,L=BJ,O=SICCA,OU=SC,CN=";
	
	String CA_SHA = "SHA1WithRSAEncryption";
}
