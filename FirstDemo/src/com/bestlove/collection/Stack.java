package com.bestlove.collection;

import java.util.LinkedList;

/**
 * 模拟栈：后进先出
 * 弹栈
 * 这个Stack是用LinkedList实现的，而LinkedList也被告知它将持有T类对象
 * @author think
 *
 * @param <T>
 */
public class Stack<T> {
	
	private LinkedList<T> storage = new LinkedList<T>();
	//压入
	public void push(T t) {
		storage.addFirst(t);
	}
	//提供栈顶元素，但是并不将其从栈顶移除
	public T peek() {
		return storage.getFirst();
	}
	//将移除并返回栈顶元素
	public T pop() {
		return storage.removeFirst();
	}
	//判断是否为空
	public boolean empty() {
		return storage.isEmpty();
	}
	//转化为字符串
	public String toString() {
		return storage.toString();
	}
}
