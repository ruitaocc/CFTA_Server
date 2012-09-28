package com.classtransaction.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.classtransaction.dao.RoleDao;
import com.classtransaction.model.Role;


public class RoleDaoImpl extends BaseDaoImpl implements RoleDao {
	//¸ù¾Ýid²éÑ¯
	public Role find(String id) {
		String sql = "select * from T_ROLE ro where ro.id = '" + id + "'";
		List<Role> result = (List<Role>)getDatas(sql, new ArrayList(), Role.class);
		return result.size() == 1 ? result.get(0) : null;
	}
	public List<Role> findRoles() {
		String sql = "select * from T_ROLE";
		return (List<Role>)getDatas(sql, new ArrayList(), Role.class);
	}
	@Override
	public void addOne() {
		StringBuffer sql = new StringBuffer("insert into T_ROLE VALUES (ID, ");
		sql.append("'0','0','0','0','0','0','0')");
		
		getJDBCExecutor().executeUpdate(sql.toString());
		
	}	
}
