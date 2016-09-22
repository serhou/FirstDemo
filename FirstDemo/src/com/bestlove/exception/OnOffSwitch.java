package com.bestlove.exception;


/**
 * 当涉及break和continue语句的时候，finally子句也会得到执行。
 * 请注意，如果把finally子句和带标签的break及continue配合使用，
 * 在java里就没有必要使用goto语句了
 * @author think
 *
 */

public class OnOffSwitch {

	private static Switch sw = new Switch();
	public static void f() throws OnOffException1, OnOffException2 {};
	public static void main(String[] args) {
		try {
			sw.on();
			f();
			//sw.off();
		} catch (OnOffException1 e) {
			System.out.println("OnOffException1");
			//sw.off();
		} catch (OnOffException2 e) {
			System.out.println("OnOffException2");
			//sw.off();
		} finally {
			//总会被执行，无论异常与否
			sw.off();
		}
	}
	
}

class OnOffException1 extends Exception {};
class OnOffException2 extends Exception {};

class Switch {
	private boolean state = false;
	public boolean read() {
		return state;
	}
	public void on() {
		state = true;
		System.out.println("on");
	}
	public void off() {
		state = false;
		System.out.println("off");
	}
}