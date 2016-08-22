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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.bestlove.util.DBTool;

public class UpdatePriceFromJson {

	public static List<Map<String, BigDecimal>> resultList = new ArrayList<Map<String, BigDecimal>>();
	
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
			pstmt = DBTool.getPreparedStatement(conn, "update `jd` set `price` = ? where `id` = ?");
			for (Map<String, BigDecimal> map : resultList) {
				pstmt.setBigDecimal(1, map.get("Price"));
				pstmt.setBigDecimal(2, map.get("Id"));
				//执行sql
				System.out.println("开始更新：" + map.get("Id") + ", 价格：" + map.get("Price"));
				pstmt.execute();
				System.out.println("更新成功！");
				
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
			if(file.getName().substring(file.getName().lastIndexOf(".")).equals(".json")){
				//读取文件：
				List<String> list = getJava(file.getAbsolutePath());
				for (String string : list) {
					//解析JSON对象字符串
					Object obj = JSON.parse(string);
					if(obj instanceof Map){
						Map objMap = (Map) obj;
						Map resultMap = (Map) objMap.get("P_Json");
						//此时得到的还是String还需要继续解析
						Object resultObj = JSON.parse((String) resultMap.get("firstSourceText"));
						JSONArray jsonArray = (JSONArray) resultObj;
						for (Object object : jsonArray) {
							if(object instanceof Map){
								Map map = (Map) object;
								BigDecimal price =new BigDecimal((String)map.get("p"));
								BigDecimal id =new BigDecimal(((String)map.get("id")).substring(2));
								Map<String, BigDecimal> rMap = new HashMap<String, BigDecimal>();
								rMap.put("Price", price);
								rMap.put("Id", id);
								resultList.add(rMap);
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
