package com.bestlove.test;

/**
 * 不能在运行期间决定继承不同的对象，因为它要求在编译期间完全确定下来。
 * 一条通用的准则是：“用继承表达行为间的差异，并用字段表达状态上的变化”。
 * 在这个例子中，两者都用到了：通过继承得到了两个不同的类，用于表达act()
 * 方法的差异，而Stage通过运用组合使自己的状态发生变化。
 * 在这种情况下，这种状态的改变也就产生了行为的改变。
 * @author think
 *
 */


public class Transmogrify {

	public static void main(String[] args) {
		Stage stage = new Stage();
		stage.performPlay(); //HappyActor.act()
		stage.change();
		stage.performPlay(); //SadActor.act()
	}
	
}

class Actor {
	public void act() {}
}

class HappyActor extends Actor {
	public void act() {
		System.out.println("HappyActor.act()");
	}
}

class SadActor extends Actor {
	public void act() {
		System.out.println("SadActor.act()");
	}
}

class Stage {
	private Actor actor = new HappyActor();
	public void change() {
		actor = new SadActor();
	}
	public void performPlay() {
		actor.act();
	}
}



