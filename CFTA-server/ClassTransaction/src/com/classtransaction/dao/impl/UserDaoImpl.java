package com.classtransaction.dao.impl;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.classtransaction.commons.Request;
import com.classtransaction.commons.Response;
import com.classtransaction.commons.ServerAction;
import com.classtransaction.dao.UserDao;
import com.classtransaction.model.Role;
import com.classtransaction.model.User;
import com.classtransaction.util.XStreamUtil;
import com.classtransaction.*;

public class UserDaoImpl extends BaseDaoImpl implements UserDao, ServerAction{

	//登录查询
	public User findUser(String userName, String password) {
		String sql = "select * from T_USER u where u.USER_NAME = '" + 
			userName + "' and u.PASS_WORD = '" +  password + "' and u.IS_DELETE = '0'";
		List<User> users = (List<User>)getDatas(sql, new ArrayList(), User.class);
		return users.size() == 1 ? users.get(0) : null;
	}

	//列出全部用户
	public List<User> findUsers() {
		String sql = "select * from T_USER u where u.IS_DELETE = '0'";
		List<User> users = (List<User>)getDatas(sql, new ArrayList(), User.class);
		return users;
	}

	public void save(User user) {
		StringBuffer sql = new StringBuffer("insert into T_USER VALUES (ID, '");
		sql.append(user.getUSER_NAME() + "', '")
		.append(user.getSNUMBER() + "', '")
		.append(user.getPASS_WORD() + "', '")
		
		.append(user.getGENDER() + "', '")
		.append(user.getBIRTHDAY() + "', '")
		.append(user.getADDRESS() + "', '")
		.append(user.getNATIVE_PLACE() + "', '")
		.append(user.getPHONE()+ "', '")
		.append(user.getSHORTPHONE() + "', '")
		.append(user.getEMAIL() + "', '")
		.append("0')");
		getJDBCExecutor().executeUpdate(sql.toString());
	}

	public User findUser(String userName) {
		String sql = "select * from T_USER u where u.USER_NAME = '" 
			+ userName +"' and u.IS_DELETE = '0'";
		List<User> users = (List<User>)getDatas(sql, new ArrayList(), User.class);
		return users.size() == 1 ? users.get(0) : null;
	}

	@Override
	public void delete(String id) {
		StringBuffer sql = new StringBuffer("update T_USER u");
		sql.append(" set u.IS_DELETE = '1'")
		.append(" where u.ID = '" + id + "'");
		getJDBCExecutor().executeUpdate(sql.toString());
	}

	public int getUserCount() {
		String sql = "select count(*) from T_USER u where u.IS_DELETE = '0'";
		return getJDBCExecutor().count(sql);
	}

	@Override
	public List<User> query(String realName) {
		String sql = "select * from T_USER u where u.USER_NAME like '%" 
			+ realName + "%' and u.IS_DELETE = '0'";
		List<User> users = (List<User>)getDatas(sql, new ArrayList(), User.class);
		return users;
	}

	public User find(String id) {
		String sql = "select * from T_USER u where u.ID = '" + id + "'";
		List<User> users = (List<User>)getDatas(sql, new ArrayList(), User.class);
		return users.size() == 1 ? users.get(0) : null;
	}

	
	public void execute(Request request, Response response, Socket socket) {
		try {
			PrintStream ps = new PrintStream(socket.getOutputStream(),true,"gb2312");
			List<User> users = findUsers();
		    response.setData("users", users);
		    ps.println(XStreamUtil.toXML(response));
		    System.out.println(XStreamUtil.toXML(response));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	
}
