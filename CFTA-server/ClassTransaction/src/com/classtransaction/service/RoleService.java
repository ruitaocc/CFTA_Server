package com.classtransaction.service;

import java.util.List;

import com.classtransaction.model.Role;


public interface RoleService {

	/**
	 * ����ȫ���Ľ�ɫ
	 * @return
	 */
	List<Role> getRoles();
	/**
	 * �����һ���˵�ʱ��ͬʱ��ӵ�����Ȩ�޹���
	 * �޲���Ĭ��Ȩ��
	 */
	void addRoleSynWithUser();
}
