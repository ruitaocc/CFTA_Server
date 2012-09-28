package com.classtransaction.service.impl;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.List;

import com.classtransaction.commons.Request;
import com.classtransaction.commons.Response;
import com.classtransaction.dao.RoleDao;
import com.classtransaction.dao.UserDao;
import com.classtransaction.model.Role;
import com.classtransaction.model.User;
import com.classtransaction.service.BusinessException;
import com.classtransaction.service.UserService;
import com.classtransaction.util.ApplicationContext;
import com.classtransaction.util.XStreamUtil;


public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	private RoleDao roleDao;
	
	
	public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
		this.userDao = userDao;
		this.roleDao = roleDao;
	}
	
	public void login(String userName, String passwd) {
		User user = this.userDao.findUser(userName, passwd);
		//û���ҵ��û�, �׳��쳣
		if (user == null)throw new BusinessException("�û������������");
		Role role = this.roleDao.find(user.getID());
		user.setRole(role);
		System.out.print(user.getRole().getSUPER_AUTHORITY());
		if(user.getRole().getSUPER_AUTHORITY().equals("0"))throw new BusinessException("��ʹ�ó����˺ŵ�¼");
		
		ApplicationContext.loginUser = user;
	}

	public List<User> getUsers() {
		List<User> users = this.userDao.findUsers();
		for (User u : users) {
			Role role = this.roleDao.find(u.getID());
			u.setRole(role);
		}
		return users;
	}

	/*
	 * ����û�
	 * @see org.crazyit.transaction.service.UserService#addUser(org.crazyit.transaction.model.User)
	 */
	public void addUser(User user) {
		//�����µ��û���ȥ����, �ж��Ƿ������ͬ�û������û�
		User u = this.userDao.findUser(user.getUSER_NAME());
		if (u != null) throw new BusinessException("���û����Ѿ�����");
		this.userDao.save(user);
	}

	/*
	 * ɾ���û�, ���û���IS_DELETE������Ϊ1
	 * @see org.crazyit.transaction.service.UserService#delete(java.lang.String)
	 */
	public void delete(String id) {
		//���һ���û�����ɾ��
		if (this.userDao.getUserCount() <= 1) {
			throw new BusinessException("���һ���û�����ɾ��");
		}
		this.userDao.delete(id);
	}

	public List<User> query(String realName) {
		List<User> users = this.userDao.query(realName);
		for (User u : users) {
			Role role = this.roleDao.find(u.getID());
			u.setRole(role);
		}
		return users;
	}

	@Override
	public void execute(Request request, Response response, Socket socket) {
		try {
			PrintStream ps = new PrintStream(socket.getOutputStream(),true,"gb2312");
			List<User> users = this.userDao.findUsers();
		    response.setData("users", users);
		    ps.println(XStreamUtil.toXML(response));
		    System.out.println(XStreamUtil.toXML(response));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
}
