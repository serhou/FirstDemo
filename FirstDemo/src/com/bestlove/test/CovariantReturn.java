package com.bestlove.test;

/**
 * Java SE5与Java较早版本之间的主要差异就是较早的版本将强制process()的覆盖版本必须返回Grain,
 * 而不能返回Wheat，尽管Wheat是从Grain导出的，因而也应该是一种合法的返回类型。
 * 协变返回类型允许返回更具体的Wheat类型。
 * @author think
 *
 */


public class CovariantReturn {

	public static void main(String[] args) {
		
		Mill m = new Mill();
		Grain g = m.process();
		System.out.println(g);
		m = new WheatMill();
		g = m.process();
		System.out.println(g);
		
	}
	
}

class Grain {
	public String toString() {
		return "Grain";
	}
}

class Wheat extends Grain {
	public String toString() {
		return "Wheat";
	}
}

class Mill {
	Grain process() {
		return new Grain();
	}
}

class WheatMill extends Mill {
	Wheat process() {
		return new Wheat();
	}
}
