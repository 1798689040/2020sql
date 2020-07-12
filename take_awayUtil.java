package cn.edu.zucc.take_away.util;

import java.sql.Connection;

import java.sql.Connection;

public class take_awayUtil {
	private static final String jdbcUrl="jdbc:mysql://localhost:3306/take_away?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
	private static final String dbUser="root";
	private static final String dbPwd="1234";
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws java.sql.SQLException{
		return java.sql.DriverManager.getConnection(jdbcUrl, dbUser, dbPwd);
	}
}
