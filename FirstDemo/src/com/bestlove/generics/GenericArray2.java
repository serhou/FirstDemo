package com.bestlove.generics;

public class GenericArray2<T> {

	private Object[] array;
	public GenericArray2(int sz) {
		array = new Object[sz];
	}
	public void put(int index, T item) {
		array[index] = item;
	}
	@SuppressWarnings("unchecked")
	public T get(int index) {
		return (T) array[index];
	}
	@SuppressWarnings("unchecked")
	public T[] rep() {
		return (T[]) array;
	}
	public static void main(String[] args) {
		int size = 12;
		GenericArray2<Integer> gai = new GenericArray2<Integer>(size);
		for (int i = 0; i < size; i++) {
			gai.put(i, i);
		}
		for (int i = 0; i < size; i++) {
			System.out.print(gai.get(i) + " ");
		}
		System.out.println();
		try {
			Integer[] ia = gai.rep();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
