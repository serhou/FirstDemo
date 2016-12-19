package com.bestlove.generics;

/**
 * HoldItem直接持有一个对象，因此这种行为被继承到了Colored2中，
 * 它也要求其参数与HasColor一致。ColoredDimension2和Solid2
 * 进一步扩展了这个层次结构，并在每个层次上都添加了边界。
 * 现在这些方法被继承，因为不必在每个类中重复
 * @author think
 *
 */

public class InheritBounds {

	public static void main(String[] args) {
		Solid2<Bounded> solid2 = new Solid2<Bounded>(new Bounded());
		System.out.println(solid2.color());
		System.out.println(solid2.getZ());
		System.out.println(solid2.weight());
	}
	
}

class HoldItem<T> {
	T item;
	HoldItem(T item) {
		this.item = item;
	}
	T getItem() {
		return item;
	}
}

class Colored2<T extends HasColor> extends HoldItem<T> {
	Colored2(T item) {
		super(item);
	}
	java.awt.Color color() {
		return item.getColor();
	}
}

class ColoredDimension2<T extends Dimension & HasColor> extends Colored2<T> {
	ColoredDimension2(T item) {
		super(item);
	}
	int getX() {
		return item.x;
	}
	int getY() {
		return item.y;
	}
	int getZ() {
		return item.z;
	}
}

class Solid2<T extends Dimension & HasColor & Weight> extends ColoredDimension2<T> {
	Solid2(T item) {
		super(item);
	}
	int weight() {
		return item.weight();
	}
}