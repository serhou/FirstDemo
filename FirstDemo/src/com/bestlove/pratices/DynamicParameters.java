package com.bestlove.pratices;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 可变参数
 * @author think
 *
 */

public class DynamicParameters {

	
	public static void getNothing(Object... args){
		for (Object object : args) {
			System.out.println(object.getClass().getTypeName());
		}
	}
	
	public static void yesterdayOnceMore(Integer integer, String... strs){
		System.out.println("Integer:"+integer);
		for (int i = 0; i < strs.length; i++) {
			/**
			 *  很常见的典型案例就是这个String类中的format方法
			 *  
			 *  public static String format(String format, Object... args) {
        	 *		return new Formatter().format(format, args).toString();
    		 *	}
			 */
			System.out.println(String.format("strs[%s]: %s", i, strs[i]));
		}
	}
	
	public static void main(String[] args) {
		
		getNothing(1, "HelloWorld", 2.56F, new Date(), 1==3, new ArrayList(), new HelloWorld());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("date", new Date());
		map.put("time", LocalTime.now());
		getNothing(new Random().nextInt(12), "你好，中国！", new Object []{1, 3, 5, "这几天心里颇不平静。"}, map);
		
		yesterdayOnceMore(100, "我去", "你去哪儿？", "我不知道！");
		yesterdayOnceMore(93, "我不去", "你不去哪儿？", "我不知道！", "净瞎扯！");
		yesterdayOnceMore(1999);
		yesterdayOnceMore(18893, new String[]{"张三丰", "李元霸", "柳如是"});//非常好的例子
		
		Spiciness[] sp = Spiciness.values();
		for (Spiciness spiciness : sp) {
			System.out.println(spiciness);
			System.out.println(spiciness.ordinal());
		}
		
		testEnum(Spiciness.FLAMING);
		testEnum(Spiciness.HOT);
		testEnum(Spiciness.MILD);
		testEnum(Spiciness.NOT);
	}

	private static void testEnum(Spiciness spiciness) {
		switch (spiciness) {
		case NOT:
			System.out.println("我是NOT:"+spiciness);
			break;  //避免case穿透
		case HOT:
			System.out.println("我是HOT:"+spiciness);
			break;
		default:
			System.out.println("你是谁:"+spiciness);
			break;
		}
	}
	
	
	
}


class HelloWorld{ 
	int a = 1;
}

enum Spiciness{
	//枚举
	NOT, MILD, MEDIUM, HOT, FLAMING
}
