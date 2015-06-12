package com.zhl.oa.service;

import java.util.List;

import com.zhl.oa.model.Department;


/**
 * 部门Service
 * 
 * @author 张宏亮
 * 
 */
public interface DeptService {

	/**
	 * 查询部门数
	 * 
	 * @return
	 */
	public int queryDeptCount();

	/**
	 * 查询部门
	 * 
	 * @return
	 */
	public List<Department> queryDept(int maxRowCount, int rows);
	
	/**
	 * 查询部门
	 * 
	 * @return
	 */
	public List<Department> queryDept();

	/**
	 * 增加部门
	 * 
	 * @param dept
	 */
	public void addDept(Department dept);

	/**
	 * 删除部门
	 * 
	 * @param id
	 */
	public void deleteDept(int id);

	/**
	 * 根据id查部门
	 * 
	 * @param id
	 * @return
	 */
	public Department queryDeptById(int id);

	/**
	 * 编辑部门
	 * 
	 * @param dept
	 */
	public void editDept(Department dept);

	/**
	 * 查询部门
	 * 
	 * @param dept
	 * @return
	 */
	public List<Department> queryDeptByName(String dept);

	/**
	 * 查询结果数
	 * 
	 * @param dept
	 * @return
	 */
	public int queryDeptByNameCount(String dept);

}
