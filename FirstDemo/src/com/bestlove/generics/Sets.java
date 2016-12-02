package com.bestlove.generics;

import java.util.HashSet;
import java.util.Set;

/**
 * 在前三个方法中，都将第一个参数Set复制了一份，将Set中的
 * 所有引用都存入一个新的HashSet对象中，因此我们并未直接
 * 修改参数中的Set。返回的值是一个全新的Set对象。
 * @author think
 *
 */

public class Sets {

	/**
	 * 求a和b的并集
	 * @param a
	 * @param b
	 * @return
	 */
	public static <T> Set<T> union(Set<T> a, Set<T> b) {
		Set<T> result = new HashSet<T>(a);
		result.addAll(b);
		return result;
	}
	
	/**
	 * 求a和b的交集
	 * @param a
	 * @param b
	 * @return
	 */
	public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
		Set<T> result = new HashSet<T>(a);
		result.retainAll(b);
		return result;
	}
	/**
	 * 删除superset中包含的subset中的元素，返回superset中剩下的元素
	 * @param superset
	 * @param subset
	 * @return
	 */
	public static <T> Set<T> difference(Set<T> superset, Set<T> subset) {
		Set<T> result = new HashSet<T>(superset);
		result.removeAll(subset);
		return result;
	}
	
	/**
	 * 去除a和b中共有的元素后，返回剩下的a和b的所有元素
	 * @param a
	 * @param b
	 * @return
	 */
	public static <T> Set<T> complement(Set<T> a, Set<T> b) {
		return difference(union(a, b), intersection(a, b));
	}
	
	public static void main(String[] args) {
		Set<Integer> a = new HashSet<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		Set<Integer> b = new HashSet<Integer>();
		b.add(2);
		b.add(3);
		b.add(4);
		System.out.println(union(a, b));
		System.out.println(intersection(a, b));
		System.out.println(difference(a, b));
		System.out.println(complement(a, b));
	}
	
}
