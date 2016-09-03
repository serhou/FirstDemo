package com.bestlove.collection;

import java.util.Map;

/**
 * System.getenv()返回一个Map,entrySet()产生一个由Map.Entry的元素构成的Set
 * 并且这个Set是一个Iterable，因此它可以用于foreach循环
 * @author think
 *
 */

public class EnvironmentVariables {

	public static void main(String[] args) {
		
		for (Map.Entry entry : System.getenv().entrySet()) {
			System.out.println(entry.getKey() + " ~ " + entry.getValue());
		}
		
	}
	
}
