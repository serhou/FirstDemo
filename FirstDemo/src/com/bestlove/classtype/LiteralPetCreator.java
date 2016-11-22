package com.bestlove.classtype;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 使用类字面常量生成Class对象
 * @author think
 *
 */

public class LiteralPetCreator extends PetCreator {

	public static final List<Class<? extends Pet>> ALLTYPES =
		Collections.unmodifiableList(Arrays.asList(
				Pet.class, Dog.class, Cat.class, Rodent.class, 
				Mutt.class, Pug.class, EgyptianMau.class, Manx.class, 
				Cymric.class, Rat.class, Mouse.class, Hamster.class));//所有的类型，包括父类
	private static final List<Class<? extends Pet>> TYPES = 
			ALLTYPES.subList(ALLTYPES.indexOf(Mutt.class), ALLTYPES.size());//具体的类型
	@Override
	public List<Class<? extends Pet>> types() {
		return TYPES;
	}

	public static void main(String[] args) {
		System.out.println(TYPES);
	}
	
}
