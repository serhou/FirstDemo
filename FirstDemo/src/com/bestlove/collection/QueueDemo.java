package com.bestlove.collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;


/**
 * offer()方法是与Queue相关的方法之一，它在允许的情况下，
 * 将一个元素插入到队尾，或者返回false。peek()和element()
 * 都将在不移除的情况下返回队头，但是peek()方法在队列为空时
 * 返回null，而element()会抛出NoSuchElementException异常。
 * poll()和remove()方法将移除并返回队头，但是poll()在队列
 * 为空时返回null;而remove()会抛出NoSuchElementException异常。
 * 
 * Queue接口窄化了对LinkedList的方法的访问权限，以使得只有恰当
 * 的方法才可以使用。
 * 
 * @author think
 *
 */

public class QueueDemo {

	public static void printQ(Queue<?> queue){
		
		while(queue.peek() != null){
			System.out.print(queue.remove() + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		Random rand  = new Random();
		for (int i = 0; i < 10; i++) {
			queue.offer(rand.nextInt(i + 10));
		}
		printQ(queue);
		Queue<Character> qc = new LinkedList<Character>();
		for (char c : "Brontosaurus".toCharArray()) {
			qc.offer(c);
		}
		printQ(qc);
	}
	
	
}
