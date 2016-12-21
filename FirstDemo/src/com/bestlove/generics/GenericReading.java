package com.bestlove.generics;

import java.util.Arrays;
import java.util.List;

public class GenericReading {

	static <T> T readExact(List<T> list, int index) {
		if(list == null || (index >= list.size() || index < 0)) {
			return null;
		}
		return list.get(index);
	}
	
	static List<Apple> apples = Arrays.asList(new Apple());
	static List<Fruit> fruits = Arrays.asList(new Fruit());
	
	static void f1() {
		Apple apple = readExact(apples, 0);
		Fruit fruit = readExact(fruits, 0);
		fruit = readExact(apples, 0);
	}
	
	static class Reader<T> {
		T readExact(List<T> list, int index) {
			if(list == null || (index >= list.size() || index < 0)) {
				return null;
			}
			return list.get(index);
		}
	}
	
	static void f2() {
		Reader<Fruit> fruitReader = new Reader<Fruit>();
		fruitReader.readExact(fruits, 0);
		//不可以
//		fruitReader.readExact(apples, 0);//Error
	}
	
	static class CovariantReader<T> {
		T readCovariant(List<? extends T> list, int index) {
			if(list == null || (index >= list.size() || index < 0)) {
				return null;
			}
			return list.get(index);
		}
	}
	
	static void f3() {
		CovariantReader<Fruit> fruitReader = new CovariantReader<Fruit>();
		Fruit fruit = fruitReader.readCovariant(fruits, 0);
		Fruit fruit2 = fruitReader.readCovariant(apples, 0);//可以了
	}
	
	static class Reader4<T> {
		T read4(List<? super T> list, int index) {
			if(list == null || (index >= list.size() || index < 0)) {
				return null;
			}
			return (T) list.get(index);
		}
	}
	
	static void f4() {
		Reader4<Fruit> reader = new Reader4<Fruit>();
		Fruit fruit = reader.read4(fruits, 0);
//		Fruit fruit2 = reader.read4(apples, 0);//不可以
	}
	
	public static void main(String[] args) {
		f1();
		f2();
		f3();
		f4();
	}
	
}
