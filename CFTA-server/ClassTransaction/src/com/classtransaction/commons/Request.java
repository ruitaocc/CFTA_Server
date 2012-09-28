package com.classtransaction.commons;

import java.util.HashMap;
import java.util.Map;



/**
 * ������, ��ʾ�ͻ������������һ������
 * 
 *@author ruitaocc@gmail.com
 */
public class Request {

	//����
	private Map<String, Object> parameters;
	
	//������������
	private String serverActionClass;
	
	private String clientActionClass;
	public Request() {
		this.serverActionClass = "";
		this.parameters = new HashMap<String, Object>();
		this.clientActionClass = "";
	}
	public Request(String serverActionClass, String clientActionClass) {
		this.serverActionClass = serverActionClass;
		this.parameters = new HashMap<String, Object>();
		this.clientActionClass = clientActionClass;
	}
	
	public Map<String, Object> getParameters() {
		return this.parameters;
	}
	
	public void setParameter(String key, Object value) {
		this.parameters.put(key, value);
	}
	
	public Object getParameter(String key) {
		return this.parameters.get(key);
	}

	public String getServerActionClass() {
		return serverActionClass;
	}

	public void setServerActionClass(String serverActionClass) {
		this.serverActionClass = serverActionClass;
	}

	public String getClientActionClass() {
		return clientActionClass;
	}

	public void setClientActionClass(String clientActionClass) {
		this.clientActionClass = clientActionClass;
	}

	public String toXML() {
		return com.classtransaction.util.XStreamUtil.toXML(this);
	}
}
