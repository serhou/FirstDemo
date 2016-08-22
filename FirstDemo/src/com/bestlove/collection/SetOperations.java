package com.bestlove.collection;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Set的特性:存储不同的值，过滤相同的值
 * @author think
 *
 */

public class SetOperations {

	public static void main(String[] args) {
		
		Set<String> set1 = new HashSet<String>();
		Collections.addAll(set1, "A,B,C,D,E,F,G,H,I,J,K".split(","));
		set1.add("M");
		System.out.println("H:" + set1.contains("H"));
		System.out.println("N:" + set1.contains("N"));
		
		Set<String> set2 = new HashSet<String>();
		Collections.addAll(set2, "H,I,J,K,L,M,N,O,P,Q".split(","));
		set1.remove("C");
		System.out.println("set1:" + set1);
		System.out.println("set2 in set1:" + set1.addAll(set2));
		set1.removeAll(set2);
		Collections.addAll(set1, "X,Y,Z".split(","));
		System.out.println("X,Y,Z added to set1:" + set1);
		
		
	}
	
}
