package com.bestlove.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 残酷的现实是：在泛型代码内部，无法获得任何有关泛型参数类型的信息
 * Java泛型是使用擦除来实现的，这意味着当你在使用泛型时，任何具体的
 * 类型信息都被擦除了，你唯一知道的就是你在使用一个对象。因此List<String>
 * 和List<Integer> 在运行时事实上是相同的类型。这两种形式都被擦除成它们的
 * “原生”类型，即List。
 * 理解擦除以及应该如何处理它，是你在学习Java泛型时面临的最大障碍。
 * @author think
 *
 */

public class LostInformation {

	public static void main(String[] args) {
		
		List<Frob> list = new ArrayList<Frob>();
		Map<Frob, Fnorkle> map = new HashMap<Frob, Fnorkle>();
		Quark<Fnorkle> quark = new Quark<Fnorkle>();
		Particle<Long, Double> p = new Particle<Long, Double>();
		//Class.getTypeParameters()将返回一个TypeVariable对象数组，表示有泛型声明所声明的类型参数
		System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
		System.out.println(Arrays.toString(map.getClass().getTypeParameters()));
		System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));
		System.out.println(Arrays.toString(p.getClass().getTypeParameters()));
		/*
		[E]
		[K, V]
		[Q]
		[POSITION, MOMENTUM]
		*/
		
	}
	
}

class Frob {}
class Fnorkle {}
class Quark<Q> {}
class Particle<POSITION, MOMENTUM> {}
