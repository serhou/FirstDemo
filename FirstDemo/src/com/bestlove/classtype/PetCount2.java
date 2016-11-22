package com.bestlove.classtype;

import java.util.LinkedHashMap;
import java.util.Map;

import com.bestlove.util.MapData;

/**
 * 动态的instanceof
 * @author think
 *
 */

public class PetCount2 {

	static class PetCounter extends LinkedHashMap<Class<? extends Pet>, Integer> {
		public PetCounter() {
			super(MapData.map(LiteralPetCreator.ALLTYPES, 0));
		}
		public void count(Pet pet) {
			for (Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
				if (pair.getKey().isInstance(pet)) {
					put(pair.getKey(), pair.getValue() + 1);
				}
			}
		}
		@Override
		public String toString() {
			StringBuilder result = new StringBuilder("{");
			for (Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
				result.append(pair.getKey().getSimpleName())
					  .append("=")
					  .append(pair.getValue())
					  .append(", ");
			}
			result.delete(result.length()-2, result.length());
			result.append("}");
			return result.toString();
		}
	}
	public static void main(String[] args) {
		PetCounter petCount = new PetCounter();
		for (Pet pet : new LiteralPetCreator().createArray(15)) {
			System.out.print(pet.getClass().getSimpleName() + " ");
			petCount.count(pet);
		}
		System.out.println();
		System.out.println(petCount);
	}
	
}
