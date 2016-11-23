package com.bestlove.classtype;

/**
 * 递归计数
 * @author think
 *
 */

public class PetCount3 {

	public static void main(String[] args) {
		//将超类赋值给baseType，countClass()将其超类上递归计数
		TypeCounter counter = new TypeCounter(Pet.class);
		for (Pet pet : new LiteralPetCreator().createArray(3)) {
			System.out.print(pet.getClass().getSimpleName() + " ");
			counter.count(pet);
		}
		System.out.println();
		System.out.println(counter);
		
	}
	
}
