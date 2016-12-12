package com.bestlove.generics;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * 泛型的一个重要好处是能够简单而安全地创建复杂的模型
 * 尽管看上去有些冗[rǒng]长（特别是迭代器的创建），但
 * 最终还是没有用过多的代码就得到了一个相当强大的数据
 * 结构
 * @author think
 *
 * @param <A>
 * @param <B>
 * @param <C>
 * @param <D>
 */

public class TupleList<A, B, C, D> extends ArrayList<FourTuple<A, B, C, D>>{

	public static void main(String[] args) throws ParseException {
		
		TupleList<Calendar, BigDecimal, String, Date> tl = new TupleList<Calendar, BigDecimal, String, Date>();
		tl.add(TupleTest2.h());
		tl.add(TupleTest2.h());
		for (FourTuple<Calendar, BigDecimal, String, Date> fourTuple : tl) {
			System.out.println(fourTuple);
		}
	}
	
	
}
