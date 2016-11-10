package com.bestlove.string;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * \b 指词的边界
 * "\\b[Ssct]\\w+" 指搜索以[Ssct]开头的单词
 * 我们也可以从Python, JavaScript等语言中的
 * 正则表达式中学到一些猫腻，这些方面都是雷同的
 * 
 * @author think
 *
 */

public class JGrep {

	public static void main(String[] args) throws Exception {
		
		args = new String[] {"src/com/bestlove/string/JGrep.java", "\\b[Ssct]\\w+"};
		
		if(args.length < 2){
			System.out.println("Usage: java JGrep file regex");
			System.exit(0);
		}
		
		Pattern p = Pattern.compile(args[1]);
		int index = 0;
		Matcher m = p.matcher("");
		for (String line : readTextFileToList(args[0])) {
			m.reset(line);
			while (m.find()) {
				System.out.println(index++ + ": " 
						+ m.group() 
						+ ": " 
						+ m.start());
			}
		}
	}
	
	/**
	 * 读取文件内容
	 * @param string
	 * @return 
	 * @throws Exception
	 */
	private static List<String> readTextFileToList(String string) throws Exception {
		List<String> list = new ArrayList<String>();
		FileInputStream fileInputStream = new FileInputStream(new File(string));
		byte[] b = new byte[1024];
		int len = 0;
		while((len = fileInputStream.read(b)) != -1){
			String str = new String(b, 0, len);
			list.add(str);
		}
		fileInputStream.close();
		return list;
	}
	
	
}
