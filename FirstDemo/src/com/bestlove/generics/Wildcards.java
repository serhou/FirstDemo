package com.bestlove.generics;

public class Wildcards {

	static void rawArgs(Holder holder, Object arg) {
		holder.set(arg);//Warning
		holder.set(new Wildcards());//Warning
//		T t = holder.get();
		Object obj = holder.get();
	}
	
	static void unboundedArg(Holder<?> holder, Object arg) {
//		holder.set(arg);//Error
//		holder.set(new Wildcards());//Error
//		T t = holder.get();//Error
		Object obj = holder.get();
	}
	
	static <T> T exact1(Holder<T> holder) {
		T t = holder.get();
		return t;
	}
	
	static <T> T exact2(Holder<T> holder, T arg) {
		holder.set(arg);
		T t  = holder.get();
		return t;
	}
	
	static <T> T wildSubtype(Holder<? extends T> holder, T arg) {
//		holder.set(arg);//Error
		T t = holder.get();
		return t;
	}
	
	static <T> void wildSupertype(Holder<? super T> holder, T arg) {
		holder.set(arg);
//		T t = holder.get();//Error
		Object obj = holder.get();
	}
	
	public static void main(String[] args) {
		
		Holder raw = new Holder<Long>();
		raw = new Holder();
		Holder<Long> qualified = new Holder<Long>();
		Holder<?> unbounded = new Holder<Long>();
		Holder<? extends Long> bounded = new Holder<Long>();
		Long lng = 13L;
		rawArgs(raw, lng);
		rawArgs(qualified, lng);
		rawArgs(unbounded, lng);
		rawArgs(bounded, lng);
		
		unboundedArg(raw, lng);
		unboundedArg(qualified, lng);
		unboundedArg(unbounded, lng);
		unboundedArg(bounded, lng);
		
		Object r1 = exact1(raw);//Warnings
		Long r2 = exact1(qualified);
		Object r3 = exact1(unbounded);
		Long r4 = exact1(bounded);
	}
	
	
}
