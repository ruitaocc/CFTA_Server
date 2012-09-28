package com.classtransaction.util;

import com.classtransaction.commons.Request;
import com.classtransaction.dao.impl.UserDaoImpl;
import com.classtransaction.service.impl.UserServiceImpl;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * XStream������, ����xml�����֮���ת��
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
	 * ��XMLת���ɶ���
	 * @param xml
	 * @return
	 */
	public static Object fromXML(String xml) {
		
		//xstream.alias("serverActionClass", UserDaoImpl.class);
		return xstream.fromXML(xml);
	}
	
	/**
	 * ������ת����XML�ֶδ�
	 * @param obj
	 * @return
	 */
	public static String toXML(Object obj) {
		String xml = xstream.toXML(obj);
		//ȥ������
		String a = xml.replaceAll("\n", "");
		String s = a.replaceAll("\r", "");
		return s;
	}

}
