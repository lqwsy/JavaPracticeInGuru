package com.guru.database;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MysqlConnection {

	
	
	public Connection connectMysql(){
		final String DRIVER = "com.mysql.jdbc.Driver";
		final String URL = "jdbc:mysql://localhost:3306/guru";
		final String USERNAME = "root";
		final String PASSWORD = "123456";
		
		Properties props = new Properties();
		
		Connection conn = null;
		try (InputStream in = Files.newInputStream(Paths.get("file/mysql.properties"))){

			//以配置文件的方式加载数据库配置
			props.load(in);
			String drivers = props.getProperty("jdbc.drivers");
			String db_url = props.getProperty("jdbc.url");
			String name = props.getProperty("jdbc.username");
			String password = props.getProperty("jdbc.password");
			
			Class.forName(drivers);
			System.out.println("加载驱动成功");
			
			conn = DriverManager.getConnection(db_url,name,password);
			System.out.println("链接数据库成功");
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return conn;
	}
	
	
	
}
