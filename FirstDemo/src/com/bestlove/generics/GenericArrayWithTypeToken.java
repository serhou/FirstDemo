package com.bestlove.generics;

import java.lang.reflect.Array;

public class GenericArrayWithTypeToken<T> {

	private T[] array;
	@SuppressWarnings("unchecked")
	public GenericArrayWithTypeToken(Class<T> type, int sz) {
		array = (T[]) Array.newInstance(type, sz);
	}
	public void put(int index, T item) {
		array[index] = item;
	}
	public T get(int index) {
		return array[index];
	}
	public T[] rep() {
		return array;
	}
	public static void main(String[] args) {
		int size = 12;
		GenericArrayWithTypeToken<Integer> gai = 
				new GenericArrayWithTypeToken<Integer>(Integer.class, size);
		for (int i = 0; i < size; i++) {
			gai.put(i, i & 2 | 9 ^ 5 >> ~7 << 13 >>> 87);
		}
		Integer[] ia = gai.rep();
		for (Integer integer : ia) {
			System.out.println(integer);
		}
	}
}
