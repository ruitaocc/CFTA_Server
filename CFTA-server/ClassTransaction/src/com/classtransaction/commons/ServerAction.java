package com.classtransaction.commons;

import java.net.Socket;

/**
 * 服务器处理请求的接口
 * 
 *@author ruitaocc@gmail.com
 *每个执行请求的类都必须实现该接口
 */
public interface ServerAction {

	void execute(Request request, Response response, Socket socket);
}
