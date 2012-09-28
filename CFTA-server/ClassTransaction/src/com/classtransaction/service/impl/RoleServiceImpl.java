package com.classtransaction.service.impl;

import java.util.List;

import com.classtransaction.dao.RoleDao;
import com.classtransaction.model.Role;
import com.classtransaction.model.User;
import com.classtransaction.service.BusinessException;
import com.classtransaction.service.RoleService;


public class RoleServiceImpl implements RoleService {

	private RoleDao roleDao;
	
	public RoleServiceImpl(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public List<Role> getRoles() {
		return this.roleDao.findRoles();
	}

	public void addRoleSynWithUser() {
		
			
			this.roleDao.addOne();
		
		
		
	}
	
	
}
