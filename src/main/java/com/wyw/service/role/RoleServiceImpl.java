package com.wyw.service.role;


import com.wyw.dao.BaseDao;
import com.wyw.dao.role.RoleDao;
import com.wyw.dao.role.RoleDaoImpl;
import com.wyw.pojo.Role;

import java.sql.Connection;
import java.util.List;

public class RoleServiceImpl implements RoleService{

	private RoleDao roleDao;

	public RoleServiceImpl(){
		roleDao = new RoleDaoImpl();
	}

	public List<Role> getRoleList() {
		Connection connection = null;
		List<Role> roleList = null;
		try {
			connection = BaseDao.getConnection();
			roleList = roleDao.getRoleList(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeResource(connection, null, null);
		}
		return roleList;
	}
	
}
