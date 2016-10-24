package com.bestlove.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 无意识的递归
 * @author think
 *
 */

public class InfiniteRecursion {
	//at java.lang.StringBuilder.append(StringBuilder.java:131)
	@Override
	public String toString() {
//		return " InfiniteRecursion address: " + this + "\n";//错误，字符串 + 对象，会将对象强转为字符串
		return " InfiniteRecursion address: " + super.toString() + "\n";
	}
	
	public static void main(String[] args) {
		
		List<InfiniteRecursion> v = new ArrayList<InfiniteRecursion>();
		for (int i = 0; i < 10; i++) {
			v.add(new InfiniteRecursion());
		}
		System.out.println(v);
		
		
		String str = "AbCDefGh";
		String em = "";
		System.out.println(str.intern());
		System.out.println(em.isEmpty());//是否是空串
	}
	
	
}
