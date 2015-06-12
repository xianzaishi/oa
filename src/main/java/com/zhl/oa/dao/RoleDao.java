package com.zhl.oa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhl.oa.model.Role;

/**
 * 角色Dao
 * 
 * @author 张宏亮
 * 
 */
@Repository
public class RoleDao extends BaseDao{

	/**
	 * 查询角色数
	 * 
	 * @return
	 */
	public int queryRoleCount() {
		return (Integer) getSqlMapClientTemplate().queryForObject("role.queryRoleCount");
	}

	/**
	 * 查询角色
	 * 
	 * @return
	 */
	public List<Role> queryRole(int maxRowCount, int rows) {
		return (List<Role>) getSqlMapClientTemplate().queryForList("role.queryRole", maxRowCount - rows, rows);
	}

	/**
	 * 增加角色
	 * 
	 * @param role
	 */
	public void addRole(Role role) {
		getSqlMapClientTemplate().insert("role.addRole", role);
	}

	/**
	 * 删除角色
	 * 
	 * @param id
	 */
	public void deleteRole(int id) {
		getSqlMapClientTemplate().delete("role.deleteRole", id);
	}

	/**
	 * 根据id查角色
	 * 
	 * @param id
	 * @return
	 */
	public Role queryRoleById(int id) {
		return (Role) getSqlMapClientTemplate().queryForObject("role.queryRoleById", id);
	}

	/**
	 * 编辑角色
	 * 
	 * @param role
	 */
	public void editRole(Role role) {
		getSqlMapClientTemplate().update("role.editRole", role);
	}

	/**
	 * 查询角色
	 * 
	 * @param role
	 * @return
	 */
	public List<Role> queryRoleByName(String roleName) {
		return (List<Role>) getSqlMapClientTemplate().queryForList("role.queryRoleByName", "%" + roleName + "%");
	}

	/**
	 * 查询结果数
	 * 
	 * @param roleName
	 * @return
	 */
	public int queryRoleByNameCount(String roleName) {
		return (Integer) getSqlMapClientTemplate().queryForObject("role.queryRoleByNameCount", "%" + roleName + "%");
	}

	/**
	 * 查询所有角色
	 * 
	 * @return
	 */
	public List<Role> queryRole() {
		return (List<Role>) getSqlMapClientTemplate().queryForList("role.queryRole");
	}
}
