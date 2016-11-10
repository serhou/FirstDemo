package com.bestlove.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 通过reset()方法，可以将现有的Matcher对象用于与一个新的字符序列
 * 使用不带参数的reset()方法，可以将Matcher对象重新设置到当前字符序列的起始位置
 * @author think
 *
 */

public class Resetting {

	public static void main(String[] args) {
		
		Matcher m = Pattern.compile("[frb][aiu][gx]")
				.matcher("fix the rug with bags");
		System.out.println("fix the rug with bags");
		System.out.println("-----------------");
		while (m.find()) {
			System.out.print(m.group() + " ");
		}
		System.out.println("-----------------");
		m.reset("fix the rig with rags");//应用于一个新的字符序列，与原来的序列就没关系了
		while (m.find()) {
			System.out.print(m.group() + " ");
		}
	}
	
}
