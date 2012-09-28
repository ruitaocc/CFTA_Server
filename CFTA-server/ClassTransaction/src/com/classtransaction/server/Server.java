package com.classtransaction.server;

import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import com.classtransaction.service.ServerException;

/**
 * 服务器对象
 * 
 * @author ruitaocc@gmail.com
 * 
 */
public class Server{

	ServerSocket serverSocket;
	
	public Server() {
		new Thread(r).start();
		
	}
	
	Runnable r = new Runnable()
	{
		public void run()
		{
			try {
			//创建ServerSocket对象, 端口为12000
			serverSocket = new ServerSocket(12000);
			//System.out.println("-->server11");
			while(true) {
				//监听Socket的连接
			//	System.out.println("-->server22");
				Socket socket1 = serverSocket.accept();
				//启动服务器线程
			//	System.out.println("-->server33");
				new ServerThread(socket1).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServerException("创建服务器异常: " + e.getMessage());
		}
		}
	};

}
