package com.bestlove.classtype;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成Class对象
 * @author think
 *
 */

public class ForNameCreator extends PetCreator {

	private static List<Class<? extends Pet>> types =
			new ArrayList<Class<? extends Pet>>();
	
	private static String[] typeNames = {
		"com.bestlove.classtype.Mutt",
		"com.bestlove.classtype.Pug",
		"com.bestlove.classtype.EgyptianMau",
		"com.bestlove.classtype.Manx",
		"com.bestlove.classtype.Cymric",
		"com.bestlove.classtype.Rat",
		"com.bestlove.classtype.Mouse",
		"com.bestlove.classtype.Hamster"
	};
	//注解不能直接置于静态初始化子句之上
	@SuppressWarnings("unchecked")
	private static void loader() {
		try {
			for (String name : typeNames) {
				types.add((Class<? extends Pet>) Class.forName(name));
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	static {
		loader();
	}
	
	@Override
	public List<Class<? extends Pet>> types() {
		// TODO Auto-generated method stub
		return types;
	}

}
