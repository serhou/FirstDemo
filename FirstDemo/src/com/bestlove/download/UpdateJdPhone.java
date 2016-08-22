package com.bestlove.download;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bestlove.util.DBTool;

public class UpdateJdPhone {

	
	public static void main(String[] args) {
		
		
		//先查询出全部的
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		//写入数据库
		try {
			//连接数据库
			conn = DBTool.getConnPro("mysql");
			//关闭自动提交事务
			conn.setAutoCommit(false);
			pstmt = DBTool.getPreparedStatement(conn, "select price from jd where price is not null");
			rs = pstmt.executeQuery();
			while(rs.next()){
				/*String detailUrl = rs.getString("detailurl");
				System.out.println("处理：" + detailUrl);
				//准备Id
				Long id = Long.valueOf(detailUrl.substring(detailUrl.lastIndexOf("/")+1, detailUrl.lastIndexOf(".")));
				//然后更新
				System.out.println("处理后：" + id);
				//更新数据库
				pstmt2 = DBTool.getPreparedStatement(conn, "update `jd` set `id`=? where `detailurl`=? ");
				pstmt2.setLong(1, id);
				pstmt2.setString(2, detailUrl);
				//执行
				pstmt2.execute();*/
				System.out.println(rs.getBigDecimal("price"));
			}
			//提交事务
			conn.commit();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBTool.close(rs, pstmt, conn);
		}
		
	}
	
	
}
