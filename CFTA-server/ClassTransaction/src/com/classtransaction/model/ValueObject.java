package com.classtransaction.model;

/**
 * 各个数据库表对象的父类
 * 
 */
public class ValueObject {

	//ID字段,对应数据库中的ID列
	private String ID;

	public String getID() {
		return ID;
	}

	public void setID(String id) {
		ID = id;
	}
	
}
