package com.bestlove.generics;

import com.bestlove.util.Generator;

/**
 * 这个例子引出了Java泛型的一个局限性：基本类型无法作为类型参数
 * 不过，Java SE5 具备了自动打包和自动拆包的功能，可以很方便的
 * 在基本类型和其相应的包装器类型之间转换
 * @author think
 *
 */

public class Fibonacci implements Generator<Integer>{
	private int count = 0;
	@Override
	public Integer next() {
		return fib(count++);
	}

	private int fib(int n) {
		if(n < 2) {
			return 1;
		} else {
			return fib(n-2) + fib(n-1);
		}
	}
	
	public static void main(String[] args) {
		Fibonacci gen = new Fibonacci();
		for (int i = 0; i < 18; i++) {
			System.out.print(gen.next() + " ");
		}
		
	}
	
}
