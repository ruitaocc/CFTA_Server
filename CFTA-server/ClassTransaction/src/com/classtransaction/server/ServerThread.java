package com.classtransaction.server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import com.classtransaction.commons.ErrorCode;
import com.classtransaction.commons.Request;
import com.classtransaction.commons.Response;
import com.classtransaction.commons.ServerAction;
import com.classtransaction.util.XStreamUtil;
import com.classtransaction.dao.impl.UserDaoImpl;;
/**
 * 服务器引擎线程, 用于处理服务器接受请求与作出响应
 * 
 * @author ruitaocc@gmail.com
 *
 */
public class ServerThread extends Thread {

	private Socket socket;
	
	private BufferedReader br;
	
	private String line;
	
	private PrintStream ps;

	//保存被创建的Action对象
	public Map<String, ServerAction> actions = new HashMap<String, ServerAction>();
	
	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		try {
			this.br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			while((this.line = br.readLine()) != null) {
			//	System.out.println("\n服务器响应--》"+this.line+"\n");
			
				
				//得到请求对象
				Request request = 	getRequest(this.line);
			    //	System.out.println("123"+request.toXML());
				
				//从request中得到客户端处理类, 并且构造Response对象
				Response response = new Response(request.getClientActionClass());
				
				
				//将请求的参数都设置到Response中
				copyParameters(request, response);
				
				
				//如果字符串不能转换成Request对象, 则设置错误码并返回
				if (request == null) {
					response.setErrorCode(ErrorCode.REQUEST_ERROR);
					this.ps = new PrintStream(socket.getOutputStream());
					this.ps.println(getResponseXML(response));
					break;
				}
				
				//得到Server处理类
				ServerAction action = getAction(request.getServerActionClass());
				
				//如果找不到对应的Action, 返回错误信息, 找到则执行Action
				if (action == null) {
					response.setErrorCode(ErrorCode.COMMAND_NOT_FOUND);
					this.ps = new PrintStream(socket.getOutputStream());
					this.ps.println(getResponseXML(response));
				} else {
					action.execute(request, response, this.socket);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//将Request中的参数map设置到Response的data中
	private void copyParameters(Request request, Response response) {
		Map<String, Object> parameters = request.getParameters();
		for (String key : parameters.keySet()) {
			response.setData(key, parameters.get(key));
		}
	}
	
	//将一次服务器响应转换成XML字符串
	private String getResponseXML(Response response) {
		return XStreamUtil.toXML(response);
	}
	
	//将字符串转换成一个Request对象
	private Request getRequest(String xml) {
		try {
			Request r = (Request)XStreamUtil.fromXML(xml);
			//System.out.println(r.toXML());
			return r;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//从Map中得到Action对象, 如果拿不到, 则创建
	private ServerAction getAction(String className) {
		try {
			if (actions.get(className) == null) {
				ServerAction action = (ServerAction)Class.forName(className).newInstance();
				actions.put(className, action);
			}
			return actions.get(className);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
