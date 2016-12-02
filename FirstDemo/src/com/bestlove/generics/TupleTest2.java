package com.bestlove.generics;

import static com.bestlove.generics.Tuple.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * 简化元组的使用
 * 在这个例子中，编译器并没有关于f2()的警告信息，因为我们
 * 并没有将其返回值作为参数化对象使用。在某种意义上，它被
 * “向上转型”为一个非参数化的TwoTuple。然而，如果试图将f2()
 * 的返回值转型为参数化的TwoTuple，编译器就会发出警告
 * @author think
 *
 */

public class TupleTest2 {

	static TwoTuple<String, Integer> f() {
		//return Tuple.tuple("hi", 89);
		return tuple("hi", 98);//静态导入类后直接调用静态方法
	}
	
	static TwoTuple f2() {
		return tuple("hi", 65);
	}
	
	static ThreeTuple<Date, String, Integer> g() {
		return tuple(new Date(), "hi", 92);
	}
	
	static FourTuple<Calendar, BigDecimal, String, Date> h() throws ParseException {
		return tuple(Calendar.getInstance(), new BigDecimal("183.48"), "hi", new SimpleDateFormat("yyyyMMdd").parse("20161123"));
	}
	
	static FiveTuple<Calendar, BigDecimal, String, Date, Double> k() throws ParseException {
		return tuple(Calendar.getInstance(), new BigDecimal("183.48"), "hi", new SimpleDateFormat("yyyyMMdd").parse("20161123"), 218.44);
	}
	
	public static void main(String[] args) throws ParseException {
		
		TwoTuple<String, Integer> ttsi = f();
		System.out.println(ttsi);
		System.out.println(f2());
		System.out.println(g());
		System.out.println(h());
		System.out.println(k());
	}
	
}
