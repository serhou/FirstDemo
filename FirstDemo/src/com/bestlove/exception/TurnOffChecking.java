package com.bestlove.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * “被检查的异常”转换为“不检查的异常”，即运行时异常
 * @author think
 *
 */

class WrapCheckedException {
	void throwRuntimeException(int type) {
		try {
			switch (type) {
			case 0:
				throw new FileNotFoundException();
			case 1:
				throw new IOException();
			case 2:
				throw new RuntimeException("Where am I?");
			default:
				return;//不抛异常
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}


public class TurnOffChecking {
	
	public static void main(String[] args) {
		
		WrapCheckedException wce = new WrapCheckedException();
		wce.throwRuntimeException(3);//直接返回，没有异常
		
		for (int i = 0; i < 4; i++) {
			try {
				if(i < 3){//有异常的时候
					wce.throwRuntimeException(i);//0 1 2
				}else{
					throw new SomeOtherException(new Throwable("例外啊")); //3
				}
			} catch (RuntimeException e) {
				try {
					throw e.getCause();
				} catch (FileNotFoundException e2) {
					System.out.println("FileNotFoundException: " + e2); //0
				} catch (IOException e2) {
					System.out.println("IOException: " + e2); //1
				} catch (Throwable e1) {
					System.out.println("Throwable: " + e1); //2 3
				}
			}
		}
		
	}

}

class SomeOtherException extends RuntimeException {
	
	public SomeOtherException(Throwable throwable) {
		super(throwable);
	}
	
}
