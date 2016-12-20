package com.bestlove.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Wildcards 通配符
 * 如果现将Apple向上转型为Fruit，编译器将直接拒绝
 * 对参数列表中设计通配符的方法的调用
 * 在使用contains()和indexOf()时，参数类型是Object
 * 因此不涉及任何通配符，而编译器也将允许这个调用
 * @author think
 *
 */

public class GenericsAndCovariance {

	public static void main(String[] args) {
		//只能传入null了
		List<? extends Fruit> flist = new ArrayList<Apple>();
//		flist.add(new Apple());//不可以
//		flist.add(new Fruit());//不可以
//		flist.add(new Object());//不可以
		flist.add(null);//合法但无意义 Legal but uninteresting
		Fruit f = flist.get(0);
		System.out.println(f);
		
		List<? extends Fruit> flist2 = Arrays.asList(new Apple());
		Fruit a = flist2.get(0);
		if(a instanceof Apple) {
			System.out.println(a.getClass().getCanonicalName());
		}
		System.out.println(flist2.contains(new Apple()));
		System.out.println(flist2.indexOf(new Apple()));
	}
	
}
