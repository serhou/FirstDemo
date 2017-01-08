package com.bestlove.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bestlove.classtype.Cat;
import com.bestlove.classtype.Dog;
import com.bestlove.classtype.Pet;

/**
 * 动态类型安全
 * java.util.Collections中有一组便利工具，
 * 可以解决在这种强况下的类型检查问题
 * 静态方法
 * checkedCollection()
 * checkedList()
 * checkedMap()
 * checkedSet()
 * checkedSortedMap()
 * checkedSortedSet()
 * 受检查的容器在你试图插入类型不正确的对象时抛出ClassCastException
 * @author think
 * @see Collections
 */

public class CheckedList {
	@SuppressWarnings("unchecked")
	static void oldStyleMethod(List probablyDogs) {
		probablyDogs.add(new Cat());
	}
	public static void main(String[] args) {
		List<Dog> dogs1 = new ArrayList<Dog>();
		oldStyleMethod(dogs1);
		System.out.println("1:" + dogs1);
		List<Dog> dogs2 = Collections.checkedList(new ArrayList<Dog>(), Dog.class);
		try {
			oldStyleMethod(dogs2);//Attempt to insert class com.bestlove.classtype.Cat element into collection with element type class com.bestlove.classtype.Dog
			System.out.println("2:" + dogs2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Pet> pets = Collections.checkedList(new ArrayList<Pet>(), Pet.class);
		pets.add(new Dog());
		pets.add(new Cat());
		System.out.println("3:" + pets);
	}
}
