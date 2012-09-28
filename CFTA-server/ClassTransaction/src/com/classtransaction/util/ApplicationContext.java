package com.classtransaction.util;

import com.classtransaction.dao.CourseDao;
import com.classtransaction.dao.RoleDao;
import com.classtransaction.dao.UserDao;
import com.classtransaction.dao.impl.CourseDaoImpl;
import com.classtransaction.dao.impl.RoleDaoImpl;
import com.classtransaction.dao.impl.UserDaoImpl;
import com.classtransaction.model.User;
import com.classtransaction.server.Server;
import com.classtransaction.service.CourseService;
import com.classtransaction.service.RoleService;
import com.classtransaction.service.UserService;
import com.classtransaction.service.impl.CourseServiceImpl;
import com.classtransaction.service.impl.RoleServiceImpl;
import com.classtransaction.service.impl.UserServiceImpl;


public class ApplicationContext {

	//系统登录用户
	public static User loginUser;

	public static UserDao userDao;
	
	public static RoleDao roleDao;
	
	
	public static RoleService roleService;
	
	public static UserService userService;
	
	
	public static CourseDao courseDao;
	public static CourseService courseService;
	
	
	public static Server server;
	
	
	
	static {
		roleDao = new RoleDaoImpl();
		roleService = new RoleServiceImpl(roleDao);
		userDao = new UserDaoImpl();
		userService = new UserServiceImpl(userDao, roleDao);
		courseDao = new CourseDaoImpl();
		courseService = new CourseServiceImpl(courseDao);
		server = new Server();
	}

}
