package com.zhl.oa.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhl.oa.dao.UserDao;
import com.zhl.oa.model.User;
import com.zhl.oa.model.UserRole;
import com.zhl.oa.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	/**
	 * 查询用户数
	 * 
	 * @return
	 */
	public int queryUserCount() {
		return userDao.queryUserCount();
	}

	/**
	 * 查询内容
	 * 
	 * @return
	 */
	public List<User> queryUser(int maxRowCount, int rows) {
		return userDao.queryUser(maxRowCount, rows);
	}

	/**
	 * 增加用户
	 * 
	 * @param user
	 */
	public void addUser(User user) {
		userDao.addUser(user);
	}

	/**
	 * 删除用户
	 * 
	 * @param id
	 */
	@Transactional(rollbackFor = Exception.class)
	public void deleteUser(int id) {
		userDao.deleteUser(id);
		userDao.deleteUserRoleByUserId(id);
	}

	/**
	 * 根据id查用户
	 * 
	 * @param id
	 * @return
	 */
	public User queryUserById(int id) {
		return userDao.queryUserById(id);
	}

	/**
	 * 编辑用户
	 * 
	 * @param user
	 */
	public void editUser(User user) {
		userDao.editUser(user);
	}

	/**
	 * 模糊查询人员
	 * 
	 * @param userName
	 * @return
	 */
	public List<User> queryUserByName(String userName) {
		return userDao.queryUserByName(userName);
	}

	/**
	 * 查询人员
	 * 
	 * @param userName
	 * @return
	 */
	public User queryUserByUserName(String userName) {
		return userDao.queryUserByUserName(userName);
	}

	/**
	 * 查询结果数
	 * 
	 * @param userName
	 * @return
	 */
	public int queryUserByNameCount(String userName) {
		return userDao.queryUserByNameCount(userName);
	}

	/**
	 * 查询用户角色关联
	 * 
	 * @param userId
	 * 
	 * @return roleId
	 */
	public int queryUserRoleById(Map<String, Integer> params) {
		return userDao.queryUserRoleById(params);
	}

	/**
	 * 删除用户角色关联
	 * 
	 * @param userId
	 */
	public void deleteUserRoleByUserId(int userId) {
		userDao.deleteUserRoleByUserId(userId);
	}

	/**
	 * 添加用户角色关联
	 * 
	 * @param userRole
	 */
	public void addUserRole(UserRole userRole) {
		userDao.addUserRole(userRole);
	}

	/**
	 * 根据用户id查询关联的角色id
	 * 
	 * @param userId
	 * @return roleId
	 */
	public List<Integer> queryRoleIdByUserId(int userId) {
		return userDao.queryRoleIdByUserId(userId);
	}
	
	/**
	 * 用户角色关联是否存在
	 * 
	 * @param userId
	 * @return
	 */
	public boolean isUserRoleExist(int userId) {
		if (userDao.queryCountByUserId(userId) > 0) {
			return true;
		} else {
			return false;
		}
	}
}
