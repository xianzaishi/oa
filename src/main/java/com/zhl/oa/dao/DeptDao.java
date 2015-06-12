package com.zhl.oa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhl.oa.model.Department;

/**
 * 部门Dao
 * 
 * @author 张宏亮
 * 
 */
@Repository
public class DeptDao extends BaseDao{
	/**
	 * 查询部门数
	 * 
	 * @return
	 */
	public int queryDeptCount() {
		return (Integer) getSqlMapClientTemplate().queryForObject("dept.queryDeptCount");
	}

	/**
	 * 查询部门
	 * 
	 * @return
	 */
	public List<Department> queryDept(int maxRowCount, int rows) {
		return (List<Department>) getSqlMapClientTemplate().queryForList("dept.queryDept", maxRowCount - rows, rows);
	}

	/**
	 * 查询部门
	 * 
	 * @return
	 */
	public List<Department> queryDept() {
		return (List<Department>) getSqlMapClientTemplate().queryForList("dept.queryDept");
	}

	/**
	 * 新增部门
	 * 
	 * @param dept
	 */
	public void addDept(Department dept) {
		getSqlMapClientTemplate().insert("dept.addDept", dept);
	}

	/**
	 * 删除部门
	 * 
	 * @param id
	 */
	public void deleteDept(int id) {
		getSqlMapClientTemplate().delete("dept.deleteDept", id);
	}

	/**
	 * 根据id查部门
	 * 
	 * @param id
	 * @return
	 */
	public Department queryDeptById(int id) {
		return (Department) getSqlMapClientTemplate().queryForObject("dept.queryDeptById", id);
	}

	/**
	 * 编辑部门
	 * 
	 * @param dept
	 */
	public void editDept(Department dept) {
		getSqlMapClientTemplate().update("dept.editDept", dept);
	}

	/**
	 * 查询部门
	 * 
	 * @param dept
	 * @return
	 */
	public List<Department> queryDeptByName(String dept) {
		return (List<Department>) getSqlMapClientTemplate().queryForList("dept.queryDeptByName", "%" + dept + "%");
	}

	/**
	 * 查询结果数
	 * 
	 * @param dept
	 * @return
	 */
	public int queryDeptByNameCount(String dept) {
		return (Integer) getSqlMapClientTemplate().queryForObject("dept.queryDeptByNameCount", "%" + dept + "%");
	}
}
