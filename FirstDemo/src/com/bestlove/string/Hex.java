package com.bestlove.string;

/**
 * 一个十六进制转储(dump)工具
 * 在处理二进制文件时，我们经常希望以十六进制的格式看看其内容
 * @author think
 *
 */

public class Hex {

	public static String format(byte[] data) {
		StringBuilder result = new StringBuilder();
		int n = 0;
		for (byte b : data) {
			if(n % 16 == 0){//满足条件的n都是16的倍数了
				result.append(String.format("%05X: ", n));//n的值 长度5，少的补0 大写X 表示十六进制的字母为大写
			}
			result.append(String.format("%02X ", b));//b的值
			n++;
			if(n % 16 == 0){
				result.append("\n");
			}
		}
		result.append("\n");
		return result.toString();
	}
	
	public static void main(String[] args) {
		if(args.length == 0){
			System.out.println(format(("我们美丽的中国。每天怎么会样开始，没有人能过预知。"
					+ "[\"拟古决绝词柬友\","
					+ "\"人生若只如初见，何事秋风悲画扇？"
					+ "等闲变却故人心，却道故人心易变。\","
					+ "\"骊山语罢清宵半，泪雨零铃终不怨。"
					+ "何如薄倖锦衣郎，比翼连枝当日愿。\"]"
					+ "[\"立秋夜雨，送梁汾南行\","
					+ "\"盼银河迢递，惊入夜，转清商。"
					+ "乍西园蝴蝶，轻翻麝粉，暗惹蜂黄。"
					+ "炎凉。等闲瞥眼，甚丝丝点点搅柔肠。"
					+ "应是登临送客，别离滋味重尝。\","
					+ "\"疑将。水墨罨疏窗。孤影澹潇湘。"
					+ "倩一叶高梧，半条残烛，做尽商量。"
					+ "荷裳。被风暗翦，问今宵谁与盖鸳鸯。"
					+ "从此羁愁万叠，梦回分付啼螀。\"]").getBytes()));
		}else{
			System.out.println(format(args[0].getBytes()));
		}
	}
	
}
