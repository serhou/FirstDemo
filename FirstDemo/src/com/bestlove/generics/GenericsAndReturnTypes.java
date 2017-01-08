package com.bestlove.generics;

public class GenericsAndReturnTypes {

	void test(Getter g) {
		Getter result = g.get();
		//下面代码不能编译，除非是使用了囊括了协变返回类型的Java SE5
		GenericGetter gg = g.get();
	}
	
	public static void main(String[] args) {
		new GenericsAndReturnTypes().test(new Getter() {
			
			@Override
			public Getter get() {
				// TODO Auto-generated method stub
				return null;
			}
		});
	}
	
}

interface GenericGetter<T extends GenericGetter<T>> {
	T get();
}

interface Getter extends GenericGetter<Getter> {}