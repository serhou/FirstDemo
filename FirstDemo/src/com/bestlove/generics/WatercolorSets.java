package com.bestlove.generics;

import java.util.EnumSet;
import java.util.Set;
import static com.bestlove.generics.Watercolors.*;
import static com.bestlove.generics.Sets.*;

/**
 * 用1234567890数字来表示比水彩颜色要更容易识别一些吧
 * @author think
 *
 */

public class WatercolorSets {

	public static void main(String[] args) {
		
		Set<Watercolors> set1 = EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);
		Set<Watercolors> set2 = EnumSet.range(CERULEAN_BLUE_HUE, BURNT_UMBER);
		System.out.println("set1: " + set1);
		System.out.println("set2: " + set2);
		//并集
		System.out.println("union(set1, set2): " + union(set1, set2));
		//交集
		Set<Watercolors> subset = intersection(set1, set2);
		System.out.println("intersection(set1, set2): " + subset);
		System.out.println("difference(set1, subset): " + difference(set1, subset));
		System.out.println("difference(set2, subset): " + difference(set2, subset));
		System.out.println("complement(set1, set2): " + complement(set1, set2));
	}
	
	
	
}
