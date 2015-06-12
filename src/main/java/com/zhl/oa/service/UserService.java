package com.zhl.oa.service;

import java.util.List;
import java.util.Map;

import com.zhl.oa.model.User;
import com.zhl.oa.model.UserRole;

public interface UserService {

	/**
	 * 查询用户数
	 * 
	 * @return
	 */
	public int queryUserCount();

	/**
	 * 查询内容
	 * 
	 * @return
	 */
	public List<User> queryUser(int maxRowCount, int rows);

	/**
	 * 增加用户
	 * 
	 * @param user
	 */
	public void addUser(User user);

	/**
	 * 删除用户
	 * 
	 * @param id
	 */
	public void deleteUser(int id);

	/**
	 * 根据id查用户
	 * 
	 * @param id
	 * @return
	 */
	public User queryUserById(int id);

	/**
	 * 编辑用户
	 * 
	 * @param user
	 */
	public void editUser(User user);

	/**
	 * 模糊查询人员
	 * 
	 * @param userName
	 * @return
	 */
	public List<User> queryUserByName(String userName);

	/**
	 * 查询人员
	 * 
	 * @param userName
	 * @return
	 */
	public User queryUserByUserName(String userName);

	/**
	 * 查询结果数
	 * 
	 * @param userName
	 * @return
	 */
	public int queryUserByNameCount(String userName);

	/**
	 * 查询用户角色关联
	 * 
	 * @param userId
	 * 
	 * @return roleId
	 */
	public int queryUserRoleById(Map<String, Integer> params);

	/**
	 * 删除用户角色关联
	 * 
	 * @param userId
	 */
	public void deleteUserRoleByUserId(int userId);

	/**
	 * 添加用户角色关联
	 * 
	 * @param userRole
	 */
	public void addUserRole(UserRole userRole);

	/**
	 * 根据用户id查询关联的角色id
	 * 
	 * @param userId
	 * @return roleId
	 */
	public List<Integer> queryRoleIdByUserId(int userId);

	/**
	 * 用户角色关联是否存在
	 * 
	 * @param userId
	 * @return
	 */
	public boolean isUserRoleExist(int userId);
}
