package com.bestlove.exception;

/**
 * 异常丢失
 * 
 * java的异常实现也有瑕疵。异常作为程序出错的标志，决不应该被忽略，
 * 但它还是有可能被轻易地忽略。用某些特殊的方式使用finally子句，
 * 就会发生这种情况
 * @author think
 *
 */

public class LostMessage {

	void f() throws VeryImportantException {
		throw new VeryImportantException();
	}
	
	void dispose() throws HoHumException {
		throw new HoHumException();
	}
	
	public static void main(String[] args) {
		
		try {
			LostMessage lm = new LostMessage();
			try {
				lm.f();
			} finally {
				lm.dispose();//异常被替换
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		//一种更加简单的丢失异常的方式是从finally子句中返回
		try {
			throw new RuntimeException();
		} finally {
			return;//如果运行这个程序，就会看到即使抛出了异常，它也不会产生任何输出
		}
		
	}
	
}

class VeryImportantException extends Exception {
	public String toString() {
		return "A very important exception!";
	}
}

class HoHumException extends Exception {
	public String toString() {
		return "A trivial exception";
	}
}

