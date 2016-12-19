package com.bestlove.generics;

/**
 * 因为有了擦除，数组的运行时类型就只能是Object[]
 * @author think
 *
 * @param <T>
 */

public class GenericArray<T> {

	private T[] array;
	@SuppressWarnings("unchecked")
	public GenericArray(int sz) {
		array = (T[]) new Object[sz];
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
		
		GenericArray<Integer> gai = new GenericArray<Integer>(10);
		gai.put(1, 1);
		gai.put(2, 13);
//		Integer[] oa = gai.rep();//抛错，类型被擦除
		Object[] oa = gai.rep();
 		for (Object obj : oa) {
			System.out.println(obj);
			if(obj!=null){
				System.out.println(obj.getClass().getCanonicalName());
			}
		}
	}
	
}
