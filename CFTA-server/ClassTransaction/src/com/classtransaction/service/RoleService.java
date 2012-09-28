package com.classtransaction.service;

import java.util.List;

import com.classtransaction.model.Role;


public interface RoleService {

	/**
	 * 查找全部的角色
	 * @return
	 */
	List<Role> getRoles();
	/**
	 * 在添加一个人的时候同时添加的他的权限管理
	 * 无参数默认权限
	 */
	void addRoleSynWithUser();
}
