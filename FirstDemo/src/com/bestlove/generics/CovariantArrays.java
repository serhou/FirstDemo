package com.bestlove.generics;

import java.util.ArrayList;
import java.util.List;

public class CovariantArrays {

	public static void main(String[] args) {
		
		Fruit[] fruit = new Apple[10];
		fruit[0] = new Apple();
		fruit[1] = new Jonathan();
		//只能存Apple及其子类，运行时异常
//		fruit[2] = new Fruit();//java.lang.ArrayStoreException
//		fruit[3] = new Orange();//java.lang.ArrayStoreException
		System.out.println(fruit[1]);
		//Compile Error: incompatible types 不同类型的list
//		List<Fruit> flist = new ArrayList<Apple>(); 
	}
	
}

class Fruit {}
class Apple extends Fruit {}
class Jonathan extends Apple {}
class Orange extends Fruit {}