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
 * ����������
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
			//����ServerSocket����, �˿�Ϊ12000
			serverSocket = new ServerSocket(12000);
			//System.out.println("-->server11");
			while(true) {
				//����Socket������
			//	System.out.println("-->server22");
				Socket socket1 = serverSocket.accept();
				//�����������߳�
			//	System.out.println("-->server33");
				new ServerThread(socket1).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServerException("�����������쳣: " + e.getMessage());
		}
		}
	};

}
