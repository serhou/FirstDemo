package com.bestlove.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 由于擦除的原因，将泛型应用于一场是非常受限的。
 * catch语句不能捕获泛型类型的异常，因为在编译期
 * 和运行时都必须知道异常的确切类型。
 * 泛型类也不能直接或间接继承自Throwable（这将
 * 进一步阻止你去定义不能捕获的泛型异常）
 * @author think
 *
 */

public class ThrowGenericException {
	public static void main(String[] args) {
		ProcessRunner<String, Failure1> runner = 
				new ProcessRunner<String, Failure1>();
		for (int i = 0; i < 3; i++) {
			runner.add(new Processor1());
		}
		try {
			System.out.println(runner.processAll());
		} catch (Failure1 e) {
			System.out.println(e);
		}
		ProcessRunner<Integer, Failure2> runner2 = 
				new ProcessRunner<Integer, Failure2>();
		for (int i = 0; i < 3; i++) {
			runner2.add(new Processor2());
		}
		try {
			System.out.println(runner2.processAll());
		} catch (Failure2 e) {
			System.out.println(e);
		}
	}
}

interface Processor<T, E extends Exception> {
	void process(List<T> resultCollector) throws E;
}

class ProcessRunner<T, E extends Exception> 
	extends ArrayList<Processor<T, E>> {
	List<T> processAll() throws E {
		List<T> resultCollector = new ArrayList<T>();
		for (Processor<T, E> processor : this) {
			processor.process(resultCollector);
		}
		return resultCollector;
	}
}

class Failure1 extends Exception {}

class Processor1 implements Processor<String, Failure1> {
	static int count = 3;
	@Override
	public void process(List<String> resultCollector) throws Failure1 {
		if(count-- > 1) {
			resultCollector.add("Hep!");
		} else {
			resultCollector.add("Ho!");
		}
		if(count < 0) {
			throw new Failure1();
		}
	}
}

class Failure2 extends Exception {}

class Processor2 implements Processor<Integer, Failure2> {
	static int count = 2;
	@Override
	public void process(List<Integer> resultCollector) throws Failure2 {
		if(count-- == 0) {
			resultCollector.add(47);
		} else {
			resultCollector.add(11);
		}
		if(count < 0) {
			throw new Failure2();
		}
	}
}