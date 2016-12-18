package com.bestlove.generics;

public class InstantiateGenericType {
	public static void main(String[] args) {
		
		ClassAsFactory<Employee> fe = new ClassAsFactory<Employee>(Employee.class);
		System.out.println("ClassAsFactory<Employee> succeeded");
		try {
			ClassAsFactory<Integer> fi = new ClassAsFactory<Integer>(Integer.class);
		} catch (Exception e) {//因为Integer没有任何默认的构造器，这个错误不是在编译期捕获的
			System.out.println("ClassAsFactory<Integer> failed");
		}
	
	}
}

class ClassAsFactory<T> {
	T x;
	public ClassAsFactory(Class<T> kind) {
		try {
			x = kind.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
}

class Employee {}