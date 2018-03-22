package com.guru.practice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 反射机制
 * */
public class ReflectObject {

	
	//Java反射机制，获取对象方式
	public static void getClassObject(){
		//获取对象的三种方式,一般用第三种方法
		//1
		Employee em1 = new Employee("bibliwang",25,1000);
		Class emClass1 = em1.getClass();
		System.out.println("method1 : "+emClass1.getName());
		
		
		//2
		Class emClass2 = Employee.class;
		System.out.println("method2 : "+(emClass1==emClass2));
		
		//3
		try {
			Class emClass3 = Class.forName("com.guru.practice.Employee");
			System.out.println("method3 : "+(emClass2==emClass3));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//获取构造方法,属性，方法
	public static void getConstructor(int type){
		//加载对象
		try {
			Class empClass = Class.forName("com.guru.practice.Employee");
			switch(type){
			case 1:
				//获取所有公共的构造方法
				Constructor[] consts = empClass.getConstructors();
				for(Constructor c : consts){
					System.out.println(c);
				}
				break;
			case 2:
				//获取所有的构造方法，包括共有，私有，保护等
				consts = empClass.getDeclaredConstructors();
				for(Constructor c : consts){
					System.out.println(c);
				}
				break;
			case 3:
				//获取共有无参的构造方法
				Constructor con = empClass.getConstructor(null);
				System.out.println("con : "+con);
				//调用构造方法
				Object obj = con.newInstance();
				Employee emp = (Employee)obj;
				System.out.println("obj : "+obj+""+emp.getName());
				break;
			case 4:
				//获取私有构造方法
				Constructor cons = empClass.getDeclaredConstructor(String.class);
				System.out.println("cons : "+cons);
				//调用构造方法
				cons.setAccessible(true);
				Object object = cons.newInstance("bob");
				Employee emps = (Employee)object;
				System.out.println(emps.getName());
				break;
			case 5:
				//获取所有共有字段
				Field[] fieldArray = empClass.getFields();
				for(Field f : fieldArray){
					System.out.println(f);
				}
				break;
			case 6:
				//获取所有字段
				fieldArray = empClass.getDeclaredFields();
				for(Field f : fieldArray){
					System.out.println(f);
				}
				break;
			case 7:
				//获取共有字段并调用
				fieldArray = empClass.getFields();
				Field f = empClass.getField("name");
				System.out.println(f);
				Object pObj = empClass.getConstructor().newInstance();
				f.set(pObj, "gay");
				Employee empp = (Employee) pObj;
				System.out.println("验证姓名"+empp.name);
				break;
			case 8:
				//获取共有字段并调用
				f = empClass.getDeclaredField("salary");
				System.out.println(f);
				Object pObjc = empClass.getConstructor().newInstance();
				f.setAccessible(true);//强行突破权限
				f.set(pObjc, 10000);
				Employee empps = (Employee) pObjc;
				System.out.println(empps.getSalary());
				break;
			case 9:
				//获取共有方法
				Method[] methodArray = empClass.getMethods();
				Method m = empClass.getMethod("setName", String.class);
				Object objs = empClass.getConstructor().newInstance();
				m.invoke(objs, "bob");
				break;
			default:
				break;
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
	}

	//通过配置文件来反射
	public static void reflectFromProperties(){
		try {
			Properties pro = new Properties();
			FileReader in = new FileReader("file/a.txt");
			pro.load(in);
			in.close();
			String className = pro.getProperty("className");
			String methodName = pro.getProperty("methodName");
			
			Class empClass = Class.forName(className);
			Method method = empClass.getMethod(methodName);
			System.out.println(method.invoke(empClass.getConstructor().newInstance()));;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
	}
	
}
