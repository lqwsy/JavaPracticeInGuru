package com.guru.practice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.guru.database.MysqlConnection;
import com.guru.thread.MyThread;


public class MainTest {
	
	public static void main(String[] args) {
//		ReflectObject.getClassObject();
//		ReflectObject.getConstructor(8);
		ReflectObject.reflectFromProperties();
	}
	
	public static void testThread(){
		Thread a = new MyThread("thread a");
	}
	
	public static void testArrayList(){
		List<String> staff = new LinkedList<>();
		staff.add("Amy");
		staff.add("Bob");
		staff.add("ami");
		Iterator<String> iter = staff.iterator();
		String first = (String) iter.next();
		String second = (String) iter.next();
		iter.remove();
		System.out.println(first.hashCode());
		System.out.println(second.hashCode());
	}	
	
	public static void testConnectMysql(){
		try {
			Connection conn = new MysqlConnection().connectMysql();
			Statement state = null;
			state = conn.createStatement();
			String sql = "select * from people";
			
			ResultSet rst = state.executeQuery(sql);
			
			while(rst.next()){
				System.out.println("id: "+rst.getInt(1));
				System.out.println("name: "+rst.getString(2));
				System.out.println("age: "+rst.getInt(3));
			}
			rst.close();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public static <T> T getMiddle(T... a){
		return a[a.length/2];
	}
	
}
