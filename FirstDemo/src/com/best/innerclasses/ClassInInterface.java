package com.best.innerclasses;

/**
 * 正常情况下，不能在接口内部放置任何代码，但嵌套类可以作为接口的一部分。
 * 你放到接口中的任何类都自动地是public和static的。
 * 因为类是static的，只是将嵌套类置于接口的命名空间内，这并不违反接口的规则。
 * 你甚至可以在内部类中实现其外围接口。
 * @author think
 *
 */

public interface ClassInInterface {

	void howdy();
	
	class Test implements ClassInInterface {
		@Override
		public void howdy() {
			System.out.println("ClassInInterface.Test.howdy()");
		}
		public static void main(String[] args) {
			System.out.println("ClassInInterface.Test.main()");
			new Test().howdy();
		}
	}
	
}
