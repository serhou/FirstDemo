package com.bestlove.collection;

/**
 * 测试栈Stack
 * @author think
 *
 */
public class TestStack {

	public static void main(String[] args) {
		
		Stack<String> stack = new Stack<String>();
		for(String s : "My dog has fleas".split(" ")){
			stack.push(s);//依次将单词放入
		}
		while (!stack.empty()) {
			System.out.print(stack.pop() + " ");//依次取出
		}
		
	}
	
}
