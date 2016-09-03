package com.bestlove.collection;

import java.util.Iterator;

/**
 * iterator()方法返回的是实现了Iterator<String> 的匿名内部类的实例
 * 该匿名内部类可以遍历数组中的所有单词
 * @author think
 *
 */

public class IterableClass implements Iterable<String>{

	protected String[] words = ("And that is how we know the Earth to be banana-shaped.".split(" "));
	
	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {
			private int index = 0;
			@Override
			public boolean hasNext() {
				return index < words.length;
			}

			@Override
			public String next() {
				return words[index++];
			}
			
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	
	public static void main(String[] args) {
		for (String string : new IterableClass()) {
			System.out.println(string);
		}
	}
}
