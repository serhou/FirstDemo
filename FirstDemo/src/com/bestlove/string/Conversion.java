package com.bestlove.string;

import java.math.BigInteger;
import java.util.Formatter;

/**
 * Formatter转换：包含了最常用的类型转换
 * 被注释的代码表示，针对相应类型的变量，这些转换是无效的。
 * 如果执行这些转换，则会触发异常
 * 注意，程序中的每个变量都用到了b转换，虽然它对各种类型都是合法的，
 * 但其行为却不一定与你想象的一致。对于boolean基本类型或者Boolean对象，
 * 其转换结果对于的true或false。但是，对其他类型的参数，只要该参数不为null，
 * 那转换的结果就永远都是true。即使是数字0，转换结果依然为true。
 * 所以将b应用于非布尔类型的对象时请格外小心。
 * @author think
 *
 */

public class Conversion {

	public static void main(String[] args) {
		
		Formatter f = new Formatter(System.out);
		
		char u = 'a';
		System.out.println("u = 'a'");
		f.format("s: %s\n", u);//字符串String
//		f.format("d: %d\n", u);//整数型（十进制） java.util.IllegalFormatConversionException
		f.format("c: %c\n", u);//Unicode字符
		f.format("b: %b\n", u);//布尔值Boolean
//		f.format("f: %f\n", u);//浮点数（十进制）
//		f.format("e: %e\n", u);//浮点数（科学计数）
//		f.format("x: %x\n", u);//整数（十六进制）
		f.format("h: %h\n", u);//散列码（十六进制）
		
		
		int v = 121;
		System.out.println("v = 121");
		f.format("d: %d\n", v);//整数型（十进制） java.util.IllegalFormatConversionException
		f.format("c: %c\n", v);//Unicode字符
		f.format("b: %b\n", v);//布尔值Boolean
		f.format("s: %s\n", v);//字符串String
//		f.format("f: %f\n", v);//浮点数（十进制）
//		f.format("e: %e\n", v);//浮点数（科学计数）
		f.format("x: %x\n", v);//整数（十六进制）
		f.format("h: %h\n", v);//散列码（十六进制）
		
		
		BigInteger w = new BigInteger("500000000000000");
		System.out.println("w = new BigInteger(\"500000000000000\")");
		f.format("d: %d\n", w);//整数型（十进制） java.util.IllegalFormatConversionException
//		f.format("c: %c\n", w);//Unicode字符
		f.format("b: %b\n", w);//布尔值Boolean
		f.format("s: %s\n", w);//字符串String
//		f.format("f: %f\n", w);//浮点数（十进制）
//		f.format("e: %e\n", w);//浮点数（科学计数）
		f.format("x: %x\n", w);//整数（十六进制）
		f.format("h: %h\n", w);//散列码（十六进制）
		
		
		double x = 179.543;
		System.out.println("x = 179.543");
//		f.format("d: %d\n", x);//整数型（十进制） java.util.IllegalFormatConversionException
//		f.format("c: %c\n", x);//Unicode字符
		f.format("b: %b\n", x);//布尔值Boolean
		f.format("s: %s\n", x);//字符串String
		f.format("f: %f\n", x);//浮点数（十进制）
		f.format("e: %e\n", x);//浮点数（科学计数）
//		f.format("x: %x\n", x);//整数（十六进制）
		f.format("h: %h\n", x);//散列码（十六进制）
		
		Conversion y = new Conversion();
		System.out.println("y = new Conversion()");
//		f.format("d: %d\n", y);//整数型（十进制） java.util.IllegalFormatConversionException
//		f.format("c: %c\n", y);//Unicode字符
		f.format("b: %b\n", y);//布尔值Boolean
		f.format("s: %s\n", y);//字符串String
//		f.format("f: %f\n", y);//浮点数（十进制）
//		f.format("e: %e\n", y);//浮点数（科学计数）
//		f.format("x: %x\n", y);//整数（十六进制）
		f.format("h: %h\n", y);//散列码（十六进制）
		
		boolean z = false;
		System.out.println("z = false");
//		f.format("d: %d\n", z);//整数型（十进制） java.util.IllegalFormatConversionException
//		f.format("c: %c\n", z);//Unicode字符
		f.format("b: %b\n", z);//布尔值Boolean
		f.format("s: %s\n", z);//字符串String
//		f.format("f: %f\n", z);//浮点数（十进制）
//		f.format("e: %e\n", z);//浮点数（科学计数）
//		f.format("x: %x\n", z);//整数（十六进制）
		f.format("h: %h\n", z);//散列码（十六进制）
	}
	
}
