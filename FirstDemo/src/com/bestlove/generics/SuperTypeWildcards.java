package com.bestlove.generics;

import java.util.List;

public class SuperTypeWildcards {

	static void writeTo(List<? super Apple> apples) {
		//可以放入了
		apples.add(new Apple());
		apples.add(new Jonathan());
//		apples.add(new Fruit());//Error
	}
	
}
