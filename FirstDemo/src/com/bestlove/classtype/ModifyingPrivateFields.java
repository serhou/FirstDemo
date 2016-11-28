package com.bestlove.classtype;

import java.lang.reflect.Field;

public class ModifyingPrivateFields {

	public static void main(String[] args) throws Exception {
		
		WithPrivateFinalField pf = new WithPrivateFinalField();
		System.out.println(pf);
		Field f = pf.getClass().getDeclaredField("i");
		f.setAccessible(true);
		System.out.println("f.getInt(pf): " + f.getInt(pf));
		f.setInt(pf, 23);//被修改
		System.out.println(pf);
		f = pf.getClass().getDeclaredField("S");//常量不能被修改
		f.setAccessible(true);
		System.out.println("f.get(pf): " + f.get(pf));
		f.set(pf, "No, you're not!");//不能修改
		System.out.println(pf);
		f = pf.getClass().getDeclaredField("s2");
		f.setAccessible(true);
		System.out.println("f.get(pf): " + f.get(pf));
		f.set(pf, "No, you're not!");//被修改
		System.out.println(pf);
	}
	
}

class WithPrivateFinalField {
	private int i = 1;
	private final String S = "I'm totally safe";
	private String s2 = "Am I safe?";
	@Override
	public String toString() {
		return "i = " + i + ", " + S + ", " + s2;
	}
}
