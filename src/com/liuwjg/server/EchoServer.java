package com.liuwjg.server;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
	public static void main(String[] args) throws IOException{
		ServerSocket serverSocket = new ServerSocket(8888);
		System.out.println("等待客户端连接");
		Socket socket = serverSocket.accept();
		System.out.println("客户端连接成功"+socket.getInetAddress());
		Scanner  scanner = new Scanner(socket.getInputStream());
		scanner.useDelimiter("\n");
		PrintStream printWriter = new PrintStream(socket.getOutputStream());
		boolean flag = true;
		while(flag){
			
			if(scanner.hasNext()){
				String val = scanner.next();
				if("byebye".equals(val)){
					printWriter.print("再见!");
					flag = false;
				}else{
					printWriter.println("[ECHO]"+val);
					printWriter.flush();
				}
			}
			
		}
		scanner.close();
		printWriter.close();
		socket.close();
	}
}
