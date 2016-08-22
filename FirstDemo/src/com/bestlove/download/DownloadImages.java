package com.bestlove.download;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import java.util.UUID;

import org.apache.commons.io.FileUtils;

import com.alibaba.fastjson.JSON;

public class DownloadImages {

	
	public static Set<String> set = new LinkedHashSet<String>();
	static int count = 0;
	public static void main(String[] args) {
		//读取文件：
		File file = new File("C:\\Users\\think\\Desktop\\spider");	
		print(file);
		itSet();
		System.out.println(count);
		
	}
	
	public static void print(File file){
		
		if(file==null || !file.exists()){
			return;
		}
		
		if(file.isDirectory()){		
			
			File [] files = file.listFiles();
			for(File f:files){
				print(f);
			}
		}else{
			if(file.getName().substring(file.getName().lastIndexOf(".")).equals(".json")){
				//读取文件：
				List<String> list = getJava(file.getAbsolutePath());
				for (String string : list) {
					//解析JSON对象字符串
					Object obj = JSON.parse(string);
					if(obj instanceof Map){
						//解析地址
						set.add(((Map)obj).get("url").toString());
					}
					
				}
			}
		}
	}
	
	
	
	private static void itSet() {
		//对set进行迭代
		if(set!=null && set.size()>0){
			for (String string : set) {
				count++;
				//进行下载
				System.out.println(string);
				try {
					String fileName ="C:/Users/think/Desktop/spider/images/奥迪RS7/" + UUID.randomUUID() + "-" + (new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()))+string.substring(string.lastIndexOf("."));  
					FileUtils.copyURLToFile(new URL(string), new File(fileName));
					System.out.println("文件保存至：" + fileName);
					Thread.sleep(10000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	private static List<String> getJava(String filePath) {
		List<String> list = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));//路径为工程目录下
			String line = null;
			while((line=reader.readLine())!=null && !"".equals(line.trim())){
				list.add(line.trim());
			}
			//关闭流
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
