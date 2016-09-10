package com.bestlove.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * foreach 与 适配器方法
 * @author think
 *
 */

public class AdapterMethodIdiom {
	
	public static void main(String[] args) {
		
		ReversibleArrayList<String> ral = new ReversibleArrayList<String>(Arrays.asList("To be or not to be".split(" ")));
		for (String string : ral) {//正序
			System.out.println(string);
		}
		
		for (String string : ral.reversed()) {//倒序
			System.out.println(string);
		}
		
	}

}


class ReversibleArrayList<T> extends ArrayList<T> {
	private static final long serialVersionUID = 1L;
	public ReversibleArrayList(Collection<T> c) {
		super(c);
	}
	public Iterable<T> reversed() {//写的一个倒序方法
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return new Iterator<T>() {
					int current = size() - 1;
					@Override
					public boolean hasNext() {
						return current > -1;
					}

					@Override
					public T next() {
						return get(current--);
					}
					
					public void remove() {
						throw new UnsupportedOperationException();
					}
				
				};
			}
		};
	}
}
