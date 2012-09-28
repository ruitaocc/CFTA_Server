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
 * �����������߳�, ���ڴ������������������������Ӧ
 * 
 * @author ruitaocc@gmail.com
 *
 */
public class ServerThread extends Thread {

	private Socket socket;
	
	private BufferedReader br;
	
	private String line;
	
	private PrintStream ps;

	//���汻������Action����
	public Map<String, ServerAction> actions = new HashMap<String, ServerAction>();
	
	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		try {
			this.br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			while((this.line = br.readLine()) != null) {
			//	System.out.println("\n��������Ӧ--��"+this.line+"\n");
			
				
				//�õ��������
				Request request = 	getRequest(this.line);
			    //	System.out.println("123"+request.toXML());
				
				//��request�еõ��ͻ��˴�����, ���ҹ���Response����
				Response response = new Response(request.getClientActionClass());
				
				
				//������Ĳ��������õ�Response��
				copyParameters(request, response);
				
				
				//����ַ�������ת����Request����, �����ô����벢����
				if (request == null) {
					response.setErrorCode(ErrorCode.REQUEST_ERROR);
					this.ps = new PrintStream(socket.getOutputStream());
					this.ps.println(getResponseXML(response));
					break;
				}
				
				//�õ�Server������
				ServerAction action = getAction(request.getServerActionClass());
				
				//����Ҳ�����Ӧ��Action, ���ش�����Ϣ, �ҵ���ִ��Action
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
	
	//��Request�еĲ���map���õ�Response��data��
	private void copyParameters(Request request, Response response) {
		Map<String, Object> parameters = request.getParameters();
		for (String key : parameters.keySet()) {
			response.setData(key, parameters.get(key));
		}
	}
	
	//��һ�η�������Ӧת����XML�ַ���
	private String getResponseXML(Response response) {
		return XStreamUtil.toXML(response);
	}
	
	//���ַ���ת����һ��Request����
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
	
	//��Map�еõ�Action����, ����ò���, �򴴽�
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
