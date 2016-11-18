package com.bestlove.classtype;

import java.util.ArrayList;
import java.util.List;

/**
 * 当你将泛型语法用于Class对象是，会发生一件很有趣的事情：
 * newInstance()将返回该对象的确切类型
 * @author think
 *
 * @param <T>
 */

public class FilledList<T> {

	private Class<T> type;
	public FilledList(Class<T> type) {
		this.type = type;
	}
	public List<T> create(int nElements) {
		List<T> result = new ArrayList<T>();
		try {
			for (int i = 0; i < nElements; i++) {
				result.add(type.newInstance());
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return result;
	}
	public static void main(String[] args) {
		FilledList<CountedInteger> fl = new FilledList<CountedInteger>(CountedInteger.class);
		System.out.println(fl.create(15));
	}
}


class CountedInteger {
	private static long counter=20;
	private final long ID = counter++;
	public String toString() {
		return Long.toString(ID);
	}
}