package com.bestlove.generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import com.bestlove.util.Generator;

/**
 * 匿名内部类的使用
 * 银行柜员服务顾客的故事
 * @author think
 *
 */

public class BankTeller {

	public static void serve(Teller t, Customer c) {
		System.out.println(t + " serves " + c);
	}
	
	public static void main(String[] args) {
		Random rand = new Random();
		Queue<Customer> line = new LinkedList<Customer>();
		Generators.fill(line, Customer.generator(), 15);
		List<Teller> tellers = new ArrayList<Teller>();
		Generators.fill(tellers, Teller.generator, 4);
		for (Customer c : line) {
			serve(tellers.get(rand.nextInt(tellers.size())), c);
		}
	}
}


class Customer {
	private static long counter = 1;
	private final long id = counter++;
	//构造器私有
	private Customer() {
	}
	public String toString() {
		return "Customer " + id;
	}
	//只能通过公共方法来创建对象
	public static Generator<Customer> generator() {
		return new Generator<Customer>() {
			@Override
			public Customer next() {
				return new Customer();
			}
		};
	}
}

class Teller {
	private static long counter = 1;
	private final long id = counter++;
	//私有化构造器
	private Teller() {
	}
	public String toString() {
		return "Teller " + id;
	}
	public static Generator<Teller> generator = new Generator<Teller>() {
		@Override
		public Teller next() {
			return new Teller();
		}
	};
}