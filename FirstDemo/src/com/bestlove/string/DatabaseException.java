package com.bestlove.string;

/**
 * 当只需使用format()方法一次的时候，String.format()用起来很方便
 * 其实，在String.format()内部，它也是创建一个Formatter对象，然后
 * 将你传入的参数转给改Formatter。不过，与其自己做这些事情，不如使用
 * 便捷的String.format()方法，何况这样的代码更清晰易读。
 * @author think
 *
 */

public class DatabaseException extends Exception {

	public DatabaseException(int transactionID, int queryID, String message) {
		super(String.format("(t%d, q%d) %s", transactionID, queryID, message));
	}
	
	public static void main(String[] args) {
		
		
		try {
			throw new DatabaseException(3, 7, "Write failed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
