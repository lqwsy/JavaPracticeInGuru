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
 * �������
 * */
public class ReflectObject {

	
	//Java������ƣ���ȡ����ʽ
	public static void getClassObject(){
		//��ȡ��������ַ�ʽ,һ���õ����ַ���
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
	
	//��ȡ���췽��,���ԣ�����
	public static void getConstructor(int type){
		//���ض���
		try {
			Class empClass = Class.forName("com.guru.practice.Employee");
			switch(type){
			case 1:
				//��ȡ���й����Ĺ��췽��
				Constructor[] consts = empClass.getConstructors();
				for(Constructor c : consts){
					System.out.println(c);
				}
				break;
			case 2:
				//��ȡ���еĹ��췽�����������У�˽�У�������
				consts = empClass.getDeclaredConstructors();
				for(Constructor c : consts){
					System.out.println(c);
				}
				break;
			case 3:
				//��ȡ�����޲εĹ��췽��
				Constructor con = empClass.getConstructor(null);
				System.out.println("con : "+con);
				//���ù��췽��
				Object obj = con.newInstance();
				Employee emp = (Employee)obj;
				System.out.println("obj : "+obj+""+emp.getName());
				break;
			case 4:
				//��ȡ˽�й��췽��
				Constructor cons = empClass.getDeclaredConstructor(String.class);
				System.out.println("cons : "+cons);
				//���ù��췽��
				cons.setAccessible(true);
				Object object = cons.newInstance("bob");
				Employee emps = (Employee)object;
				System.out.println(emps.getName());
				break;
			case 5:
				//��ȡ���й����ֶ�
				Field[] fieldArray = empClass.getFields();
				for(Field f : fieldArray){
					System.out.println(f);
				}
				break;
			case 6:
				//��ȡ�����ֶ�
				fieldArray = empClass.getDeclaredFields();
				for(Field f : fieldArray){
					System.out.println(f);
				}
				break;
			case 7:
				//��ȡ�����ֶβ�����
				fieldArray = empClass.getFields();
				Field f = empClass.getField("name");
				System.out.println(f);
				Object pObj = empClass.getConstructor().newInstance();
				f.set(pObj, "gay");
				Employee empp = (Employee) pObj;
				System.out.println("��֤����"+empp.name);
				break;
			case 8:
				//��ȡ�����ֶβ�����
				f = empClass.getDeclaredField("salary");
				System.out.println(f);
				Object pObjc = empClass.getConstructor().newInstance();
				f.setAccessible(true);//ǿ��ͻ��Ȩ��
				f.set(pObjc, 10000);
				Employee empps = (Employee) pObjc;
				System.out.println(empps.getSalary());
				break;
			case 9:
				//��ȡ���з���
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

	//ͨ�������ļ�������
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
