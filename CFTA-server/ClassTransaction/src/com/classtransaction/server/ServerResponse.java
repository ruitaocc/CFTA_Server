package com.classtransaction.server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.List;

import com.classtransaction.commons.Request;
import com.classtransaction.commons.Response;
import com.classtransaction.commons.ServerAction;
import com.classtransaction.model.Course;
import com.classtransaction.model.User;
import com.classtransaction.util.ApplicationContext;
import com.classtransaction.util.XStreamUtil;

public class ServerResponse implements ServerAction{

	@Override
	public void execute(Request request, Response response, Socket socket) {
		String type = (String)request.getParameter("type");
		System.out.println(type);
		if(type.equals("getusers")){
			try {
				PrintStream ps = new PrintStream(socket.getOutputStream(),true,"gb2312");
				List<User> users = ApplicationContext.userDao.findUsers();
				response.setData("users", users);
				response.setData("type", "getusers");
				ps.println(XStreamUtil.toXML(response));
				System.out.println(XStreamUtil.toXML(response));

			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		if(type.equals("getcourses")){
			try {
				//创建输出流
				PrintStream ps = new PrintStream(socket.getOutputStream(),true,"gb2312");
				//调用业务服务接口
				List<Course> courses = ApplicationContext.courseDao.findCourses();
				//打包数据
				response.setData("courses", courses);
				response.setData("type", "getcourses");
				//输出
				ps.println(XStreamUtil.toXML(response));
				//System.out.println(XStreamUtil.toXML(response));

			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		if(type.equals("finduser")){
			try {
				String userName = (String)request.getParameter("account");
				String password=(String)request.getParameter("password");
				PrintStream ps = new PrintStream(socket.getOutputStream(),true,"gb2312");
				User user = ApplicationContext.userDao.findUser(userName,password);
				response.setData("user", user);
				response.setData("type", "finduser");
				ps.println(XStreamUtil.toXML(response));
				System.out.println(XStreamUtil.toXML(response));

			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

}
