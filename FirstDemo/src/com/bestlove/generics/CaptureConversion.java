package com.bestlove.generics;

public class CaptureConversion {

	static <T> void f1(Holder<T> holder) {
		T t = holder.get();
		System.out.println(t);
	}
	
	static void f2(Holder<?> holder) {
		f1(holder);//Call with capture type
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Holder raw = new Holder<Integer>();
		f1(raw);//warnings  获取不到类型
		f2(raw);//获取不到类型
		Holder rawBasic = new Holder();
		rawBasic.set(new Object());
		f2(rawBasic);
		Holder<?> wildcarded = new Holder<Double>(1.0);
		f2(wildcarded);
	}
	
}
