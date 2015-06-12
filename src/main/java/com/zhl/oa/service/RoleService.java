package com.zhl.oa.service;

import java.util.List;

import com.zhl.oa.model.Role;

/**
 * 角色Service
 * 
 * @author 张宏亮
 * 
 */
public interface RoleService {

	/**
	 * 查询角色数
	 * 
	 * @return
	 */
	public int queryRoleCount();

	/**
	 * 查询内容
	 * 
	 * @return
	 */
	public List<Role> queryRole(int maxRowCount, int rows);

	/**
	 * 增加角色
	 * 
	 * @param user
	 */
	public void addRole(Role role);

	/**
	 * 删除角色
	 * 
	 * @param id
	 */
	public void deleteRole(int id);

	/**
	 * 根据id查角色
	 * 
	 * @param id
	 * @return
	 */
	public Role queryRoleById(int id);

	/**
	 * 编辑角色
	 * 
	 * @param user
	 */
	public void editRole(Role role);

	/**
	 * 查询角色
	 * 
	 * @param role
	 * @return
	 */
	public List<Role> queryRoleByName(String roleName);

	/**
	 * 查询结果数
	 * 
	 * @param roleName
	 * @return
	 */
	public int queryRoleByNameCount(String roleName);

	/**
	 * 查询所有角色
	 * 
	 * @return
	 */
	public List<Role> queryRole();
}
