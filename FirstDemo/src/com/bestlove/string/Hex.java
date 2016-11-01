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
			if(n % 16 == 0){
				result.append(String.format("%05X: ", n));//n的值
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
			System.out.println(format("我们美丽的中国。每天怎么样开始，没有人能过预知".getBytes()));
		}else{
			System.out.println(format(args[0].getBytes()));
		}
	}
	
}
