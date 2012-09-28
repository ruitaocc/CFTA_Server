package com.classtransaction.util;

import com.classtransaction.commons.Request;
import com.classtransaction.dao.impl.UserDaoImpl;
import com.classtransaction.service.impl.UserServiceImpl;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * XStream工具类, 用于xml与对象之间的转换
 * 
 * @author ruitaocc@gmail.com
 * 
 */
public class XStreamUtil {

	private static XStream xstream = new XStream(new DomDriver());
	static{
		xstream.alias("com.class_transaction.commons.Request", Request.class);
		
		xstream.alias("com.classtransaction.dao.impl.UserDaoImpl", UserDaoImpl.class);
	}
	/**
	 * 将XML转换成对象
	 * @param xml
	 * @return
	 */
	public static Object fromXML(String xml) {
		
		//xstream.alias("serverActionClass", UserDaoImpl.class);
		return xstream.fromXML(xml);
	}
	
	/**
	 * 将对象转换成XML字段串
	 * @param obj
	 * @return
	 */
	public static String toXML(Object obj) {
		String xml = xstream.toXML(obj);
		//去掉换行
		String a = xml.replaceAll("\n", "");
		String s = a.replaceAll("\r", "");
		return s;
	}

}
