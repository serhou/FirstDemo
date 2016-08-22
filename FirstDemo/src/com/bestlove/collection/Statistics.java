package com.bestlove.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 在本例中，键是由Random产生的数字，而值是该数字出现的次数
 * @author think
 *
 */

public class Statistics {

	public static void main(String[] args) {
		
		Random random = new Random();
		
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		for (int i = 0; i < 10; i++) {
			int r = random.nextInt(20);
			Integer freq = m.get(r);
			m.put(r, freq == null ? 1 : freq+1);//自动包装机制
		}
		System.out.println(m);
		
	}
	
}
