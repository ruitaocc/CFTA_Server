package com.classtransaction.dao.impl;

import java.sql.ResultSet;
import java.util.Collection;

import com.classtransaction.jdbc.JDBCExecutor;
import com.classtransaction.util.DataUtil;
import com.sun.beans.decoder.ValueObject;
/**
 * dao����
 * @author ruitaocc@gmail.com
 *
 */

public class BaseDaoImpl {
	//����JDBCExecutor����
	public JDBCExecutor getJDBCExecutor() {
		return JDBCExecutor.getJDBCExecutor();
	}
	
	//���ݲ�����SQL, ��Ž���ļ��϶���, �;�������ݿ�ӳ����󷵻�һ������
	public Collection getDatas(String sql, Collection<ValueObject> result, 
			Class clazz) {
		//ִ��SQL����ResultSet����
		ResultSet rs = getJDBCExecutor().executeQuery(sql);
		//��ResultSet���з�װ�����ؼ���
		return DataUtil.getDatas(result, rs, clazz);
	}
}
