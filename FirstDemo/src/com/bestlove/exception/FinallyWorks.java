package com.bestlove.exception;


/**
 * finally 的运用
 * @author think
 *
 */

public class FinallyWorks {

	static int count = 0;
	public static void main(String[] args) {
		while (true) {
			try {
				if(count++ == 0){
					throw new ThreeException();
				}
				System.out.println("No exception");
			} catch (ThreeException e) {
				System.out.println("ThreeException...");
			} finally {
				//最终都会被执行
				System.out.println("In finally clause");
				if(count == 3){
					break;
				}
			}
		}
	}
}

class ThreeException extends Exception {}