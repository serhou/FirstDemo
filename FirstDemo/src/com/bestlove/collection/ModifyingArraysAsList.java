package com.bestlove.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


/**
 * RandomAccess附着到了ArrayList上，而没有附着到LinkedList上。
 * 这为想要根据所使用的特定的List而动态修改其行为的算法提供了信息
 * 标识接口
 * @author think
 *
 */


public class ModifyingArraysAsList {

	
	public static void main(String[] args) {
		
		Random rand = new Random();
		Integer[] it = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		//生成新的List
		List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(it));
		System.out.println("Before shuffling:" + list1);
		Collections.shuffle(list1, rand);//使用默认随机源对指定列表进行置换。
		System.out.println("After shuffling:" + list1);
		//不改变原有的数据
		System.out.println("array:" + Arrays.toString(it));
		//直接改变原有的数据
		List<Integer> list2 = Arrays.asList(it);
		System.out.println("Before shuffling:" + list2);
		Collections.shuffle(list2, rand);//使用默认随机源对指定列表进行置换。
		System.out.println("After shuffling:" + list2);
		//原有数据被改变
		System.out.println("array:" + Arrays.toString(it));
	}
	
}
