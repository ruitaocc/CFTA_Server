package com.classtransaction.dao;

import java.util.List;

import com.classtransaction.model.Role;


public interface RoleDao {

	/**
	 * 根据ID查找角色
	 * @param id
	 * @return
	 */
	Role find(String id);
	
	/**
	 * 查找全部的角色
	 * @return
	 */
	List<Role> findRoles();
	
	/**
	 * 加入一条默认权限
	 * 
	 */
	void addOne();
	
}
