package com.bestlove.test;
/**
 * 不用Public修饰类也是可以的
 * @author think
 *
 */
class ShowPropreties {

	public static void main(String[] args) {
		
		System.getProperties().list(System.out);
		System.out.println(System.getProperty("os.name"));
	}
	
}
