package com.bestlove.test;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

/**
 * 我们再次使用了适配器模式，在本例中，被适配的类可以通过继承和实现呢Readable接口来创建。
 * 因此，通过使用interface关键字提供的伪多重继承机制，我们可以生成既是RandomDoubles又是Readable的新类
 * 在这种方式中，我们可以在任何现有类之上添加新的接口，所以这意味着让方法
 * 接受接口类型，是一种任何类都可以对该方法进行适配的方式。这就是使用接口而不是类的强大之处。
 * @author think
 *
 */

public class AdaptedRandomDoubles extends RandomDoubles implements Readable {
	
	private int count;
	public AdaptedRandomDoubles(int count) {
		this.count = count;
	}

	@Override
	public int read(CharBuffer cb) throws IOException {
		if(count-- == 0){
			return -1;
		}
		String result = Double.toString(next()) + " ";
		cb.append(result);
		return result.length();
	}
	
	public static void main(String[] args) {
		RandomDoubles rd = new RandomDoubles();
		for (int i = 0; i < 7; i++) {
			System.out.println(rd.next() + " ");
		}
		System.out.println("=====================================");
		Scanner s = new Scanner(new AdaptedRandomDoubles(7));
		while (s.hasNextDouble()) {
			System.out.println(s.nextDouble());
		}
		s.close();
	}
}


class RandomDoubles {
	private static Random rand = new Random(47);
	public double next() {
		return rand.nextDouble();
	}
}