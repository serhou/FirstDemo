package com.bestlove.generics;

import java.util.ArrayList;
import java.util.Random;

/**
 * 随机获取一个元素
 * @author think
 *
 * @param <T>
 */

public class RandomList<T> {

	private ArrayList<T> storage = new ArrayList<T>();
	private Random rand = new Random();
	public void add(T item) {
		storage.add(item);
	}
	public T select() {
		return storage.get(rand.nextInt(storage.size()));
	}
	public static void main(String[] args) {
		
		RandomList<String> rs = new RandomList<String>();
		for (String string : "The quick brown fox jumped over the lazy brown dog".split(" ")) {
			rs.add(string);
		}
		for (int i = 0; i < 11; i++) {
			System.out.print(rs.select() + " ");
		}
	}
}
