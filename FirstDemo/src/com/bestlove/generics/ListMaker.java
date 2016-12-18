package com.bestlove.generics;

import java.util.ArrayList;
import java.util.List;

public class ListMaker<T> {
	
	List<T> create() {
		return new ArrayList<T>();
	}

	public static void main(String[] args) {
		
		ListMaker<String> stringMaker = new ListMaker<String>();
		List<String> stringList = stringMaker.create();
		stringList.add("我爱我的祖国");
		stringList.add("没有共产党就没有新中国");
		System.out.println(stringList);
	}
	
}
