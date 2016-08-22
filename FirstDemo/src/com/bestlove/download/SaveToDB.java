package com.bestlove.download;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.alibaba.fastjson.JSON;
import com.bestlove.util.DBTool;



public class SaveToDB {

	public static List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
	
	public static void main(String[] args) {
		
		//读取文件：
		File file = new File("C:\\Users\\think\\Desktop\\spider\\list.jd.com1");	
		print(file);
		Connection conn = null;
		PreparedStatement pstmt = null;
		//写入数据库
		try {
			//连接数据库
			conn = DBTool.getConnPro("mysql");
			pstmt = DBTool.getPreparedStatement(conn, "INSERT INTO `jd` ( `title`, `price`, `detailurl`, `count`, `imageurl`) VALUES (?, ?, ?, ?, ?)");
			for (Map<String, String> map : resultList) {
				pstmt.setString(1, map.get("Title"));
				pstmt.setString(2, map.get("Price"));
				pstmt.setString(3, map.get("DetailUrl"));
				pstmt.setString(4, map.get("Count"));
				pstmt.setString(5, map.get("ImageUrl"));
				//执行sql
				System.out.println("开始插入："+map.get("DetailUrl"));
				pstmt.execute();
				System.out.println("成功！");
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBTool.closeSmall(pstmt, conn);
		}
		
		
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
						List nameList = (List) ((Map) obj).get("Name");
						List priceList = (List) ((Map) obj).get("Price");
						List detailUrlList = (List) ((Map) obj).get("DetailUrl");
						List countList = (List) ((Map) obj).get("Count");
						List imageUrlList = (List) ((Map) obj).get("ImageUrl");
						//imageUrlList需要处理空值和Done
						List newImageUrlList = new ArrayList();
						for (Object object : imageUrlList) {
							if(object instanceof String) {
								String str = (String) object;
								if(str!=null&&!"".equals(str.trim())&&!"done".equals(str.trim())){//地址中结果集中可能存在空字符和done
									newImageUrlList.add(str);
								}
							}
						}
						System.out.println(nameList.size()+","+priceList.size()+","+detailUrlList.size()+","+countList.size()+","+newImageUrlList.size());
						if(nameList.size() == priceList.size() && priceList.size() == countList.size() && detailUrlList.size() == countList.size() && newImageUrlList.size() == nameList.size()){
							for (int i = 0; i < nameList.size(); i++) {
								//标题
								String title = (String) nameList.get(i);
								
								//价格
								String price = ((String) priceList.get(i));
								
								//详情页
								String detailUrl = (String) detailUrlList.get(i);
								
								//评论条数：
								String count = (String) countList.get(i);
								
								//图片
								String imageUrl = ((String) newImageUrlList.get(i));
								imageUrl ="https:" + imageUrl;
								
								Map<String, String> map = new HashMap<String, String>();
								map.put("Title", title);
								map.put("Price", price);
								map.put("DetailUrl", detailUrl);
								map.put("Count", count);
								map.put("ImageUrl", imageUrl);
								
								//放入list
								resultList.add(map);
							}
						}
					}
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
