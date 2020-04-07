package com.liuwjg.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClient {
	
	private static final BufferedReader KEYBOARD_INPUT = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost",8888);
		
		Scanner scan = new Scanner(socket.getInputStream());
		boolean falg = true;
		PrintStream out = new PrintStream(socket.getOutputStream());
		while(falg){
			String str = getString("请输入要发送的消息");
			out.println(str);
			if(scan.hasNext()){
				String aa = scan.next();
				System.out.println(aa);
			}
			if("byebye".equals(str)){
				falg = false;
			}
		}
		out.close();
		socket.close();
	}
	
	public static String getString(String str) throws IOException{
		System.out.println(str);
		String s = KEYBOARD_INPUT.readLine();
		return s;
	}
}
