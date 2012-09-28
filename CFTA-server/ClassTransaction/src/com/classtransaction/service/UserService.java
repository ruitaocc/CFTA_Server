package com.classtransaction.service;

import java.net.Socket;
import java.util.List;

import com.classtransaction.commons.Request;
import com.classtransaction.commons.Response;
import com.classtransaction.commons.ServerAction;
import com.classtransaction.model.User;


public interface UserService{

	/**
	 * �û���¼
	 * @param userName
	 * @param passwd
	 */
	void login(String userName, String passwd);
	
	/**
	 * ����ȫ�����û�
	 * @return
	 */
	List<User> getUsers();
	
	/**
	 * ���һ���û�
	 * @param user
	 */
	void addUser(User user);
	
	/**
	 * ɾ���û�
	 * @param id
	 */
	void delete(String id);
	
	/**
	 * ��ѯ�û�
	 * @param realName
	 * @return
	 */
	List<User> query(String realName);
	
	/**
	 * ִ�пͻ�������û�������
	 * @param request  ������
	 * @param response  ������
	 * @param socket   ��Ӧsocket
	 * @return
	 */
	void execute(Request request, Response response, Socket socket);
}
