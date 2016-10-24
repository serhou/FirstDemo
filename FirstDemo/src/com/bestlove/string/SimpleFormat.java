package com.bestlove.string;

public class SimpleFormat {

	public static void main(String[] args) {
		
		int i = 28;
		double d = 12.45;
		//效果一样
		System.out.format("Row 1: [%d %f]\n", i, d);
		System.out.printf("Row 2: [%d %f]\n", i, d);//怀旧
	}
	
}
