package com.bestlove.util;

import java.util.LinkedHashMap;

/**
 * Java泛型中的标记符含义：
 * E - Element（在集合中使用，因为集合中存放的是元素）
 * T - Type（Java类）
 * K - Key（键）
 * V - Value（值）
 * N - Number（数值类型）
 * ? - 表示不确定的java类型
 * S、U、V - 2nd、3rd、4th types
 * 
 * Object跟这些标记符代表的java类型的区别：
 * Object是所有类的根类，任何类的对象都可以设置给该Object引用变量，
 * 使用的时候可能需要类型强制转换，但是使用了泛型T、E等这些标识符后，
 * 在实际使用之前类型就已经确定了，不需要再进行类型强制转换。
 * 
 * @author think
 *
 * @param <K>
 * @param <V>
 */

public class MapData<K, V> extends LinkedHashMap<K, V> {

	public MapData(Generator<Pair<K, V>> gen, int quantity) {
		for (int i = 0; i < quantity; i++) {
			Pair<K, V> p = gen.next();
			put(p.KEY, p.VALUE);
		}
	}
	
	public MapData(Generator<K> genK, Generator<V> genV, int quantity) {
		for (int i = 0; i < quantity; i++) {
			put(genK.next(), genV.next());
		}
	}
	
	public MapData(Generator<K> genK, V value, int quantity) {
		for (int i = 0; i < quantity; i++) {
			put(genK.next(), value);
		}
	}
	
	public MapData(Iterable<K> genK, Generator<V> genV) {
		for (K key : genK) {
			put(key, genV.next());
		}
	}
	
	public MapData(Iterable<K> genK, V value) {
		for (K key : genK) {
			put(key, value);
		}
	}
	
	public static <K, V> MapData<K, V> map(Generator<Pair<K, V>> gen, int quantity) {
		return new MapData<K, V>(gen, quantity);
	}
	
	public static <K, V> MapData<K, V> map(Generator<K> genK, Generator<V> genV, int quantity) {
		return new MapData<K, V>(genK, genV, quantity);
	}
	
	public static <K, V> MapData<K, V> map(Generator<K> genK, V value, int quantity) {
		return new MapData<K, V>(genK, value, quantity);
	}
	
	public static <K, V> MapData<K, V> map(Iterable<K> genK, Generator<V> genV) {
		return new MapData<K, V>(genK, genV);
	}
	
	public static <K, V> MapData<K, V> map(Iterable<K> genK, V value) {
		return new MapData<K, V>(genK, value);
	}
}
