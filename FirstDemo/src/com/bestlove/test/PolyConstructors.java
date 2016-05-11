package com.bestlove.test;

/**
 * 初始化的实际过程是：
 * 1、在其他任何事物发生之前，将分配给对象的存储空间初始化成二进制的零
 * 2、调用基类构造器，此时，调用被覆盖后的draw()方法，（要在调用RoundGlyph构造器之前调用），由于步骤1的缘故，我们发现此时radius的值为0
 * 3、按照声明的顺序调用成员的初始化方法
 * 4、调用导出类的构造器主体
 * 
 * 这个程序的结果令人相当吃惊，在逻辑方面，我们做的已经十分完美，而它的行为却不可思议地错了，并且编译器也没有报错。
 * 诸如此类的错误会很容易被人忽略，而且要花很长的时间才能发现。
 * 因此，编写构造器时由一条有效的准则：“用尽可能简单的方法使对象进入正常状态；如果可以的话，避免调用其他方法”。
 * 在构造器内唯一能够安全调用的那些方法是基类中的final方法（也适用于private方法，它们自动属于final方法）。
 * 这些方法不能被覆盖，因此也就不会出现上述令人惊讶的问题。
 * 
 * 你可能无法总是能够遵循这条准侧，但是应该朝着它努力！！！
 * 
 * @author think
 *
 */


public class PolyConstructors {

	public static void main(String[] args) {
		new RoundGlyph(5);
	}
	
}
 
class Glyph {
	void draw() {
		System.out.println("Glyph.draw()");
	}
	Glyph() {
		System.out.println("Glyph() before draw()");
		draw();  //实际调用的是RoundGlyph.draw(), radius = 0   RoundGlyph对象还没有被创建呢
		System.out.println("Glyph() after draw()");
	}
}

class RoundGlyph extends Glyph {
	private int radius = 1;
	RoundGlyph(int i) {
		radius = i;
		System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
	}
	void draw() {
		System.out.println("RoundGlyph.draw(), radius = " + radius);
	}
}
