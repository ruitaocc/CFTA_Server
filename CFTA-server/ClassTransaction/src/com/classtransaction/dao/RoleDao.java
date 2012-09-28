package com.classtransaction.dao;

import java.util.List;

import com.classtransaction.model.Role;


public interface RoleDao {

	/**
	 * ����ID���ҽ�ɫ
	 * @param id
	 * @return
	 */
	Role find(String id);
	
	/**
	 * ����ȫ���Ľ�ɫ
	 * @return
	 */
	List<Role> findRoles();
	
	/**
	 * ����һ��Ĭ��Ȩ��
	 * 
	 */
	void addOne();
	
}
