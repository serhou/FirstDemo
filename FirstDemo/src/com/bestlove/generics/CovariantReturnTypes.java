package com.bestlove.generics;

/**
 * 参数协变
 * 协变返回类型是在java SE5中引入的
 * 
 * DerivedGetter中的get()方法覆盖了OrdinaryGetter中的get()，
 * 并返回了一个从OrdinaryGetter.get()的返回类型中导出的类型。
 * 尽管这是合乎逻辑的事情（导出类方法应该能够返回比它覆盖的
 * 基类方法更具体的类型）但是这在早先的Java版本中是不合法的。
 * 
 * @author think
 *
 */

public class CovariantReturnTypes {
	void test(DerivedGetter d) {
		Derived d2 = d.get();
	}
}


class Base {}
class Derived extends Base {}

interface OrdinaryGetter {
	Base get();
}

interface DerivedGetter extends OrdinaryGetter {
	Derived get();
}

