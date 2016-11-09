package com.bestlove.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 组 Groups
 * groupCount()返回该匹配器的模式中的分组数目 第0组不包括在内  0代表整个匹配的串
 * group()返回前一次匹配操作
 * group(int i)返回在前一次匹配操作期间指定的组号，如果匹配成功，但是指定的组没
 * 有匹配输入字符串的任何部分，则将返回null
 * start(int group)返回在前一次匹配操作中寻找到的起始索引
 * end(int group)返回在前一次匹配操作中寻找到的组的最后一个字符索引加一的值
 * $与整个输入序列的末端相匹配
 * 模式标记(?m)
 * @author think
 *
 */

public class Groups {

	public static final String POEM = 
			"Twas brillig, and the slithy toves\n"
			+ "Did gyre and gimble in the wabe.\n"
			+ "All mimsy were the borogoves,\n"
			+ "And the mome raths outgrabe.\n\n"
			+ "Beware the Jabberwock, my son,\n"
			+ "The jaws that bite, the claws that catch.\n"
			+ "Beware the Jubjub bird, and shun\n"
			+ "The frumious Bandersnatch.";
	public static void main(String[] args) {//\\S非空白符    \\s空白符
		Matcher m = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$")//后三位非空白符字符
				.matcher(POEM);
		while (m.find()) {
			for (int i = 0; i <= m.groupCount(); i++) {
				System.out.print("["+m.group(i)+"]");//看看分组都是啥
			}
			System.out.println();
		}
	}
	
}
