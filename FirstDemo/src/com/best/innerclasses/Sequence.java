package com.best.innerclasses;

/**
 * 当生成一个内部类的对象时，此对象与制造它的外围对象之间就有了
 * 一种联系，所以它能访问其外围对象的所有成员，而不需要任何特殊
 * 条件。此外，内部类还拥有其外围类的所有元素的访问权。
 * @author think
 *
 */

interface Selector {
	boolean end();
	Object current();
	void next();
}

public class Sequence {
	private Object[] items;
	private int next = 0;
	public Sequence(int size) {
		items = new Object[size];
	}
	public void add(Object x) {
		if (next < items.length) {
			items[next++] = x;
		}
	}
	private class SequenceSelector implements Selector {

		private int i = 0;
		
		@Override
		public boolean end() {
			return i==items.length;
		}

		@Override
		public Object current() {
			return items[i];
		}

		@Override
		public void next() {
			if (i < items.length) {
				i++;
			}
		}
	}
	public Selector selector() {
		return new SequenceSelector();
	}
	public static void main(String[] args) {
		Sequence sequence = new Sequence(10);
		for (int i = 0; i < 10; i++) {
			sequence.add(Integer.toString(i));
		}
		Selector selector = sequence.selector();
		while(!selector.end()) {
			System.out.print(selector.current() + " ");
			selector.next();
		}
	}
}
