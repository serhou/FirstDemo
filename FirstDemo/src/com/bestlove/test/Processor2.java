package com.bestlove.test;

public interface Processor2 {
	String name();
	Object process(Object input);
}

class Apply2 {
	public static void process(Processor2 p2, Object o) {
		System.out.println("Using Processor " + p2.name());
		System.out.println(p2.process(o));
	}
}