package com.best.innerclasses;

/**
 * private内部类给类的设计者提供了一种途径，通过这种方式可以完全
 * 阻止任何依赖于类型的编码，并且完全隐藏了实现的细节。此外，从
 * 客户端程序员的角度来看，由于不能访问任何新增加的、原本不属于
 * 公共接口的方法，所以扩展接口是没有价值的。这也给java编译器提供了
 * 生成更高效代码的机会。
 * @author think
 *
 */

interface Destination {
	String readLabel();
}

interface Contents {
	int value();
}


class Parcel4 {
	private class PContents implements Contents {
		private int i = 11;
		public int value() {
			return i;
		}
	}
	protected class PDestination implements Destination {
		private String label;
		private PDestination(String whereTo) {
			label = whereTo;
		}
		@Override
		public String readLabel() {
			return label;
		}
	}
	public Destination destination(String s) {
		return new PDestination(s);
	}
	public Contents contents() {
		return new PContents();
	}
}



public class TestParcel {

	public static void main(String[] args) {
		
		Parcel4 p4 = new Parcel4();
		Contents c = p4.contents();
		Destination d = p4.destination("Tasmania");
		System.out.println(c.value());
		System.out.println(d.readLabel());
	}
	
	
}
