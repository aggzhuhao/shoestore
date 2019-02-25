package com.jdbc;

import java.sql.*;

public class DbConnection {
	/*private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";*/
	
	
	private static final String DRIVER;
	private static final String URL;
	private static final String USERNAME;
	private static final String PASSWORD;
	
	static {
		DbConfigReader dbConfigReader = new DbConfigReader();
		DRIVER = dbConfigReader.getValue("driver");
		URL = dbConfigReader.getValue("url");
		USERNAME = dbConfigReader.getValue("username");
		PASSWORD = dbConfigReader.getValue("password");
	}
	
	/**
	 * 建立数据库连接
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn = null;
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return conn;
	}
	
	/**
	 * 关闭数据库连接
	 * @param rs
	 * @param st
	 * @param conn
	 */
	public static void close(ResultSet rs, Statement st, Connection conn){
		try {
			if (rs != null){
				rs.close();
			}
			
			if (st != null){
				st.close();
			}
			
			if (conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(DbConnection.getConnection());

	}

}
