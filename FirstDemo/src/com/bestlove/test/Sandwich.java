package com.bestlove.test;

/**
 * 组合、继承以及多态在构建顺序上的作用
 * 1、调用基类构造器。这个步骤会不断地反复递归下去，首先是构造器这种层次结构的根，
 * 	   然后是下一层导出类，等等，直到最底层的导出类。
 * 2、按声明顺序调用成员的初始化方法。
 * 3、调用导出类构造器的主体
 * @author think
 *
 */

public class Sandwich extends PortableLunch{

	private Bread b = new Bread();
	private Cheese c = new Cheese();
	private Lettuce l = new Lettuce();
	public Sandwich() {
		System.out.println("Sandwich.Sandwich()");
	}
	public static void main(String[] args) {
		new Sandwich();
		/**
		 * 结果
		 * Meal.Meal()
		 * Lunch.Lunch()
		 * PortableLunch.PortableLunch()
		 * Bread.Bread()
	     * Cheese.Cheese()
		 * Lettuce.Lettuce()
		 * Sandwich.Sandwich()
		 */
	}
}

class Meal {
	Meal() {
		System.out.println("Meal.Meal()");
	}
}

class Bread {
	Bread() {
		System.out.println("Bread.Bread()");
	}
}

class Cheese {
	Cheese() {
		System.out.println("Cheese.Cheese()");
	}
}

class Lettuce {
	Lettuce() {
		System.out.println("Lettuce.Lettuce()");
	}
}

class Lunch extends Meal {
	Lunch() {
		System.out.println("Lunch.Lunch()");
	}
}

class PortableLunch extends Lunch {
	PortableLunch() {
		System.out.println("PortableLunch.PortableLunch()");
	}
}
