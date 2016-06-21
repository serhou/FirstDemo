package com.best.innerclasses;


public class TestBed implements ClassInInterface{

	public void f() {
		System.out.println("TestBed.f()");
	}
	
	public static class Tester {
		public static void main(String[] args) {
			TestBed t = new TestBed();
			t.f();
			t.howdy();
			new Test().howdy();
			new Test().main(args);
		}
	}

	@Override
	public void howdy() {
		System.out.println("TestBed.howdy()");
	}
}
