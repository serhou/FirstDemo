package com.bestlove.generics;

import com.bestlove.util.Generator;
import com.bestlove.util.RandomGenerator;

/**
 * FArray类包含一个泛型方法，它通过使用生成器在数组中填充对象
 * （这使得类泛型在本例中无法工作，因为这个方法是静态的）
 * 自动包装机制不能用于数组
 * @author think
 *
 */

public class PrimitiveGenericTest {

	public static void main(String[] args) {
		
		String[] strings = FArray.fill(new String[7], new RandomGenerator.String(10));
		for (String string : strings) {
			System.out.println(string);
		}
		Integer[] integers = FArray.fill(new Integer[7], new RandomGenerator.Integer());
		for (int i : integers) {
			System.out.println(i);
		}
		
	}
	
}

class FArray {
	public static <T> T[] fill(T[] a, Generator<T> gen) {
		for (int i = 0; i < a.length; i++) {
			a[i] = gen.next();
		}
		return a;
	}
}
