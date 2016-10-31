package com.bestlove.string;

import java.io.PrintStream;
import java.util.Formatter;

/**
 * 在Java中，所有新的格式化功能都由java.util.Formatter类处理。
 * 可以将Formatter看作一个翻译器，它将你的格式化字符串与数据
 * 翻译成需要的结果
 * @author think
 *
 */

public class Turtle {

	private String name;
	private Formatter f;
	public Turtle(String name, Formatter f) {
		this.name = name;
		this.f = f;
	}
	public void move(int x, int y){
		f.format("%s The Turtle is at (%d, %d)\n", name, x, y);
	}
	public static void main(String[] args) {
		
		PrintStream outAlias = System.out;
		Turtle tommy = new Turtle("Tommy", new Formatter(System.out));
		Turtle terry = new Turtle("Terry", new Formatter(outAlias));
	
		tommy.move(0, 0);
		terry.move(4, 8);
		tommy.move(3, 4);
		terry.move(2, 5);
		tommy.move(3, 3);
		terry.move(3, 3);
	}
	
	
}
