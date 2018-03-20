package com.guru.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NetWorkPractice {

	public void connectionNetWork() {
		try (Socket net = new Socket("www.baidu.com", 80);
			 InputStream ins = net.getInputStream();
			 ) {
			Scanner scan = new Scanner(ins);
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				System.out.println(line);
			}
			scan.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void connectionServer(){
		try(Socket socket = new Socket("127.0.0.1",8189)){
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os,true);
			
			Scanner scanin = new Scanner(System.in);
			Scanner scanout = new Scanner(is);
			while(scanin.hasNextLine()&&scanout.hasNextLine()){
				String line = scanout.nextLine();
				String input = scanin.nextLine();
				pw.write(input);
				System.out.println("from server: "+line);
			}
			scanin.close();
			scanout.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
