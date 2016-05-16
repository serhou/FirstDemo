package com.bestlove.test;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

/**
 * Scanner类的构造器接受的就是一个Readable接口。通过这种方式，Scanner可以作用于更多的类型。
 * 
 * Readable接口只要求实现read()方法，在read()内部，将输入内容添加到CharBuffer参数中，
 * 或者在没有任何输入时返回-1
 * @author think
 *
 */

public class RandomWords implements Readable {

	private static Random rand = new Random(4);
	private static final char[] CAPITALS = "ABCDEFGHIJKLMNOPQRSTUVMXYZ".toCharArray();
	private static final char[] LOWERS = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	private static final char[] VOWELS = "AEIOU".toCharArray();
	private int count;
	
	public RandomWords(int count) {
		this.count = count;
	}
	
	@Override
	public int read(CharBuffer cb) throws IOException {
		if(count-- == 0){
			return -1;
		}
		cb.append(CAPITALS[rand.nextInt(CAPITALS.length)]);
		for (int i = 0; i < 4; i++) {
			cb.append(VOWELS[rand.nextInt(VOWELS.length)]);
			cb.append(LOWERS[rand.nextInt(LOWERS.length)]);
		}
		cb.append(" ");
		return 10;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(new RandomWords(10));
		while (s.hasNext()) {
			System.out.println(s.next());
		}
		s.close();
	}
	
}
