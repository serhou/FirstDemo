package com.bestlove.generics;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class TestTuple {
	
	public static void main(String[] args) {
		
		TwoTuple<Date, Integer> t = 
				new TwoTuple<Date, Integer>(new Date(), Integer.valueOf("1030"));
		System.out.println(t);
		System.out.println(new ThreeTuple<String, Double, Calendar>(
				"时间", 
				Double.valueOf("121.34"), 
				Calendar.getInstance()));
		System.out.println(new FourTuple<String, Double, Calendar, BigDecimal>(
				"神马", 
				Double.valueOf("231.45324"), 
				Calendar.getInstance(), 
				new BigDecimal("143.432")));
		
		System.out.println(new FiveTuple<String, Double, Calendar, BigDecimal, Long>(
				"毫秒", 
				Double.valueOf("434"), 
				Calendar.getInstance(), 
				new BigDecimal("1745.99"),
				new Date().getTime()));
	}
}

class TwoTuple<A, B> {

	public final A FIRST;
	public final B SECOND;
	public TwoTuple(A a, B b) {
		FIRST = a;
		SECOND = b;
	}
	@Override
	public String toString() {
		return "(" + FIRST + ", " + SECOND + ")";
	}
}

class ThreeTuple<A, B, C> extends TwoTuple<A, B> {

	public final C THIRD;
	public ThreeTuple(A a, B b, C c) {
		super(a, b);
		THIRD = c;
	}
	@Override
	public String toString() {
		return "(" + FIRST + ", " + SECOND + ", " + THIRD + ")";
	}
}

class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> {

	public final D FOURTH;
	public FourTuple(A a, B b, C c, D d) {
		super(a, b, c);
		FOURTH = d;
	}
	@Override
	public String toString() {
		return "(" + FIRST + ", " + SECOND + ", " + THIRD + ", " + FOURTH + ")";
	}
}

class FiveTuple<A, B, C, D, E> extends FourTuple<A, B, C, D> {

	public final E FIFTH;
	public FiveTuple(A a, B b, C c, D d, E e) {
		super(a, b, c, d);
		FIFTH = e;
	}
	@Override
	public String toString() {
		return "(" + FIRST + ", " + SECOND + ", " + THIRD + ", " + FOURTH + ", " + FIFTH + ")";
	}
}