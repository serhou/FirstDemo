package com.bestlove.generics;

import com.bestlove.util.Generator;

public class BasicGenerator<T> implements Generator<T> {

	private Class<T> type;
	public BasicGenerator(Class<T> type) {
		this.type = type;
	}
	
	@Override
	public T next() {
		try {
			//返回传入类型的实例
			return type.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	//静态方法可以被直接调用
	public static <T> Generator<T> create(Class<T> type) {
		return new BasicGenerator<T>(type);
	}
	
}
