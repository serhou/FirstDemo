package com.bestlove.collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 两个版本中的display()方法都可以使用Map或Collection的子类型来工作，
 * 而且Collection接口和Iterator都可以将display方法与底层容器的特定实现解耦。
 * 在本例中，这两种方式都可以奏效。事实上，Collection要更方便一点，因为它是Iterable
 * 类型，因此，在display(Collection)实现中，可以使用foreach结构，从而使代码更加清晰
 * @author think
 *
 */

public class InterfaceVsIterator {

	public static void display(Iterator<Pet> it){
		while(it.hasNext()){
			Pet p = it.next();
			System.out.println(p.eat("老鼠"));
		}
	}
	
	public static void display(Collection<Pet> pets){
		for (Pet pet : pets) {
			System.out.println(pet.eat("缪缪"));
		}
	}
	
	public static void main(String[] args) {
		
		List<Pet> petList = Pets.arrayList(8);
		Set<Pet> petSet = new HashSet<Pet>(petList);
 		
		Map<String, Pet> petMap = new LinkedHashMap<String, Pet>();
		String[] names = ("Ralph, Eric, Robin, Lacey, " + 
				"Birtney, Sam, Spot, Fluffy").split(", ");
		for (int i = 0; i < names.length; i++) {
			petMap.put(names[i], petList.get(i));
		}
		
		display(petList);
		display(petSet);
		display(petList.iterator());
		display(petSet.iterator());
		System.out.println(petMap);
		System.out.println(petMap.keySet());
		display(petMap.values());
		display(petMap.values().iterator());
	}
	
}
