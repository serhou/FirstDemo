package com.bestlove.test;

/**
 * 抽象类和抽象方法
 * 包含抽象方法的类叫抽象类。如果一个类包含一个或多个抽象方法，
 * 该类必须被限定为抽象的。
 * 
 * 如果从一个抽象类继承，并想创建该类的对象，那么就必须为基类中的所有抽象方法
 * 提供方法定义，这是方法的实现。如果不这样做（可以选择不做），那么导出类便也
 * 是抽象类，且编译器将会强制我们用abstact关键字来限定这个类。
 * 
 * 抽象类中也可以有普通方法
 * 
 * 
 * @author think
 *
 */


public class Music4 {

	static void tune(Instrument4 i4) {
		i4.play(Note.MIDDLE_C);
	}
	static void tuneAll(Instrument4[] i4) {
		for (Instrument4 instrument4 : i4) {
			tune(instrument4);
		}
	}
	public static void main(String[] args) {
		Instrument4[] orchestra = {
				new Wind4(),
				new Percussion4(),
				new Stringed(),
				new Brass(),
				new Woodwind()
		};
		tuneAll(orchestra);
		DefiniteClass definiteClass = new DefiniteClass();
		definiteClass.song();
		definiteClass.see();
	}
}

abstract class Instrument4 {
	private int i;
	public abstract void play(Note n);
	public String what() {
		return "Instrument4" + i;
	}
	public abstract void adjust();
}

class Wind4 extends Instrument4 {
	//抽象方法一定要被实现
	public void play(Note n) {
		System.out.println("Wind4.play() " + n);
	}

	public void adjust() {}
	
	public String what() {
		return "Wind4";
	}
	
}

class Percussion4 extends Instrument4 {

	public void play(Note n) {
		System.out.println("Percussion4.play() " + n);
	}

	public void adjust() {}
	
	public String what() {
		return "Percussion";
	}
	
}

class Stringed extends Instrument4 {

	public void play(Note n) {
		System.out.println("Stringed.play() " + n);
	}

	public void adjust() {}
	
	public String what() {
		return "Stringed";
	}
}

class Brass extends Wind4 {
	public void play(Note n) {
		System.out.println("Brass.play() " + n);
	}
	public void adjust() {
		System.out.println("Brass.adjust()");
	}
}

class Woodwind extends Wind4 {
	public void play(Note n) {
		System.out.println("Woodwind.play() " + n);
	}
	public String what() {
		return "Woodwind";
	}
}
//抽象类可以没有抽象方法，但是和一般的类又有什么区别呢？也就没有了意义
abstract class AbstactClass {
	public void see() {
		System.out.println("没有什么能够阻挡");
	}
}

class DefiniteClass extends AbstactClass {
	public void song() {
		System.out.println("唱只小曲");
	}
}


