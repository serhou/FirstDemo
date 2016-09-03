package com.bestlove.collection;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Collection之所以能够工作，是因为Java SE5 引入了新的被称为Iterable的接口，
 * 该接口包含一个能够产生Iterator的iterator()方法，并且Iterable接口被foreach
 * 用来在序列中移动。
 * @author think
 *
 */

public class ForEachCollections {

	public static void main(String[] args) {
		
		Collection<String> cs = new LinkedList<String>();
		Collections.addAll(cs, "Take the long way home".split(" "));
		for (String string : cs) {
			System.out.println(string);
		}
		
	}
	
}
