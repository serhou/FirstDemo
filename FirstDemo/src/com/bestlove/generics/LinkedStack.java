package com.bestlove.generics;

/**
 * 这个例子使用了一个末端哨兵(end sentinel)来判断堆栈何时为空。
 * 这个末端哨兵是在构造LinkedStack时创建的。然后，每调用一次push方法，
 * 就会创建一个Node<T>对象，并将其链接到前一个Node<T>对象。当你
 * 调用pop()方法时，总是返回top.item，然后丢弃当前top所指的Node<T>,
 * 并将top转移到下一个Node<T>，除非你已经碰到了末端哨兵，这时候就不再
 * 移动top了。如果已经到了末端，客户端程序还继续调用pop()方法，它只能
 * 得到null，说明堆栈已经空了。
 * @author think
 *
 * @param <T>
 */

public class LinkedStack<T> {

	private static class Node<U> {
		U item;
		Node<U> next;
		Node() {
			item = null;
			next = null;
		}
		Node(U item, Node<U> next) {
			this.item = item;
			this.next = next;
		}
		boolean end() {
			return item == null && next == null;
		}
		@Override
		public String toString() {
			return item + ", " + next;
		}
	}
	private Node<T> top = new Node<T>();
	public void push(T item) {
		top = new Node<T>(item, top);//类似于递归
	}
	public T pop() {
		T result = top.item;
		if (!top.end()) {
			top = top.next;
		}
		return result;
	}
	@Override
	public String toString() {
		return top.toString();
	}
	public static void main(String[] args) {
		
		LinkedStack<String> lss = new LinkedStack<String>();
		for (String string : "Phasers or stun!".split(" ")) {
			lss.push(string);
		}
		System.out.println(lss);
		String s;
		while ((s = lss.pop()) != null) {
			System.out.println(s);
		}
	}
}
