package com.bestlove.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 更加泛化的潜在类型机制
 * 这正是具有潜在类型机制的参数化类型机制的价值所在，
 * 因为你不会受任何特定类库的创建者过去所作的设计决策的
 * 支配，因此不需要再每一次碰到一个没有考虑到你的具体情况
 * 的新类库时，都去重写代码（因此这样的代码才是真正的泛化）
 * 即便SimpleQueue有一个add()方法，它也不能工作，因为这会
 * 将代码现在为只能工作于Collection，因此这样的代码不是特别
 * “泛化”。有了潜在类型机制，情况就会不同了
 * @author think
 *
 */

public class FillTest {
	public static void main(String[] args) {
		List<Contract> contracts = new ArrayList<Contract>();
		Fill.fill(contracts, Contract.class, 3);
		Fill.fill(contracts, TitleTransfer.class, 2);
		for (Contract contract : contracts) {
			System.out.println(contract);
		}
		SimpleQueue<Contract> contractQueue = new SimpleQueue<Contract>();
//		Fill.fill(contractQueue, Contract.class, 4);
	}
}

class Fill {
	public static <T> void fill(Collection<T> collection, 
			Class<? extends T> classToken, int size) {
		for (int i = 0; i < size; i++) {
			try {
				collection.add(classToken.newInstance());
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
}

class Contract {
	private static long counter = 0;
	private final long ID = counter++;
	public String toString() {
		return getClass().getName() + " " + ID;
	}
}

class TitleTransfer extends Contract {}