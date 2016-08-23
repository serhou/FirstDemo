package com.bestlove.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;


/**
 * Integer, String, Character可以与PriorityQueue一起工作，因为这些类已经内建了自然排序。
 * 如果你想在PriorityQueue中使用自己的类，就必须包括额外的功能以产生自然排序、或者必须
 * 提供自己的Comparator。
 * @author think
 *
 */

public class PriorityQueueDemo {

	public static void main(String[] args) {
		
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			priorityQueue.offer(rand.nextInt(i + 10));
		}
		//重复是允许的，最小值拥有最高的优先级
		QueueDemo.printQ(priorityQueue);
		
		List<Integer> ints = Arrays.asList(14, 85, 6, 45, 5, 6, 88, 98, 2, 85, 5, 3);
		//顺序反转
		priorityQueue = new PriorityQueue<Integer>(ints.size(), Collections.reverseOrder());
		priorityQueue.addAll(ints);
		QueueDemo.printQ(priorityQueue);
		
		String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
		List<String> strings = Arrays.asList(fact.split(""));
		PriorityQueue<String> stringPQ = new PriorityQueue<String>(strings);
		//如果是String，空格也可以算作值，并且比字母的优先级高
		QueueDemo.printQ(stringPQ);
		//顺序反转
		stringPQ = new PriorityQueue<String>(strings.size(), Collections.reverseOrder());
		stringPQ.addAll(strings);
		QueueDemo.printQ(stringPQ);
		
		Set<Character> charSet = new HashSet<Character>();
		for (char c : fact.toCharArray()) {
			charSet.add(c);//自动装箱Autoboxing
		}
		PriorityQueue<Character> characterPQ = new PriorityQueue<Character>(charSet);
		QueueDemo.printQ(characterPQ);
		
		
	}
	
	
}
