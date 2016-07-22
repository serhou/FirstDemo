package com.bestlove.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 你可以直接使用Arrays.asList()的输出，将其当做List,
 * 但是在这种情况下，其底层表示的是数组，因此不能调整尺寸。
 * 如果你试图用add()或delete()方法在这种列表中添加或删除元素，
 * 就有可能会引发去改变数组尺寸的尝试，因此你将在运行时获得
 * “Unsupported Operation(不支持的操作)”错误。
 * @author think
 *
 */


public class AddingGroups {

	public static void main(String[] args) {
		
		Collection<Integer> collection = 
				new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		System.out.println(collection);
		Integer[] moreInts = {6, 7, 8, 9, 10};
		//Collection.addAll()成员方法只能接受另一个Collection对象作为参数
		collection.addAll(Arrays.asList(moreInts));
		System.out.println(collection);
		//因此，它不如Arrays.asList()或Collections.addAll()灵活，这两个方法使用的都是可变参数列表
		Collections.addAll(collection, 11, 12, 13, 14, 15);
		System.out.println(collection);
		Collections.addAll(collection, moreInts);
		System.out.println(collection);
		List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
		System.out.println(list);
		list.set(1, 99);
		System.out.println(list);
		
	}
	
	
}
