package com.guru.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IOpractice {

	
	public void readFile(String fileUrl){
		try {
			FileInputStream fin = new FileInputStream(fileUrl);
			byte[] data =new byte[15];
			fin.read(data);
			System.out.println(new String(data).trim());
			fin.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readAndWriteFile(){
		
		
	}
	
	public void buildPath(){
		try {
			Path absolute = Paths.get("/home","cay");//绝对路径
			Path relative = Paths.get("myprog","config");//相对路径
			BufferedReader reader = Files.newBufferedReader(absolute,Charset.forName("UTF-8"));
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
