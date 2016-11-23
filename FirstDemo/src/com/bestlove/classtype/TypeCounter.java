package com.bestlove.classtype;

import java.util.HashMap;
import java.util.Map;

import org.bouncycastle.crypto.RuntimeCryptoException;

public class TypeCounter extends HashMap<Class<?>, Integer> {
	private Class<?> baseType;
	public TypeCounter(Class<?> baseType) {
		this.baseType = baseType;
	}
	public void count(Object obj) {
		Class<?> type = obj.getClass();
		//isAssignableFrom()来执行运行时的检查，以校验传递的对象确实属于我们感兴趣的继承结构
		if(!baseType.isAssignableFrom(type)) {
			throw new RuntimeCryptoException(obj + " incorrect type: "
					+ type + ", should be type or subtype of "
							+ baseType);
		} else {
			countClass(type);
		}
	}
	private void countClass(Class<?> type) {
		Integer quantity = get(type);
		put(type, quantity == null ? 1 : quantity + 1);
		Class<?> superClass = type.getSuperclass();
		//isAssignableFrom()判定此 Class 对象所表示的类或接口与指定的 Class 
		//参数所表示的类或接口是否相同，或是否是其超类或超接口。
		if(superClass != null && baseType.isAssignableFrom(superClass)){
			countClass(superClass);//递归
		}
	}
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("{");
		for (Map.Entry<Class<?>, Integer> pair : entrySet()) {
			result.append(pair.getKey().getSimpleName())
				.append("=")
				.append(pair.getValue())
				.append(", ");
		}
		result.delete(result.length()-2, result.length());
		result.append("}");
		return result.toString();
	}
}
