package com.bestlove.classtype;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * 反射：运行时的类信息
 * 类方法提取器
 * @author think
 *
 */

public class ShowMethods {

	private static String usage = 
			"usage:\n"
			+ "ShowMethods qualified.class.name\n"
			+ "To show all methods in class or:\n"
			+ "ShowMethods qualified.class.name word\n"
			+ "To search for methods involving 'word'";
	private static Pattern p = Pattern.compile("\\w+\\.");
	public static void main(String[] args) {
		args = new String[]{"com.bestlove.classtype.ShowMethods"};
		if(args.length < 1) {
			System.out.println(usage);
			System.exit(0);
		}
		int lines = 0;
		try {
			Class<?> c = Class.forName(args[0]);
			Method[] methods = c.getMethods();
			Constructor[] ctors = c.getConstructors();
			if (args.length == 1) {
				for (Method method : methods) {
					System.out.println("1.1: " + p.matcher(method.toString()).replaceAll(""));
				}
				for (Constructor constructor : ctors) {
					System.out.println("1.2: " + p.matcher(constructor.toString()).replaceAll(""));
				}
				lines = methods.length + ctors.length;
			} else {
				for (Method method : methods) {
					if (method.toString().indexOf(args[1]) != -1) {
						System.out.println("2.1: " +  p.matcher(method.toString()).replaceAll(""));
						lines++;
					}
				}
				for (Constructor constructor : ctors) {
					if (constructor.toString().indexOf(args[1]) != -1) {
						System.out.println("2.2: " + p.matcher(constructor.toString()).replaceAll(""));
						lines++;
					}
				}
			}
			System.out.println("count: " + lines);
		} catch (ClassNotFoundException e) {
			System.out.println("No such class: " + e);
		}
		
		
	}
}
