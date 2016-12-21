package com.bestlove.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 无界通配符<?> 看起来意味着“任何事物”，
 * 因此使用无界通配符好像等价于使用原生类型
 * <?> 可以被认为是一种装饰，但是它仍旧是很
 * 有价值的，这里表示，我们并不是要原生类型，
 * 而是泛型参数可以持有任何类型
 * @author think
 *
 */

public class UnboundedWildcards1 {

	static List list1;
	static List<?> list2;
	static List<? extends Object> list3;
	static void assign1(List list) {
		list1 = list;
		list2 = list;
		list3 = list;
	}
	
	static void assign2(List<?> list) {
		list1 = list;
		list2 = list;
		list3 = list;
	}
	
	static void assign3(List<? extends Object> list) {
		list1 = list;
		list2 = list;
		list3 = list;
	}
	
	public static void main(String[] args) {
		
		assign1(new ArrayList());
		assign2(new ArrayList());
		assign3(new ArrayList());
		
		assign1(new ArrayList<String>());
		assign2(new ArrayList<String>());
		assign3(new ArrayList<String>());
		
		List<?> wildList = new ArrayList();
		wildList = new ArrayList<String>();
		assign1(wildList);
		assign2(wildList);
		assign3(wildList);
	}
	
}
