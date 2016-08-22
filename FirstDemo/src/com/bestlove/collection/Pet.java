package com.bestlove.collection;

public interface Pet {

	public String eat(String food);
	
}

class Cat implements Pet{

	private String name;
	
	public Cat(String name) {
		this.name = name;
	}
	
	@Override
	public String eat(String food) {
		return name + " is eating " + food;
	}
	
	@Override
	public String toString() {
		return eat("fish");
	}
}

class Dog implements Pet{

	private String name;
	
	public Dog(String name) {
		this.name = name;
	}
	
	@Override
	public String eat(String food) {
		return name + " is eating " + food;
	}
	
	@Override
	public String toString() {
		return eat("feces");
	}
}

/**
 * 仓鼠
 * @author think
 *
 */
class Hamster implements Pet{

	private String name;
	
	public Hamster(String name) {
		this.name = name;
	}
	
	@Override
	public String eat(String food) {
		return name + " is eating " + food;
	}
	
	@Override
	public String toString() {
		return eat("rice");
	}
}