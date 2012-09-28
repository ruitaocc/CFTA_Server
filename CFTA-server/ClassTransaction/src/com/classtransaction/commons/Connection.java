package com.classtransaction.commons;

/**
 * 连接对象
 * 
 * @author ruitaocc@gmail.com
 * 
 */
public class Connection {

	//连接地址
	private String address;
	
	//连接端口
	private int port;
	
	public Connection(String address, int port) {
		this.address = address;
		this.port = port;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
}
