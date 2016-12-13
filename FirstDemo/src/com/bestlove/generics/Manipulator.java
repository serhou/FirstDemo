package com.bestlove.generics;

/**
 * 边界<T extends HasF>声明T必须既有类型HasF或者从HasF导出的类型
 * 我们说泛型类型参数将擦除到它的第一个边界（它可能会有多个边界）
 * 只有当你希望使用的类型参数比某个具体类型（以及它的所有子类型）
 * 更加“泛化”时——也就是说，当你希望代码能够跨多个类工作时，使用
 * 泛型才有所帮助。
 * 因此，类型参数和它们在有用的泛型代码中的应用，通常比简单的类替换
 * 要更复杂。但是，不能因此而认为<T extends HasF>形式的任何东西都
 * 是有缺陷的 。例如，如果某个类有一个返回T的方法，那么泛型就有所帮助，
 * 因为它们之后将返回确切的类型。
 * 
 * class ReturnGenericType<T extedns HasF> {
 * 		private T obj;
 * 		public ReturnGenericType(T x) {
 * 			obj = x;
 * 		}
 * 		public T get() {
 * 			return obj;
 * 		}
 * }
 * @author think
 *
 * @param <T>
 */

public class Manipulator<T extends HasF>{
	private T obj;
	public Manipulator(T x) {
		obj = x;
	}
	public void manipulate() {
		obj.f();
	}
}

class HasF {
	public void f() {
		System.out.println("HasF.f()");
	}
}