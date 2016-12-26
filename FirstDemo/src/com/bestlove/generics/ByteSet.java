package com.bestlove.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 任何基本类型都不能作为类型参数
 * @author think
 *
 */

public class ByteSet {

	Byte[] possibles = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 7, 6, 3, 6};
	Set<Byte> mySet = new HashSet<Byte>(Arrays.asList(possibles));
	
	public static void main(String[] args) {
		
		System.out.println(new ByteSet().mySet);
		//解决之道是使用基本类型的包装器类以及Java SE5的自动包装机制
		List<Integer> li = new ArrayList<Integer>();
		for (int i = 0; i < 50; i++) {
			li.add(i % 3 == 0 ? i : -1);
		}
		for (Integer integer : li) {
			System.out.print(integer + " ");
		}
		
		
	}
	
	
}
