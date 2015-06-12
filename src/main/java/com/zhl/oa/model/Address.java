package com.zhl.oa.model;

/**
 * 通讯录实体类
 * 
 * @author 张宏亮
 * 
 */
public class Address {
	/**
	 * id
	 */
	private int id;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 电话
	 */
	private String mobile;

	/**
	 * 部门id
	 */
	private int deptId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
}
