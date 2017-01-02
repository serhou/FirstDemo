package com.bestlove.generics;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * 转型与警告
 * @author think
 *
 */

public class GenericCast {
	public static final int SIZE = 10;
	public static void main(String[] args) {
		FixedSizeStack<String> strings = new FixedSizeStack<String>(SIZE);
		for (String s : "A B C D E F G H I J".split(" ")) {
			strings.push(s);
		}
		for (int i = 0; i < SIZE; i++) {
			String s = strings.pop();
			System.out.print(s + " ");
		}
	}
}

class FixedSizeStack<T> {
	private int index = 0;
	private Object[] storage;
	public FixedSizeStack(int size) {
		storage = new Object[size];
	}
	public void push(T item) {
		storage[index++] = item;
	}
	/**
	 * 如果没有@SuppressWarnings注解，编译器将对pop()产生"unchecked cast"警告
	 * 由于擦除的原因，编译器无法知道这个转型是否是安全的，并且pop()方法实际上
	 * 并没有执行任何转型。这是因为，T被擦除到它的第一个边界，默认情况下是Object，
	 * 因此pop()实际上只是将Object转型为Object
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T pop() {
		return (T) storage[--index];
	}
}

/**
 * 泛型没有消除对转型的需要，这就会由编译器产生警告，而这个警告是不恰当的
 * @author think
 *
 */
class NeedCasting {
	@SuppressWarnings("unchecked")
	public void f(String[] args) throws Exception {
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream(args[0]));
		//readObject()无法知道它正在读取的是什么，因此它返回的是必须转型的对象
		List<Widget> shapes = (List<Widget>) in.readObject();
	}
}

class ClassCasting {
	@SuppressWarnings("unchecked")
	public void f(String[] args) throws Exception {
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream(args[0]));
		//readObject()无法知道它正在读取的是什么，因此它返回的是必须转型的对象
		//List<Widget> lw1 = List<Widget>.class.cast(in.readObject());//不能转型到实际类型(List<Widget>)
		List<Widget> lw2 = List.class.cast(in.readObject());//还会警告
	}
}
