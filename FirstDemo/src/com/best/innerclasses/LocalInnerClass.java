package com.best.innerclasses;

/**
 * 我们使用局部内部类而不使用匿名内部类的唯一理由是，我们需要一个已命名的构造器，
 * 或者需要重载构造器，而匿名内部类只能用于实例初始化。
 * 使用局部内部类而不使用匿名内部类的另一个理由是，需要不止一个该内部类的对象
 * 
 * 
 * 内部类标识符
 * 由于每个类都会产生一个.class文件，其中包含了如何创建该类型的对象的全部信息。
 * 内部类也必须生成一个.class文件以包含它们的Class对象信息。
 * 这些类文件的命名有严格的规则：外围类的名字，加上“$”，再加上内部类的名字。
 * 
 * 如果内部类是匿名的，编译器会简单地产生一个数字作为其标识符。
 * 如果内部类是嵌套在别的内部类之中，只需直接将它们的名字加在其外围类标识符与“$”的后面。
 * 
 * 虽然这种命名格式简单而直接，但它还是很健壮的，足以应对绝大多数情况。因为这是
 * Java的标准命名方式，所以产生的文件自动都是平台无关的。
 * 
 * 
 * @author think
 *
 */

public class LocalInnerClass {

	private int count = 0;
	
	Counter getCounter(final String name) {
		class LocalCounter implements Counter {
			public LocalCounter() {
				System.out
						.println("LocalInnerClass.getCounter(...).LocalCounter.LocalCounter()");
			}

			@Override
			public int next() {
				System.out.println(name);
				return count++;
			}
		}
		return new LocalCounter();
	}
	
	Counter getCounter2(final String name) {
		return new Counter() {
			{
				System.out
						.println("LocalInnerClass.getCounter2(...).new Counter() {...}.getCounter2()");
			}
			@Override
			public int next() {
				System.out.println(name);
				return count++;
			}
		};
	}
	
	public static void main(String[] args) {
		
		LocalInnerClass lic = new LocalInnerClass();
		
		Counter c1 = lic.getCounter("Local inner "), 
				c2 = lic.getCounter2("Anonymous inner ");

		for (int i = 0; i < 5; i++) {
			System.out.println(c1.next());
		}
		for (int i = 0; i < 5; i++) {
			System.out.println(c2.next());
		}
		
	}
	
}

interface Counter {
	int next();
}