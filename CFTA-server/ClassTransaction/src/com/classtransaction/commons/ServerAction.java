package com.classtransaction.commons;

import java.net.Socket;

/**
 * ��������������Ľӿ�
 * 
 *@author ruitaocc@gmail.com
 *ÿ��ִ��������඼����ʵ�ָýӿ�
 */
public interface ServerAction {

	void execute(Request request, Response response, Socket socket);
}
