package com.bestlove.string;

import java.io.File;
import java.io.FileInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 替换操作  appendReplacement 执行渐进式替换
 * @author think
 *
 */


/*! Here's a block  of text to use as input to
    the regular expression   matcher. Note that we'll 
    first extract the block     of text by looking for 
    the special delimiters,       then process the 
    extracted block. !*/

public class TheReplacements {

	public static void main(String[] args) throws Exception{
		
		String s = readTextFile("src/com/bestlove/string/TheReplacements.java");
		
		Matcher m = Pattern.compile("/\\*!(.*)!\\*/", 
				Pattern.DOTALL).matcher(s);
		if(m.find()){
			s = m.group(1);
		}
		System.out.println(s);
		s = s.replaceAll(" {2,}", " ");//将存在两个或两个以上空格的地方，缩减为一个空格
		System.out.println("--------------");
		System.out.println(s);
		s = s.replaceAll("(?m)^ +", "");//删除每行开头的空格
		System.out.println("--------------");
		System.out.println(s);
		s = s.replaceFirst("[aeiou]", "(VOWEL1)");//只对找到的第一个匹配进行替换
		System.out.println("--------------");//replaceFirst()和replaceAll()用来替换的只是普通的字符串
		System.out.println(s);
		StringBuffer sbuf = new StringBuffer();
		Pattern p = Pattern.compile("[aeiou]");
		Matcher ma = p.matcher(s);
		while(ma.find()) {
			ma.appendReplacement(sbuf, ma.group().toUpperCase());
		}
		ma.appendTail(sbuf);
		System.out.println("--------------");
		System.out.println(sbuf.toString());
	}

	
	/**
	 * 读取文件内容
	 * @param string
	 * @return 
	 * @throws Exception
	 */
	private static String readTextFile(String string) throws Exception {
		StringBuilder sb = new StringBuilder();
		FileInputStream fileInputStream = new FileInputStream(new File(string));
		byte[] b = new byte[1024];
		int len = 0;
		while((len = fileInputStream.read(b)) != -1){
			String str = new String(b, 0, len);
			sb.append(str);
		}
		fileInputStream.close();
		return sb.toString();
	}
	
}
