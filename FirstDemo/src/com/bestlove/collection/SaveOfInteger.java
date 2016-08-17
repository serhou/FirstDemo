package com.bestlove.collection;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 出于速度的原因考虑，HashSet使用了散列。HashSet所维护的顺序与TreeSet或LinkedHashSet都不同，
 * 因为它们的实现具有不同的元素存储方式。
 * TreeSet将元素存储在红-黑树数据结构中，而HashSet使用的是散列函数。
 * LinkedHashSet因为查询速度的原因也使用了散列，但是看起来它使用了链表来维护元素的插入循序。
 * 
 * @author think
 *
 */
public class SaveOfInteger {

	public static void main(String[] args) {
		
		Random random = new Random();
		Set<Integer> intset = new HashSet<Integer>();
		for (int i = 0; i < 10; i++) {
			intset.add(random.nextInt(30));
		}
		System.out.println(intset);

	}
	
}
