package com.zhl.oa.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhl.oa.dao.RoleDao;
import com.zhl.oa.model.Role;
import com.zhl.oa.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;

	/**
	 * 查询角色数
	 * 
	 * @return
	 */
	public int queryRoleCount() {
		return roleDao.queryRoleCount();
	}

	/**
	 * 查询角色
	 * 
	 * @return
	 */
	public List<Role> queryRole(int maxRowCount, int rows) {
		return roleDao.queryRole(maxRowCount, rows);
	}

	/**
	 * 增加角色
	 * 
	 * @param role
	 */
	public void addRole(Role role) {
		roleDao.addRole(role);
	}

	/**
	 * 删除角色
	 * 
	 * @param id
	 */
	public void deleteRole(int id) {
		roleDao.deleteRole(id);
	}

	/**
	 * 根据id查角色
	 * 
	 * @param id
	 * @return
	 */
	public Role queryRoleById(int id) {
		return roleDao.queryRoleById(id);
	}

	/**
	 * 编辑角色
	 * 
	 * @param role
	 */
	public void editRole(Role role) {
		roleDao.editRole(role);
	}

	/**
	 * 查询角色
	 * 
	 * @param role
	 * @return
	 */
	public List<Role> queryRoleByName(String roleName) {
		return roleDao.queryRoleByName(roleName);
	}

	/**
	 * 查询结果数
	 * 
	 * @param roleName
	 * @return
	 */
	public int queryRoleByNameCount(String roleName) {
		return roleDao.queryRoleByNameCount(roleName);
	}

	/**
	 * 查询所有角色
	 * 
	 * @return
	 */
	public List<Role> queryRole() {
		return roleDao.queryRole();
	}
}
