package com.bestlove.test;

/**
 * 接口
 * 一个接口表示：所有实现了该特定接口的类看起来都像这样。
 * interface这个关键字产生一个完全抽象的类，它根本就没有提供任何具体的实现
 * 它允许创建者确定方法名、参数列表和返回值类型，但是没有任何方法体。
 * 接口只提供了形式，而未提供任何具体实现
 * 接口也可以包含域，但是这些域隐式地是static和final的
 * 
 * 要注意的是，在接口中的每一个方法确实都只是一个声明，这是编译器所允许的在接口中唯一能够存在的事物
 * 
 * @author think
 *
 */

public class Music5 {
	static void tune(Instrument5 i5) {
		i5.play(Note.B_FLAT);
	}
	static void tuneAll(Instrument5[] i5) {
		for (Instrument5 instrument5 : i5) {
			tune(instrument5);
		}
	}
	public static void main(String[] args) {
		Instrument5[] i5s = {
			new Wind5(),
			new Percussion5(),
			new Stringed5(),
			new Brass5(),
			new Woodwind5()
		};
		tuneAll(i5s);
	}
}

interface Instrument5 {
	int VALUE = 5; //static & final
	void play(Note n); //Automatically public
	void adjust();
}

class Wind5 implements Instrument5 {

	public void play(Note n) {
		System.out.println(this + ".play()" + n);
	}

	public void adjust() {
		System.out.println(this + ".adjust()");
	}
	
	public String toString() {
		return "Wind5";
	}
}

class Percussion5 implements Instrument5 {

	public void play(Note n) {
		System.out.println(this + ".play()" + n);
	}

	public void adjust() {
		System.out.println(this + ".adjust()");
	}
	
	public String toString() {
		return "Percussion5";
	}
	
}

class Stringed5 implements Instrument5 {

	public void play(Note n) {
		System.out.println(this + ".play()" + n);
	}

	public void adjust() {
		System.out.println(this + ".adjust()");
	}
	
	public String toString() {
		return "Stringed5";
	}
	
}

class Brass5 extends Wind5 {
	public String toString() {
		return "Brass5";
	}
}

class Woodwind5 extends Wind5 {
	public String toString() {
		return "Woodwind5";
	}
}

