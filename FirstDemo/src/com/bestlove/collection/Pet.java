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


/**
 * Cymric
 * @author think
 *
 */
class Cymric implements Pet{

	private String name;
	
	public Cymric(String name) {
		this.name = name;
	}
	
	@Override
	public String eat(String food) {
		return name + " is eating " + food;
	}
	
	@Override
	public String toString() {
		return eat("Ccc");
	}
}


/**
 * Mutt
 * @author think
 *
 */
class Mutt implements Pet{

	private String name;
	
	public Mutt(String name) {
		this.name = name;
	}
	
	@Override
	public String eat(String food) {
		return name + " is eating " + food;
	}
	
	@Override
	public String toString() {
		return eat("Mmm");
	}
}


/**
 * Pug
 * @author think
 *
 */
class Pug implements Pet{

	private String name;
	
	public Pug(String name) {
		this.name = name;
	}
	
	@Override
	public String eat(String food) {
		return name + " is eating " + food;
	}
	
	@Override
	public String toString() {
		return eat("Ppp");
	}
}



/**
 * Rat
 * @author think
 *
 */
class Rat implements Pet{

	private String name;
	
	public Rat(String name) {
		this.name = name;
	}
	
	@Override
	public String eat(String food) {
		return name + " is eating " + food;
	}
	
	@Override
	public String toString() {
		return eat("Rrr");
	}
}

