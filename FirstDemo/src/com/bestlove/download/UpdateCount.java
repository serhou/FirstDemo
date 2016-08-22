package com.bestlove.download;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.bestlove.util.DBTool;

public class UpdateCount {

	
public static List<Map> resultList = new ArrayList<Map>();
	
	public static void main(String[] args) {
		
		//读取文件：
		File file = new File("C:\\Users\\think\\Desktop\\spider");	
		print(file);
		updateDB();
		
		
	}


	public static void updateDB() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		//写入数据库
		try {
			//连接数据库
			conn = DBTool.getConnPro("mysql");
			//关闭自动提交事务
			conn.setAutoCommit(false);
			for (Map map : resultList) {
				pstmt = DBTool.getPreparedStatement(conn, "update `jd` set `count` = ? where `id` = ?");
				pstmt.setBigDecimal(1, new BigDecimal(map.get("commentCount").toString()));
				pstmt.setBigDecimal(2, new BigDecimal(map.get("skuId").toString()));
				//执行sql
				System.out.println("开始更新：" + map.get("skuId") + ", 评论数：" + map.get("commentCount"));
				pstmt.execute();
				System.out.println("更新成功！");
				//开始插入数据库
				pstmt = DBTool.getPreparedStatement(conn, "INSERT IGNORE INTO `jdcomment` (`goodRate`, `productId`, `beginRowNumber`, `goodRateShow`, `poorRateStyle`, `score4Count`, `poorRateShow`, `generalRate`, `poorRate`, `score2Count`, `commentCount`, `averageScore`, `showCount`, `score5Count`, `generalCount`, `endRowNumber`, `goodCount`, `score3Count`, `generalRateStyle`, `score1Count`, `skuId`, `goodRateStyle`, `generalRateShow`, `poorCount`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				pstmt.setBigDecimal(1, new BigDecimal(map.get("goodRate").toString()));
				pstmt.setBigDecimal(2, new BigDecimal(map.get("productId").toString()));
				pstmt.setBigDecimal(3, new BigDecimal(map.get("beginRowNumber").toString()));
				pstmt.setBigDecimal(4, new BigDecimal(map.get("goodRateShow").toString()));
				pstmt.setBigDecimal(5, new BigDecimal(map.get("poorRateStyle").toString()));
				pstmt.setBigDecimal(6, new BigDecimal(map.get("score4Count").toString()));
				pstmt.setBigDecimal(7, new BigDecimal(map.get("poorRateShow").toString()));
				pstmt.setBigDecimal(8, new BigDecimal(map.get("generalRate").toString()));
				pstmt.setBigDecimal(9, new BigDecimal(map.get("poorRate").toString()));
				pstmt.setBigDecimal(10, new BigDecimal(map.get("score2Count").toString()));
				pstmt.setBigDecimal(11, new BigDecimal(map.get("commentCount").toString()));
				pstmt.setBigDecimal(12, new BigDecimal(map.get("averageScore").toString()));
				pstmt.setBigDecimal(13, new BigDecimal(map.get("showCount").toString()));
				pstmt.setBigDecimal(14, new BigDecimal(map.get("score5Count").toString()));
				pstmt.setBigDecimal(15, new BigDecimal(map.get("generalCount").toString()));
				pstmt.setBigDecimal(16, new BigDecimal(map.get("endRowNumber").toString()));
				pstmt.setBigDecimal(17, new BigDecimal(map.get("goodCount").toString()));
				pstmt.setBigDecimal(18, new BigDecimal(map.get("score3Count").toString()));
				pstmt.setBigDecimal(19, new BigDecimal(map.get("generalRateStyle").toString()));
				pstmt.setBigDecimal(20, new BigDecimal(map.get("score1Count").toString()));
				pstmt.setBigDecimal(21, new BigDecimal(map.get("skuId").toString()));
				pstmt.setBigDecimal(22, new BigDecimal(map.get("goodRateStyle").toString()));
				pstmt.setBigDecimal(23, new BigDecimal(map.get("generalRateShow").toString()));
				pstmt.setBigDecimal(24, new BigDecimal(map.get("poorCount").toString()));
				System.out.println("插入：" + map.get("skuId") + ", 评论数：" + map.get("commentCount") + ", 好评率：" + map.get("goodRate"));
				pstmt.execute();
				System.out.println("插入成功！");
			}
			//提交事务
			conn.commit();
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
			if(file.getName().substring(file.getName().lastIndexOf(".")).equals(".html")){
				//读取文件：
				List<String> list = getJava(file.getAbsolutePath());
				for (String string : list) {
					//获取切割字符串
					String jsonStr = string.split("P_Json:")[1].trim();
					if(jsonStr!=null && !"".equals(jsonStr)){
						//解析JSON对象字符串
						Object obj = JSON.parse(jsonStr);
						if(obj instanceof Map){
							Map objMap = (Map) obj;
							Map resultMap = (Map) objMap.get("productCommentSummary");
							resultList.add(resultMap);
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
				if(line.trim().startsWith("P_Json")){
					list.add(line.trim());
				}
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
