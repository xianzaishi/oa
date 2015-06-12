package com.zhl.oa.constant;

public class Url {
	public static final String UMS_BASE = "/ums";

	public static final String INDEX = "/index";

	public static final String UMS_INDEX = UMS_BASE + "/index";

	public static final String UMS_LOGIN = UMS_BASE + "/login";

	/**
	 * 用户管理
	 */
	public static final String UMS_USER_MANAGEMENT = "/user/management";

	/**
	 * 部门管理
	 */
	public static final String UMS_DEPT_MANAGEMENT = "/dept/management";

	/**
	 * 获得所有用户
	 */
	public static final String UMS_USER_GET = "/user/get";

	/**
	 * 添加用户页面
	 */
	public static final String UMS_USER_ADD_PAGE = "/user/add";

	/**
	 * 添加用户
	 */
	public static final String UMS_ADD_USER = "/add/user";

	/**
	 * 删除用户
	 */
	public static final String UMS_DELETE_USER = "/user/delete/{id}";

	/**
	 * 编辑用户页面
	 */
	public static final String UMS_EDIT_USER_PAGE = "/user/edit/{id}";

	/**
	 * 编辑用户
	 */
	public static final String UMS_EDIT_USER = "/edit/user/{id}";

	/**
	 * 获得所有部门
	 */
	public static final String UMS_DEPT_GET = "/dept/get";

	/**
	 * 添加部门页面
	 */
	public static final String UMS_DEPT_ADD_PAGE = "/dept/add";

	/**
	 * 添加部门
	 */
	public static final String UMS_ADD_DEPT = "/add/dept";

	/**
	 * 删除部门
	 */
	public static final String UMS_DELETE_DEPT = "/dept/delete/{id}";

	/**
	 * 编辑部门页面
	 */
	public static final String UMS_EDIT_DEPT_PAGE = "/dept/edit/{id}";

	/**
	 * 编辑部门
	 */
	public static final String UMS_EDIT_DEPT = "/edit/dept/{id}";

	/**
	 * 查询部门页面
	 */
	public static final String UMS_SEARCH_DEPT = "/search/dept/{dept}";

	/**
	 * 查询部门
	 */
	public static final String UMS_SEARCH_DEPT_GET = "/search/dept/get/{dept}";

	/**
	 * 查询用户页面
	 */
	public static final String UMS_SEARCH_USER = "/search/user/{user}";

	/**
	 * 查询用户
	 */
	public static final String UMS_SEARCH_USER_GET = "/search/user/get/{userName}";

	/**
	 * 用户授权
	 */
	public static final String UMS_USER_AUTHORIZE = "/authorize/user/id/{id}";

	/**
	 * 用户授权
	 */
	public static final String UMS_USER_AUTHORIZE_SUBMIT = "/authorize/user/id/{userId}/role/id/{roleIds}";

	/**
	 * AccessDenied
	 */
	public static final String AccessDenied = "/403";
}
