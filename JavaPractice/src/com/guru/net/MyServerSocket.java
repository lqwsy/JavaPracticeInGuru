package com.guru.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServerSocket {

	public void startServer() {
		try (ServerSocket socket = new ServerSocket(8189);

		) {
			try (Socket incomming = socket.accept();) {
				InputStream is = incomming.getInputStream();
				OutputStream os = incomming.getOutputStream();
				try(Scanner in = new Scanner(is)){
					PrintWriter pw = new PrintWriter(os,true);
					pw.println("Hello Enter BYE to exit");
					boolean result = false;
					while(!result && in.hasNextLine()){
						String line = in.nextLine();
						pw.println("server: "+line);
						if(line.trim().equals("BYE")){
							result = true;
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
