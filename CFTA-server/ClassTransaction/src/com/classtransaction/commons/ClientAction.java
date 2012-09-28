package com.classtransaction.commons;

import java.net.Socket;

/**
 * 客户端处理服务器响应的接口
 * 
 * @author ruitaocc@gmail.com
 * 
 */
public interface ClientAction {

	void execute(Response response);
}
