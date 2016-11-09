package com.bestlove.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Matcher对象的find()方法
 * @author think
 *
 */

public class Finding {

	public static void main(String[] args) {
		
		Matcher m = Pattern.compile("\\w+")//模式\\w+ 将字符串划分为单词
				.matcher("Evening is full of the linnet's wings");
		while (m.find()) {//find()像迭代器那样前向遍历输入字符串
			System.out.print(m.group() + " ");
			//Evening is full of the linnet s wings
		}
		System.out.println("----------------------------");
		int i = 0;
		//这个find()方法可以接收一个整数作为参数，该整数表示字符串中字符的位置，
		//并以其作为搜索的起点。从结果中可以看出，该方法能根据参数的值，不断重新设定搜索的其实位置
		while (m.find(i)) {
			System.out.print(m.group() + " ");
			//Evening vening ening ning ing ng g is is s full full ull ll l of of f the the he e linnet linnet innet nnet net et t s s wings wings ings ngs gs s 
			i++;
		}
	}
	
}
