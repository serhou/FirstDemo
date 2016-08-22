package com.bestlove.util;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
/**
 * 数据库工具类
 * 0、加载驱动并连接数据库方法：读取配置文件法
 * 1、加载驱动建立连接
 * 2、静态处理快
 * 3、预加载处理块
 * 4、释放资源带结果集
 * 5、释放资源不带结果集
 * @author think
 *
 */
public class DBTool {
	//静态代码块
	private static Properties pro = new Properties();
	static{
		try {
			pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//0、加载驱动并连接数据库方法：读取配置文件法 默认使用Mysql
	public static Connection getConnPro(String DBType) throws ClassNotFoundException, SQLException {
		//默认MYSQL
		String driverStr = pro.getProperty("mysqldriver");
		String urlStr = pro.getProperty("mysqlurl");
		String userStr = pro.getProperty("mysqluser");
		String pwdStr = pro.getProperty("mysqlpwd");
		//选择特定的数据库
		if("DB2".equalsIgnoreCase(DBType)){
			driverStr = pro.getProperty("driver");
			urlStr = pro.getProperty("url");
			userStr = pro.getProperty("user");
			pwdStr = pro.getProperty("pwd");
		}
		
		// 加载驱动
		Class.forName(driverStr);
		// 建立连接
		return DriverManager.getConnection(urlStr, userStr, pwdStr);
	}
	
	
	
	
	//1、加载驱动并连接数据库方法
	public static Connection getConn() throws ClassNotFoundException, SQLException {
		String driverStr = "oracle.jdbc.driver.OracleDriver";
		String urlStr = "jdbc:oracle:thin:@localhost:1521:orcl";
		String userStr = "scott";
		String pwdStr = "think";
		// 加载驱动
		Class.forName(driverStr);
		// 建立连接
		return DriverManager.getConnection(urlStr, userStr, pwdStr);
	}
	///2、 静态处理块
	public static Statement getStatement(Connection conn) throws SQLException{
		if(null==conn){
			return null;
		}
		return conn.createStatement();
	}
	///3、预处理块
	public static PreparedStatement getPreparedStatement(Connection conn,String sql) throws SQLException{
		if(null==conn){
			return null;
		}
		return conn.prepareStatement(sql);
	}
	//4、释放资源带结果集
	public static void close(ResultSet rs,Statement stmt,Connection conn){
		try {
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(stmt!=null){
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//5、释放资源不带结果集
	public static void closeSmall(Statement stmt,Connection conn){
		try {
			if(stmt!=null){
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
