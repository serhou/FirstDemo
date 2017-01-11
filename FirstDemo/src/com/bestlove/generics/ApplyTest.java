package com.bestlove.generics;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 反射和可变参数实现潜在类型机制
 * 必须放置边界和通配符，以便使Apply和FilledList
 * 在所有需要的情况下都可以使用
 * @author think
 *
 */

public class ApplyTest {
	public static void main(String[] args) throws Exception, SecurityException {
		List<Shape> shapes = new ArrayList<Shape>();
		for (int i = 0; i < 10; i++) {
			shapes.add(new Shape());
		}
		Apply.apply(shapes, Shape.class.getMethod("rotate"));
		Apply.apply(shapes, Shape.class.getMethod("resize", int.class), 5);
		List<Square> squares = new ArrayList<Square>();
		for (int i = 0; i < 3; i++) {
			squares.add(new Square());
		}
		Apply.apply(squares, Shape.class.getMethod("rotate"));
		Apply.apply(squares, Shape.class.getMethod("resize", int.class), 6);
		
		Apply.apply(new FilledList<Shape>(Shape.class, 8), Shape.class.getMethod("rotate"));
		Apply.apply(new FilledList<Shape>(Square.class, 13), Shape.class.getMethod("rotate"));
		
		SimpleQueue<Shape> shapeQ = new SimpleQueue<Shape>();
		for (int i = 0; i < 5; i++) {
			shapeQ.add(new Shape());
			shapeQ.add(new Square());
		}
		Apply.apply(shapeQ, Shape.class.getMethod("rotate"));
	}
}

class Apply {
	public static <T, S extends Iterable<? extends T>> 
		void apply(S seq, Method f, Object... args) {
		try {
			for (T t : seq) {
				f.invoke(t, args);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

class Shape {
	public void rotate() {
		System.out.println(this + " rotate");
	}
	public void resize(int newSize) {
		System.out.println(this + " resize " + newSize);
	}
}

class Square extends Shape {}

class FilledList<T> extends ArrayList<T> {
	public FilledList(Class<? extends T> type, int size) {
		try {
			for (int i = 0; i < size; i++) {
				add(type.newInstance());
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

class SimpleQueue<T> implements Iterable<T> {
	private LinkedList<T> storage = new LinkedList<T>();
	public void add(T t) {
		storage.add(t);
	}
	public T get() {
		return storage.poll();
	}
	@Override
	public Iterator<T> iterator() {
		return storage.iterator();
	}
}