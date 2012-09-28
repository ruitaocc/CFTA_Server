package com.classtransaction.service;

import java.net.Socket;
import java.util.List;

import com.classtransaction.commons.Request;
import com.classtransaction.commons.Response;
import com.classtransaction.commons.ServerAction;
import com.classtransaction.model.User;


public interface UserService{

	/**
	 * 用户登录
	 * @param userName
	 * @param passwd
	 */
	void login(String userName, String passwd);
	
	/**
	 * 返回全部的用户
	 * @return
	 */
	List<User> getUsers();
	
	/**
	 * 添加一个用户
	 * @param user
	 */
	void addUser(User user);
	
	/**
	 * 删除用户
	 * @param id
	 */
	void delete(String id);
	
	/**
	 * 查询用户
	 * @param realName
	 * @return
	 */
	List<User> query(String realName);
	
	/**
	 * 执行客户端相关用户的请求
	 * @param request  请求类
	 * @param response  处理类
	 * @param socket   对应socket
	 * @return
	 */
	void execute(Request request, Response response, Socket socket);
}
