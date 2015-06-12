package com.zhl.oa.dto;


/**
 * 
 * @author 张宏亮
 * 
 */
public class AddressDto {
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

	/**
	 * 部门
	 */
	private String dept;

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

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

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
}
