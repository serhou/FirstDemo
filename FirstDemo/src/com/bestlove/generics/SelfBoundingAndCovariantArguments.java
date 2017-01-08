package com.bestlove.generics;

/**
 * 使用了自限定，重写了，而非重载
 * @author think
 *
 */

public class SelfBoundingAndCovariantArguments {

	void testA(Setter s1, Setter s2, SelfBoundSetter sbs) {
		s1.set(s2);
//		s1.set(sbs);//Error
		//编译器不能识别将基类型当做参数传递给set()的尝试，因为没有
		//任何发方法具有这样的签名。实际上，这个参数已经被覆盖
	}
	
}

interface SelfBoundSetter<T extends SelfBoundSetter<T>> {
	void set(T arg);
}

interface Setter extends SelfBoundSetter<Setter> {}