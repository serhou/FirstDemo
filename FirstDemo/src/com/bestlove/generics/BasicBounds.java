package com.bestlove.generics;

import java.awt.Color;

/**
 * 泛型边界：继承类和接口（类在前，接口在后）
 * @author think
 *
 */

public class BasicBounds {
	public static void main(String[] args) {
		
		Solid<Bounded> solid = new Solid<Bounded>(new Bounded());
		System.out.println(solid.color());
		System.out.println(solid.getX());
		System.out.println(solid.weight());
	}
}

interface HasColor {
	java.awt.Color getColor();
}

class Colored<T extends HasColor> {//类则不能继承接口
	T item;
	Colored(T item) {
		this.item = item;
	}
	T getItem() {
		return item;
	}
	java.awt.Color color() {
		return item.getColor();
	}
}

class Dimension {
	public int x, y, z;
}

//class ColoredDimension2<T extends HasColor & Dimension> {}//错误

class ColoredDimension<T extends Dimension & HasColor> {
	T item;
	ColoredDimension(T item) {
		this.item = item;
	}
	T getItem() {
		return item;
	}
	java.awt.Color color() {
		return item.getColor();
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

interface Weight {
	int weight();
}

class Solid<T extends Dimension & HasColor & Weight> {
	T item;
	Solid(T item) {
		this.item = item;
	}
	T getItem() {
		return item;
	}
	java.awt.Color color() {
		return item.getColor();
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
	int weight() {
		return item.weight();
	}
}

class Bounded extends Dimension implements HasColor, Weight {
	@Override
	public int weight() {
		return 0;
	}
	@Override
	public Color getColor() {
		return Color.blue;
	}
}