package com.bestlove.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericWriting {

	static <T> void writeExact(List<T> list, T item) {
		list.add(item);
	}
	
	static List<Apple> apples = new ArrayList<Apple>();
	static List<Fruit> fruits = new ArrayList<Fruit>();
	
	static void f1() {
		writeExact(apples, new Apple());
		writeExact(apples, new Jonathan());
//		writeExact(apples, new Orange());//Error
		writeExact(fruits, new Fruit());
		writeExact(fruits, new Apple());
		writeExact(fruits, new Jonathan());
		writeExact(fruits, new Orange());
	}

	static <T> T read(List<T> list, int index) {
		return list.get(index);
	}
	
	static <T> void writeWithWildcard(List<? super T> list, T item) {
		list.add(item);
	}
	
	static <T> T read2(List<? super T> list, int index) {
		return (T) list.get(index);
	}
	
	static void f2() {
		writeWithWildcard(apples, new Apple());
		writeWithWildcard(apples, new Jonathan());
		writeWithWildcard(fruits, new Fruit());
		writeWithWildcard(fruits, new Apple());
		writeWithWildcard(fruits, new Jonathan());
		writeWithWildcard(fruits, new Orange());
	}
	
	public static void main(String[] args) {
		f1();
		System.out.println(apples);
		System.out.println(fruits);
		System.out.println(read(apples, 1).getClass().getSimpleName());
		System.out.println(read(fruits, 0).getClass().getSimpleName());
		System.out.println(read(fruits, 1).getClass().getSimpleName());
		System.out.println(read(fruits, 2).getClass().getSimpleName());
		System.out.println(read(fruits, 3).getClass().getSimpleName());
		apples.clear();
		fruits.clear();
		f2();
		System.out.println(apples);
		System.out.println(fruits);
		System.out.println(read2(apples, 1).getClass().getSimpleName());
		System.out.println(read2(fruits, 0).getClass().getSimpleName());
		System.out.println(read2(fruits, 1).getClass().getSimpleName());
		System.out.println(read2(fruits, 2).getClass().getSimpleName());
		System.out.println(read2(fruits, 3).getClass().getSimpleName());
	}
	
}


