package com.bestlove.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.bestlove.util.Generator;

/**
 * 用适配器仿真潜在类型机制
 * @author think
 *
 */

public class Fill2Test {
	public static void main(String[] args) {
		List<Coffee> carrier = new ArrayList<Coffee>();
		Fill2.fill(new AddableCollectionAdapter<Coffee>(carrier), Coffee.class, 3);
		Fill2.fill(Adapter.collectionAdapter(carrier), Latte.class, 4);
		for (Coffee coffee : carrier) {
			System.out.println(coffee);
		}
		System.out.println("-----------------------");
		AddableSimpleQueue<Coffee> coffeeQueue = new AddableSimpleQueue<Coffee>();
		Fill2.fill(coffeeQueue, Mocha.class, 4);
		Fill2.fill(coffeeQueue, Latte.class, 2);
		for (Coffee coffee : coffeeQueue) {
			System.out.println(coffee);
		}
	}
	
}

interface Addable<T> {
	void add(T t);
}

class Fill2 {
	public static <T> void fill(Addable<T> addable, 
			Class<? extends T> classToken, int size) {
		for (int i = 0; i < size; i++) {
			try {
				addable.add(classToken.newInstance());
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public static <T> void fill(Addable<T> addable, 
			Generator<T> generator, int size) {
		for (int i = 0; i < size; i++) {
			try {
				addable.add(generator.next());
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
}

class AddableCollectionAdapter<T> implements Addable<T> {
	private Collection<T> c;
	public AddableCollectionAdapter(Collection<T> c) {
		this.c = c;
	}
	@Override
	public void add(T t) {
		c.add(t);
	}
}

class Adapter {
	public static <T> Addable<T> collectionAdapter(Collection<T> c) {
		return new AddableCollectionAdapter<T>(c);
	}
}

class AddableSimpleQueue<T> extends SimpleQueue<T> implements Addable<T> {
	public void add(T item) {
		super.add(item);//和父类一样，不用重写了吧？
	}
}
