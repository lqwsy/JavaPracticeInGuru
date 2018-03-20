package com.guru.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class OperatingFile {

	
	public void createFile(){
		try {
			Path directory = Paths.get("file/temp");
			Path sourceFile = Paths.get("file/a.txt");
			Path copyFile = Paths.get("file/temp/temp.txt");
			
			Files.copy(sourceFile, copyFile,StandardCopyOption.REPLACE_EXISTING);
			System.out.println("copy file success");
			
//			Files.createDirectory(directory);
//			System.out.println("create directory successful!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public void createTempFile(){
		try {
			Path rootDirectory = Paths.get("file");
			Path tempDirectory = Files.createTempDirectory(rootDirectory, "");
			
			System.out.println(tempDirectory.toString());
			
			Path tempFile = Files.createTempFile(tempDirectory,"","");
			System.out.println(tempFile.toString());
			
			deleteFile(tempFile);
			deleteFile(tempDirectory);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void deleteFile(Path deleteDirectory){
		try {
			Files.delete(deleteDirectory);
			System.out.println("delete file successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
