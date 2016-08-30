package com.bestlove.collection;

import java.util.ArrayList;
import java.util.List;

public class Pets implements Pet{

	public static List<Pet> arrayList(int i){
		List<Pet> petList = new ArrayList<Pet>();
		for (int j = 0; j < i; j++) {
			Pet p = new Pets();
			p.eat(String.valueOf(j));
			petList.add(p);
		}
		
		return petList;
	}

	@Override
	public String eat(String food) {
		return food;
	}
	
	
}
