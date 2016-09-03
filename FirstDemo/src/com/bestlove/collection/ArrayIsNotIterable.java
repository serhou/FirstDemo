package com.bestlove.collection;

import java.util.Arrays;

/**
 * foreach语句可以用于数组或其他任何Iterable，但是这并不意味着数组肯定也是一个Iterable。
 * 而任何自动包装也不会自动发生
 * 
 * 尝试把数组当做一个Iterable参数传递会导致失败。这说明不存在任何从数组到Iterable的自动转换，
 * 你必须手工执行这种转换。
 * @author think
 *
 */

public class ArrayIsNotIterable {

	static <T> void test(Iterable<T> ib) {
		for (T t : ib) {
			System.out.println(t);
		}
	}
	
	public static void main(String[] args) {
		
		test(Arrays.asList(1, 2, 3));
		
		String[] strs = {"A", "B", "C"};
		
		test(Arrays.asList(strs));
	}
	
}
