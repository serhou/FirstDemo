package com.bestlove.string;

import java.util.Scanner;

/**
 * Scanner的构造器可以接受任何类型的输入对象，包括File对象、InputStream、String或者
 * 此例中的Readable对象。Readable是Java SE5中新加入的一个接口，表示“具有read()方法的某种东西”
 * BufferedReader也归于这一类
 * 普通的next()方法返回下一个String
 * 所有基本类型（除char之外）都有对应的next方法，包括BigDecimal和BigInteger。
 * 所有的next方法，只有在找到一个完整的分词之后才会返回。
 * @author think
 *
 */

public class BetterRead {
	
	public static void main(String[] args) {
		
		Scanner stdin = new Scanner(SimpleRead.input);
		System.out.println("What is your name?");
		String name = stdin.nextLine();
		System.out.println(name);
		System.out.println("How old are you? What is you favorite double?");
		System.out.println("(input: <age> <double>)");
		int age = stdin.nextInt();
		double favorite = stdin.nextDouble();
		System.out.println(age);
		System.out.println(favorite);
		
		System.out.format("Hi %s.\n", name);
		System.out.format("In 10 years you will be %d.\n", age + 10);
		System.out.format("My favorite double is %f.\n", favorite / 2);
		
	}
	
}
