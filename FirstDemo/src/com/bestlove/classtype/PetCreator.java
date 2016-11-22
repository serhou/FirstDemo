package com.bestlove.classtype;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 随机产生对象
 * @author think
 *
 */

public abstract class PetCreator {

	private Random rand = new Random();
	
	public abstract List<Class<? extends Pet>> types ();

	public Pet randomPet() {
		int n = rand.nextInt(types().size());//产生随机数
		try {
			return types().get(n).newInstance();//随意返回一个对象
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Pet[] createArray(int size) {
		Pet[] result = new Pet[size];
		for (int i = 0; i < size; i++) {
			result[i] = randomPet();//随机产生的对象放进数组
		}
		return result;
	}
	
	public ArrayList<Pet> arrayList(int size) {
		ArrayList<Pet> result = new ArrayList<Pet>();
		Collections.addAll(result, createArray(size));//放进ArrayList
		return result;
	}
}
