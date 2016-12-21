package com.bestlove.generics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 无界通配符和原生类型的关系
 * @author think
 *
 */

public class UnboundedWildcards2 {

	static Map map1;
	static Map<?, ?> map2;
	static Map<String, ?> map3;
	static void assign1(Map map) {
		map1 = map;
	}
	static void assign2(Map<?, ?> map) {
		map2 = map;
	}
	static void assign3(Map<String, ?> map) {
		map3 = map;
	}
	
	public static void main(String[] args) {
		
		assign1(new HashMap());
		assign2(new HashMap());
		assign3(new HashMap());
		
		assign1(new HashMap<String, Integer>());
		assign2(new HashMap<String, Integer>());
		assign3(new HashMap<String, Integer>());
		
		assign1(new HashMap<List, Integer>());
		assign2(new HashMap<List, Integer>());
//		assign3(new HashMap<List, Integer>());
	}
	
}
