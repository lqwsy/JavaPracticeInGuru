package com.guru.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {

	
	
	public Connection connectMysql(){
		final String DRIVER = "com.mysql.jdbc.Driver";
		final String URL = "jdbc:mysql://localhost:3306/guru";
		final String USERNAME = "root";
		final String PASSWORD = "123456";
		
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			System.out.println("���������ɹ�");
			
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			System.out.println("�������ݿ�ɹ�");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	
}
